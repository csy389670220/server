package com.example.client.controller;

import com.example.client.model.IdCardInfo;
import com.example.client.util.CheckUtil;
import com.example.client.util.IdCardInfoUtil;
import com.example.client.util.ResultMapUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Map;


@Controller
@ResponseBody
public class BaseController implements Serializable {
    private static final Logger logger= LoggerFactory.getLogger(BaseController.class);
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/hi")
    public String  home(String  name){
        return "hi "+name+",i am from port:" +port;
    }

    @RequestMapping(value = "/verification")
    public Map<String, Object> verification(String  cardName, String cardID, String startDate, String endDate){
        if(CheckUtil.isEmpty(cardName)){
            //身份证姓名为空
            return   ResultMapUtil.success("1001");
        }
        if(CheckUtil.isEmpty(cardID)){
            //身份证号码为空
            return   ResultMapUtil.success("1002");
        }
        if(CheckUtil.isEmpty(startDate)){
            //身份证起始日期为空
            return   ResultMapUtil.success("1003");
        }
        if(CheckUtil.isEmpty(endDate)){
            //身份证结束日期为空
            return   ResultMapUtil.success("1004");
        }
        //本地数据
        IdCardInfo baseIdCardInfo=IdCardInfoUtil.getIdCardInfoById(cardID);
        if(CheckUtil.isEmpty(baseIdCardInfo)){
            //该居民不存在
            return   ResultMapUtil.success("1005");
        }
        //上传数据
        IdCardInfo idCardInfo=new IdCardInfo(cardName,cardID,startDate,endDate);

        boolean data=baseIdCardInfo.equals(idCardInfo);
        if(data){
            //匹配成功
            return   ResultMapUtil.success("1000");
        }else {
            //匹配失败，信息错误
            return   ResultMapUtil.success("1006");
        }
    }


}
