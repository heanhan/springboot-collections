# Getting Started

### Springboot-data-redis  Documentation
在代码中注入RedisTemplate，源码分析

`

    @Configuration
     @ConditionalOnClass(RedisOperations.class)
     @EnableConfigurationProperties(RedisProperties.class)
     @Import({ LettuceConnectionConfiguration.class, JedisConnectionConfiguration.class })
     public class RedisAutoConfiguration {
         @Bean
         @ConditionalOnMissingBean(name = "redisTemplate")
         public RedisTemplate<Object, Object> redisTemplate(
                 RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
             RedisTemplate<Object, Object> template = new RedisTemplate<>();
             template.setConnectionFactory(redisConnectionFactory);
             return template;
         }
         @Bean
         @ConditionalOnMissingBean
         public StringRedisTemplate stringRedisTemplate(
                 RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
             StringRedisTemplate template = new StringRedisTemplate();
             template.setConnectionFactory(redisConnectionFactory);
             return template;
         }
     }
     
 `


**注：****spring Boot 2.X 以后的版本 默认使用的redis 的连接客户端的工具变为 Lettuce,不在是jedis.**

使用连接Redis的Client 之 Lettuce  与Jedis 的区别

    
`

Lettuce 和 Jedis 的定位都是Redis的client，所以他们当然可以直接连接redis server。

Jedis在实现上是直接连接的redis server，如果在多线程环境下是非线程安全的，这个时候只有使用连接池，为每个Jedis实例增加物理连接

Lettuce的连接是基于Netty的，连接实例（StatefulRedisConnection）可以在多个线程间并发访问，应为StatefulRedisConnection是线程安全的，所以一个连接实例（StatefulRedisConnection）就可以满足多线程环境下的并发访问，当然这个也是可伸缩的设计，一个连接实例不够的情况也可以按需增加连接实例。


`

**使用注意事项：**

`

如果使用lettuce 连接redis ，不应如下面pom  ，会抛 Caused by: java.lang.ClassNotFoundException: org.apache.commons.pool2.impl.GenericObjectPoolConfig
     原因：缺少依赖pom
            <dependency>
                 <groupId>org.apache.commons</groupId>
                 <artifactId>commons-pool2</artifactId>
                 <version>2.6.2</version>
             </dependency>
             
             
  `

