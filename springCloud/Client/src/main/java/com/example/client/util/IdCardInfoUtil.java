package com.example.client.util;

import com.example.client.model.IdCardInfo;

import java.util.HashMap;
import java.util.Map;

public class IdCardInfoUtil {
    private static Map<String,IdCardInfo> getResource(){
        Map<String,IdCardInfo> resource=new HashMap<String,IdCardInfo>();
        IdCardInfo c1=new IdCardInfo("程思雨","340711199211082533","20001010","20201010");
        IdCardInfo c2=new IdCardInfo("王宁","340711199211092533","20001017","202010107");
        IdCardInfo c3=new IdCardInfo("张清","340711198002092533","20000101","20200101");
        resource.put(c1.getCardID(),c1);
        resource.put(c2.getCardID(),c2);
        resource.put(c3.getCardID(),c3);
        return resource;
    }


    public static IdCardInfo getIdCardInfoById(String cradId){
        Map<String,IdCardInfo> resource=getResource();
        IdCardInfo info= resource.get(cradId);
        return info;

    }

}
