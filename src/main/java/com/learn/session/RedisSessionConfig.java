package com.learn.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author
 * @describe:
 * @create 2018-03-26 17:32
 **/
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
}
