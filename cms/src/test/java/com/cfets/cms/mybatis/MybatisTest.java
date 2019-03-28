package com.cfets.cms.mybatis;

import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages="com.cfets.cms.mapper")
public class MybatisTest {
    /**
     * 测试springBoot整合mybatis连通性
     */
    @Test
    public void test01() {
    }
}
