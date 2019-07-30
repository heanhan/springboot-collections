# Getting Started

### Spring-data-jpa Documentation

Spring-data-jpa 知识点

**一、*ORM概述（Object Relation Mapping 对象关系映射）*


`
    

`


**附加**

`

    @Modifying注解
    
    1、在@Query注解中编写JPQL实现DELETE和UPDATE操作时候必须加上@Modifying注解，通知Spring Data这是一个delete或者updata操作
    
    2、 updata和delete操作需要使用事务，此时需要定义service层，在service方法上添加事务操作
    
    3、 注意JPQL不支持insert操作
    
    @Query 如果在注解中添加 nativeQuery=true 是支持原生SQL查询
    
    
    
    
    使用自定义疏解（实质是基于切面）
    
    
    

`

