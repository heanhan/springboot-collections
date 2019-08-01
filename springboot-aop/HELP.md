# springboot-aop 之aspectJ

### springboot-aop Documentation
利用aop面向切面编程:

* 使用AspectJ

        1、解释：
        
        代码中的@Around环绕通知，参数类型是ProceedingJoinPoint，而前面第一个示例的@Before前置通知，参数类型是JoinPoint。
        下面是AspectJ通知和增强的5种模式：
        @Before前置通知，在目标方法执行前实施增强,请求参数JoinPoint,用来连接当前连接点的连接细节，一般包括方法名和参数值。在方法执行前进行执行方法体，不能改变方法参数，也不能改变方法执行结果。
        @After 后置通知，请求参数JoinPoint,在目标方法执行之后，无论是否发生异常，都进行执行的通知。在后置通知中，不能访问目标方法的执行结果(因为有可能发生异常)，不能改变方法执行结果。
        @AfterReturning 返回通知，在目标方法执行后实施增强，请求参数JoinPoint，其能访问方法执行结果(因为正常执行)和方法的连接细节，但是不能改变方法执行结果。（注意和后置通知的区别）
        @AfterThrowing 异常通知，在方法抛出异常后实施增强，请求参数JoinPoint,throwing属性代表方法体执行时候抛出的异常，其值一定与方法中Exception的值需要一致。
        @Around 环绕通知，请求参数ProceedingJoinPoint，环绕通知类似于动态代理的全过程，ProceedingJoinPoint类型的参数可以决定是否执行目标方法，而且环绕通知必须有返回值，返回值即为目标方法的返回值。

