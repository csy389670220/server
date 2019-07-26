package com.cfets.cms.mapper;

import com.cfets.cms.model.Seckill;
import com.cfets.cms.model.vo.ItemSeckillVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SeckillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Seckill record);

    int insertSelective(Seckill record);

    Seckill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seckill record);

    int updateByPrimaryKey(Seckill record);

    /**
     * 查询秒杀列表
     * @param itemSeckillVo
     * @return
     */
    List<ItemSeckillVo> queryAll(ItemSeckillVo itemSeckillVo);

    /**
     * 根据秒杀ID查新单个秒杀详情
     * @param seckillId
     * @return
     */
    ItemSeckillVo queryById(@Param("seckillId") Integer seckillId);

    /**
     * 存储过程：成功秒杀记录落地+减库存
     * @param param
     */
    void killByProducer(Map<String,Object> param);
}