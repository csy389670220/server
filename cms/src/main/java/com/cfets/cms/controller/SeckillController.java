package com.cfets.cms.controller;

import com.cfets.cms.error.BusinessException;
import com.cfets.cms.error.EmBusinessError;
import com.cfets.cms.model.vo.ItemSeckillVo;
import com.cfets.cms.service.SeckillService;
import com.cfets.cms.util.ResultMapUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 秒杀商品控制类
 */
@Controller
@ResponseBody
@RequestMapping("seckill")
public class SeckillController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(SeckillController.class);

    @Autowired
    SeckillService seckillService;

    @RequestMapping(value = "/query")
    public ModelAndView query() {
        ModelAndView modelAndView = new ModelAndView("skill/skill");
        List<ItemSeckillVo> list = seckillService.getSeckillList();
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @RequestMapping(value = "/{userId}/{seckillId}/detail",method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("userId") Integer userId,
                               @PathVariable("seckillId") Integer seckillId) {
        ModelAndView modelAndView = new ModelAndView("skill/detail");
        ItemSeckillVo itemSeckillVo = seckillService.getById(userId,seckillId);
        modelAndView.addObject("itemSeckillVo", itemSeckillVo);
        return modelAndView;
    }

    /**
     * 获取当前系统时间
     * @return
     */
    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    public long time(){
        Date now = new Date();
        return now.getTime();
    }

    /**
     * 获取MD5
     */
    @RequestMapping(value = "/{seckillId}/exposer",method = RequestMethod.GET)
    public String  exposer(@PathVariable("seckillId") Integer secklillId){
       String md5=seckillService.exportSeckillUrl(secklillId);
       return md5;
    }

    /**
     * 执行秒杀
     * @return
     */
    @RequestMapping(value = "/{md5}/execution",method = RequestMethod.POST)
    public Map<String, Object> execute(@PathVariable("md5")String md5,
                                       @RequestParam("itemId") Integer itemId,
                                       @RequestParam("seckillId") Integer seckillId ,
                                       @RequestParam("userId") Integer userId ){
        try {
            Map<String, Object> result=seckillService.executeSeckill(itemId,seckillId,userId,md5);
            return result;

        }catch (DuplicateKeyException e){
            logger.error("execution DuplicateKeyException is :"+e.getMessage(),e);
            return ResultMapUtil.build(EmBusinessError.SECKILL_REPEAT_ERROR);
        } catch(BusinessException e){
            logger.error("execution BusinessException is :"+e.getErrMsg(),e);
            return ResultMapUtil.build(String.valueOf(e.getErrCode()),e.getErrMsg());
        } catch (Exception e) {
            logger.error("execution Exception is :"+e.getMessage(),e);
            return ResultMapUtil.build(EmBusinessError.SECKILL_EXECUTE_ERROR);
        }

    }

    /**
     * 执行秒杀 by 存储过程
     * @return
     */
    @RequestMapping(value = "/{md5}/executionProducer")
    public Map<String, Object> executeProducer(@PathVariable("md5")String md5,
                                       @RequestParam("itemId") Integer itemId,
                                       @RequestParam("seckillId") Integer seckillId ,
                                       @RequestParam("userId") Integer userId ){

       return seckillService.executeSeckillProducer(itemId,seckillId,userId,md5);
    }

}
