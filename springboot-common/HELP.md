# Getting Started

### springboot-common 工具类描述  Documentation
    本服务的功能作为springboot-collections 的工具类，抽取每个springboot服务公共属性方法，存放公共的工具类，方便每个服务进行调用:

**工具 一、**
    
    包装同一消息返回体的形式
        
**工具 二、**

    添加雪花算法，用于生成id,由于UUID 在分布式下是不安全的，所以以后我的所有ID生成采用雪花算法。
    
**工具 三、**

    JWT的token令牌的生成工具与解析工具。

