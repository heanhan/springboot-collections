# Getting Started

### Springboot-data-redis  Documentation
在代码中注入RedisTemplate，源码分析

`@Configuration
 2
 @ConditionalOnClass(RedisOperations.class)
 3
 @EnableConfigurationProperties(RedisProperties.class)
 4
 @Import({ LettuceConnectionConfiguration.class, JedisConnectionConfiguration.class })
 5
 public class RedisAutoConfiguration {
 6
 7
     @Bean
 8
     @ConditionalOnMissingBean(name = "redisTemplate")
 9
     public RedisTemplate<Object, Object> redisTemplate(
 10
             RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
 11
         RedisTemplate<Object, Object> template = new RedisTemplate<>();
 12
         template.setConnectionFactory(redisConnectionFactory);
 13
         return template;
 14
     }
 15
 16
     @Bean
 17
     @ConditionalOnMissingBean
 18
     public StringRedisTemplate stringRedisTemplate(
 19
             RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
 20
         StringRedisTemplate template = new StringRedisTemplate();
 21
         template.setConnectionFactory(redisConnectionFactory);
 22
         return template;
 23
     }
 24
 25
 }`
