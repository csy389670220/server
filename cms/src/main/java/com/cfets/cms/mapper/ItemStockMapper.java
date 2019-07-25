package com.cfets.cms.mapper;

import com.cfets.cms.model.ItemStock;
import org.apache.ibatis.annotations.Param;

public interface ItemStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemStock record);

    int insertSelective(ItemStock record);

    ItemStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemStock record);

    int updateByPrimaryKey(ItemStock record);

    /**
     * 减库存
     * @param itemId 商品ID
     * @return
     */
    int reduceNumber(@Param("itemId")Integer itemId);
}