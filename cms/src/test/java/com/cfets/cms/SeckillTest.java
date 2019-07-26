package com.cfets.cms;

import com.cfets.cms.mapper.ItemStockMapper;
import com.cfets.cms.mapper.SeckillMapper;
import com.cfets.cms.model.Seckill;
import com.cfets.cms.model.vo.ItemSeckillVo;
import com.cfets.cms.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 秒杀页面测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SeckillTest {
    @Autowired
    SeckillMapper seckillMapper;

    @Autowired
    ItemStockMapper itemStockMapper;

    @Autowired
    SeckillService seckillService;

    @Test
    public void queryById() {
        ItemSeckillVo itemSeckillVo = seckillMapper.queryById(2);
        System.out.println(
                "getId:" + itemSeckillVo.getId() + ";getItemStatus:" + itemSeckillVo.getItemStatus() +
                        ";getSeckillId:" + itemSeckillVo.getSeckillId() + ";getImgUrl:" + itemSeckillVo.getImgUrl() +
                        ";getName:" + itemSeckillVo.getName() + ";getStock:" + itemSeckillVo.getStock() +
                        ";getPrice:" + itemSeckillVo.getPrice() + ";getSeckillPrice:" + itemSeckillVo.getSeckillPrice());
    }

    @Test
    public void queryAll() {
        ItemSeckillVo itVo = new ItemSeckillVo();
        Date now = new Date();
        //查询出商品有效上架，秒杀未开始或者进行中的数据
        itVo.setItemStatus(1);
        List<ItemSeckillVo> list = seckillMapper.queryAll(itVo);
        for (ItemSeckillVo itemSeckillVo : list) {
            System.out.println(
                    ">>>>>>>>>>>>>>.getId:" + itemSeckillVo.getId() + ";getItemStatus:" + itemSeckillVo.getItemStatus() +
                            ";getSeckillId:" + itemSeckillVo.getSeckillId() + ";getImgUrl:" + itemSeckillVo.getImgUrl() +
                            ";getName:" + itemSeckillVo.getName() + ";getStock:" + itemSeckillVo.getStock() +
                            ";getPrice:" + itemSeckillVo.getPrice() + ";getSeckillPrice:" + itemSeckillVo.getSeckillPrice()+
                            ";getStartTime:"+itemSeckillVo.getStartTime()+";getEndTime:"+itemSeckillVo.getEndTime());

        }
    }

    @Test
    public void reduceNumber() {
        int num = itemStockMapper.reduceNumber(1);
        System.out.println(">>>>>>>>>>>>" + num);
    }


    @Test
    public void exportSeckillUrl(){
        String md5=seckillService.exportSeckillUrl(1);
        System.out.println(">>>>>>>>>>>>>."+md5);
    }

    @Test
    public void executeSeckillProducer(){
        Map<String, Object> result= seckillService.executeSeckillProducer(1,1,3,"");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+result.get("code")+result.get("data"));
    }
}
