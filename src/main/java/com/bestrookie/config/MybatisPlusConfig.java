package com.bestrookie.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author bestrookie
 * @version 1.0
 * @date 2021/7/13 15:57
 */
@Configuration
@MapperScan("com.bestrookie.mapper")
public class MybatisPlusConfig {
    //乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
    //分页插件
    @Bean
    public  PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
    //逻辑删插件
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
    @Bean
    @Profile({"dev","test"})//设置dev test 环境开启，保证我们的效率
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000);//设置sql执行的最大时间，如果超过了则不执行
        performanceInterceptor.setFormat(true);
        return  performanceInterceptor;
    }


}
