package com.cfets.cms;

import com.cfets.cms.util.MD5;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 集中shiro过程中测试类
 */
@SpringBootTest
public class shiroTest {
    @Test
    public void test01() {
        String MD5val=MD5.encodeByMD5("admin");
        System.out.println(MD5val);
    }
}
