package com.learn.session;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @describe:
 * @create 2018-03-28 16:16
 **/
@Configuration
@MapperScan("com.learn.session.dao")
public class MyBatisConfig {
}
