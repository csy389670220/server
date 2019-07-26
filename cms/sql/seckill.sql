-- 秒杀存储过程
DELIMITER $$ -- console; 转换为$$
-- 定义存储过程
-- 参数:in 输入参数; out 输出参数
-- row_count():返回上一条修改类型sql的影响行数
-- row_count: 0:未修改数据 >0: 表示修改的行数 <0: sql错误/未执行修改sql
CREATE PROCEDURE `execute_seckill`
  (in v_seckill_id INTEGER,in v_user_id INTEGER,
   in v_item_id INTEGER,in v_sekcill_time TIMESTAMP,out r_result INTEGER)
  BEGIN
    DECLARE insert_count int DEFAULT 0;
    start TRANSACTION ;
    INSERT IGNORE INTO t_success_skill
    (skill_id, user_id,status,create_time)
      VALUES (v_seckill_id,v_user_id,'1',v_sekcill_time);
    select row_count() into insert_count;
    if(insert_count =0) THEN
      ROLLBACK ;
      set r_result = -1;
    ELSEIF (insert_count<0)THEN
      ROLLBACK ;
      SET r_result = -2;
    ELSE
        UPDATE t_item_stock
        set stock = stock-1
        WHERE item_id = v_item_id
          AND stock > 0;
        SELECT row_count() INTO insert_count;
        if(insert_count=0)THEN
          ROLLBACK ;
          SET  r_result = 0;
        ELSEIF (insert_count<0)THEN
          ROLLBACK ;
          SET r_result = -2;
        ELSE
          COMMIT ;
          SET r_result =1;
        END IF;
      END IF ;
    END ;
$$
-- 存储过程定义结束
DELIMITER ;
set @r_result = -3;
-- 执行存储过程
  call execute_seckill(1,3,1,now(),@r_result);
--
-- -- 获取结果
SELECT @r_result;

-- 存储过程
-- 1:存储过程优化:事务行级锁持有的时间
-- 2:不要过度依赖存储过程,不常用，大量用于银行业务中
-- 3:简单的逻辑可以应用存储过程
-- 4:QPS:一个秒杀单6000/qps

