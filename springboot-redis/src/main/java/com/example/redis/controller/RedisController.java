package com.example.redis.controller;

import com.example.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhaojh
 * @date : 2019-07-05
 * @function : reids的使用，代码中注入RedisTemplate
 */

@RestController
@RequestMapping(value="/redis")
public class RedisController {
    /**
     *
     *
     *
     * 注 ：  SpringBoot自动帮我们在容器中生成了一个RedisTemplate和一个StringRedisTemplate。
     *          缺点： 1、这个RedisTemplate的泛型是<Object,Object>，写代码不方便，需要写好多类型转换的代码；我们需要一个泛型为<String,Object>形式的RedisTemplate。
     *                2、这个RedisTemplate没有设置数据存在Redis时，key及value的序列化方式。
     *          解决方式：
     *                1、@ConditionalOnMissingBean注解后，Spring容器中有了RedisTemplate对象了，这个自动配置的RedisTemplate不会实例化。
     *                因此我们可以直接自己写个配置类，配置RedisTemplate。
     *
     *
     * 为什么能在代码中注入RedisTemplate？
     *      源码分析
     *
     * @Configuration
     * @ConditionalOnClass(RedisOperations.class)
     * @EnableConfigurationProperties(RedisProperties.class)
     * @Import({ LettuceConnectionConfiguration.class, JedisConnectionConfiguration.class })
     * public class RedisAutoConfiguration {
     *     @Bean
     *     @ConditionalOnMissingBean(name = "redisTemplate") RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
     *         RedisTemplate<Object, Object> template = new RedisTemplate<>();
     *         template.setConnectionFactory(redisConnectionFactory);
     *         return template;
     *     }
     *     @Bean
     *     @ConditionalOnMissingBean
     *     public StringRedisTemplate stringRedisTemplate( RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
     *         StringRedisTemplate template = new StringRedisTemplate();
     *         template.setConnectionFactory(redisConnectionFactory);
     *         return template;
     *     }
     * }
     *
     *
     */


    @Autowired
    private RedisUtil redisUtil;



    @PostMapping(value="/addUserInfo")
    public String addUserInfo(){

        return null;
    }



}
