# Getting Started

### Mybatis 3.5 Documentation
关于持久层mybatis 3.5.X版本的学习笔记:

* [Official Apache Maven documentation](http://www.mybatis.org/mybatis-3/zh/getting-started.html)

**入门**

    1、MyBatis 是一款优秀的持久层框架（ORM），它支持定制化 SQL、存储过程以及高级映射。
    
    maven构建项目：
        
        `
            <dependency>
              <groupId>org.mybatis</groupId>
              <artifactId>mybatis</artifactId>
              <version>x.x.x</version>
            </dependency>
            
        `
        
    使用mybatis 的核心：基于mybatis的应用核心都是SqlSessionFactory的实例为核心。对外界通过器工厂构建的SqlSession对数据库进行cruid(增删改查)操作。
 
    2、构建SqlSessionFactory:
        
       方式一：从xml中构建
       
       SqlSessionFactory 的实例可以通过SqlSqlSessionFactoryBuilder 获得，而SqlSessionFactoryBuilder
    则可以通过xml配置文件中或者预先配置的Configuration的实例中构建。（建议使用类路径下的资源文件进行配置。Mybatis提供一个Resources 工具类）
    
    ‘
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resource.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
        
        --- mybatis-config.xml的配置文件和mapper 文件  --
        
        <?xml version="1.0" encoding="UTF-8" ?>
        <!DOCTYPE configuration
          PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
          "http://mybatis.org/dtd/mybatis-3-config.dtd">
        <configuration>
          <environments default="development">
            <environment id="development">  //配置环境
              <transactionManager type="JDBC"/>  //配置事务，
              <dataSource type="POOLED">   //配置连接池 
                <property name="driver" value="${driver}"/> //一下四项配置mysql的四个属性。
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
              </dataSource>
            </environment>
          </environments>
          <mappers>
            <mapper resource="com/mybatis/example/BlogMapper"/>//注册配置文件mapper
          </mappers>
        </configuration>
        
        --
        
         <?xml version="1.0" encoding="UTF-8" ?>
                <!DOCTYPE mapper
                  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
                  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
                <mapper namespace="com.mybatis.example.BlogMapper">
                  <select id="selectBlog" resultType="Blog">
                    select * from Blog where id = #{id}
                  </select>
                </mapper>
        
        
        
    ’
    
        方式二：直接使用java 代码构建。
        
        `
            DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();  //自定义创建一个实体类BlogDataSourceFactory，设置mysql连接的属性。
            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment("development", transactionFactory, dataSource);
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(BlogMapper.class);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        
        `
        获取SqlSessionFactory 后获取SqlSession对象。
            
        ‘
            
            try(SqlSession sqlSession = sqlSessionFactory.openSession()){
                BlogMapper blogMapper=sqlSession.getMapper(BlogMapper.class);
                blogMapper.selectBlog(101);
            }
            
            
        ’
        命名空间（namespace）较之前版本，现在必须指定。
                作用：1：利用更长的完全限定名来将不同的语句隔离开。
                     2：实现接口绑定。
        注： 以上作为了解，以后这些由spring等容器管理。
        
        

        
** 作用域（scop）和生命周期 **（错误的使用造成并发问题）

    1、SqlSessionFactoryBuilder 
        
          这个类可以被实例化、使用、销毁。一旦创建了SqlSessionFactory ,就不再需要他了。因此它的作用域是方法作用域。
       
    2、SqlSessionFactory
    
          SqlSessionFactory一旦被创建，就应该在应用运行期间一直存在，因此也别称为重量级对象。作用域在贯穿整个应用的生命周期。
       
    3、SqlSession
    
          为外界提供操作数据库的接口，，作用于在一个请求的方法内。     

        

