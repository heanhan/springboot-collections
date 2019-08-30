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
  
  
  
  关于redis 常涉及到的知识点：
    
    1、什么是redis
    Redis是一个基于内存的高性能的 key-value数据库。
    
    2、redis的特点
    redis 本质是一个key-value 类型的内存数据库，很像memcached,整个数据库统统加载在内存中进行操作，定期通过异步操作吧数据库数据flush到硬盘上保存。
    因为是纯内存的操作，redis的性能非常出色，每秒可以处理超过10万次的读写操作，是已知性能最快的key-value 数据库之一。
    redis的出色之处不仅仅是性能，redis最大魅力是支持多种数据结构，此外单个value的最大限制为1G,不像mencached只能保存1MB的数据，因此redis可以用来实现很多有用的
    功能。比如说，他的List来做FIFO双向链表，实现一个轻量级的高性能的消息队列服务，用他的Set可以做高性能的Tag系统。另外redis 也可以对存入的key-value设置expire
    时间，因此也可以当做一个功能加强版的memcached来用。
    redis的主要缺点，数据库容易受到物理数据的限制，不能做海量数据的高性能读写。因此Redis适合做场景主要局限在小量数据的高性能操作和运算上。
    
    3、使用redis有哪些好处。
        1.速度快，因为数据存在内存中，类似于HashMap,HashMap的优势就是查找和操作的时间复杂度都是O(1).
        2.支持丰富的数据结构，支持string,list，sorted,set,hash.
        3.支持事务，操作都是原子性，所谓的原子性就是对数据的更改要吗全部执行，要吗全部不执行。
        4.丰富的特性，可用于缓存，消息。

    4.redis相比memcached有哪些优势？
        1.memcached所有的值均是简单的字符串，redis作为其替代者，支持更为丰富的数据类型 
        2.redis的速度比memcached快很多
        3.redis可以持久化其数据
    