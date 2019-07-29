package com.cfets.cms;

import com.cfets.cms.util.AESUtil;
import com.cfets.cms.util.MD5;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

/**
 * 系统集中测试类
 */
@SpringBootTest
public class CmsSysTest {

    /**
     * 数据库信息加密解密测试
     * 秘钥: iisuser_db_key
     */
    @Test
    public void test01() {
        /**
         * 第一种
         */
        String content = "root";
        String password = "iisuser_db_key";//解密私钥
        //加密
        System.out.println("加密前：" + content);
        byte[] encryptResult = AESUtil.encrypt(content, password);
        String encryptResultStr = AESUtil.parseByte2HexStr(encryptResult);
        System.out.println("加密后：" + encryptResultStr);
        //解密
        byte[] decryptFrom = AESUtil.parseHexStr2Byte(encryptResultStr);
        byte[] decryptResult = AESUtil.decrypt(decryptFrom, password);
        System.out.println("解密后：" + new String(decryptResult));

    }

    /**
     * shiro密码MD5加密
     * 加密方式+加密内容+盐值+加密次数
     */
    @Test
    public void test02() {
        System.out.println(">>>>>>>>>>" +
                new SimpleHash("md5", "123456", ByteSource.Util.bytes("cms"), 2).toHex());
    }


    @Test
    public void random() {
            Random r = new Random(1);
            for (int i = 0; i < 5; i++) {
                int ran1 = r.nextInt(10000000);
                System.out.println(ran1);
            }
    }
}
