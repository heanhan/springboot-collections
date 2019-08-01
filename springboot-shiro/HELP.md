**Apache Shiro 的知识点学习**

    Apache Shiro是一个功能强大的、灵活的、开源的安全框架。它可以干净利落的处理身份验证、授权、企业会话管理和机密。
    
    功能可以做什么：
    
        1、验证用户身份。
        2、用户的访问控制。判断用户是否分配了一定的安全角色、判断用户是否被授予完成某个操作。
        3、web下任意使用Session API
        4、可以响应认证、访问控制，或者Session生命周期中发生的事。
        5、支持单点登录。
        6、支持remember ME 服务。
        ......
        
    特性：一下四大特性是Shiro的应用安全的四大基石。
        1、Authentication(认证)
            用户的身份识别，通常被称为用户的  登录
        2、Authorization(授权)
        访问控制，比如某个用户是否具有某个操作的权限
        3、Session Management(会话管理)
        特定用于用户的会话的管理
        4、Cryptography(加密)
        在对数据源使用加密算法加密的同时，保证易用使用。
    
    高级概述：
        
        在概念层，Shiro 架构包含三个主要的理念：Subject，SecurityManager和 Realm。
        
        1、Subject
        当前用户，Subject 可以是一个人，但也可以是第三方服务、守护进行、时钟守护任务，或者其他当前和软件交互的的任何事件。
        
        2、SecurityManager
        g管理所有的Subject、SecurityManager是shiro的核心，配合内部安全组件组成安全伞。
        
        3、Realms 
        用户进行权限信息认证，我们自己实现，。Realm实质上是一个特定的安全DAO,它内部封装数据源连接的细节。
        得到Shiro所需要的相关的数据。在配置Shiro的时候，你必须指定至少一个Realm来认证。
        
        【注】我们需要实现Realms的Authentication 和 Authorization。
        其中 Authentication 是用来验证用户身份，Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，
        如访问某个链接，某个资源文件等。