package com.github.springbootmiaosha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lizhangyu
 * @Date 2019-06-19
 */
@SpringBootApplication
public class SpringbootMiaoshaApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootMiaoshaApplication.class);

    public static void main(String[] args) {
        logger.info("SpringBoot开始加载");
        SpringApplication.run(SpringbootMiaoshaApplication.class, args);
        logger.info("SpringBoot加载完毕");
    }

}
