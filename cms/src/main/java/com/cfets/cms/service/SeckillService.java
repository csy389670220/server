package com.cfets.cms.service;

import com.cfets.cms.error.BusinessException;
import com.cfets.cms.model.Seckill;
import com.cfets.cms.model.vo.ItemSeckillVo;

import java.util.List;
import java.util.Map;

public interface SeckillService {

    /**
     *  查询所有秒杀记录
     * @return
     */
    List<ItemSeckillVo> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param userId  用户ID
     * @param seckillId 秒杀活动ID
     * @return
     */
    ItemSeckillVo getById(Integer userId,Integer seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址,
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     */
    String exportSeckillUrl(Integer seckillId);

    /**
     * 执行秒杀操作
     * @param itemId
     * @param seckillId
     * @param userId
     * @param md5
     */
    Map<String, Object> executeSeckill(Integer itemId, Integer seckillId, Integer userId, String md5)
            throws BusinessException,Exception;

    /**
     * 执行秒杀操作by 存储过程
     * @param itemId
     * @param seckillId
     * @param userId
     * @param md5
     */
    Map<String, Object> executeSeckillProducer(Integer itemId,Integer seckillId, Integer userId, String md5);
}
