# Getting Started

### springboot Interceptor Documentation
springboot 结合intceptor拦截器与Filer过滤器的及知识点的总结:

*概念区分* ： 拦截器Interceptor 和Filter过滤器

   `
   
        AOP 思想不是spring独有的，是spring是实现编程思想的框架之一，AOP不是一种具体的技术，而是一种编程思想，在面向对象编程的过程中，我们很容易通过
    继承、多态来解决纵向扩展。但是对于横向扩展，比如在所有的service的业务层的方法中开启事务，或者统一记录日志功能，面向对象是无法解决的，所有AOP面
    向切面编程其实是对面向对象编程思想的一个补充。
    
        主要区别：
            * Filter 是依赖Servlet容器，属于Servlet规范范畴的一部分，而拦截器则是独立的，可以在任何情况下使用。
            * Filter 的执行是有Servlet容器回调完成也就是使用反射完成，而拦截器通常通过动态代理的方式执行。
            * Filter 的生命周期有Servlet容器管理，而拦截器则可以通过IOC容器来管理，因此，可以通过注入的方式来获取Bean实例，因此使用更方便。
            * 执行顺序：过滤前 – 拦截前 – Action处理 – 拦截后 – 过滤后。
            * 拦截器只能对action请求起作用，而过滤器则可以对几乎所有的请求起作用。
            * 拦截器可以访问action上下文、值栈里的对象，而过滤器不能访问。
            * 在action的生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次。
            
            
      `
  


一、拦截器Interceptor、

    `
     拦截器
     
       概念：
       
              在AOP（Aspect-Oriented Programming）中用于在某个方法或字段被访问之前，进行拦截，然后在之前或之后加上某些操作。拦截是AOP的一种实现策略，
           
       
       作用：
       
           1、日志记录：记录请求信息的日志，以便进行信息监控、信息统计、计算PV...
           2、权限检查：认证或者授权等检查
           3、性能监控：通过拦截器在进入处理器之前记录开始时间，处理完成后记录结束时间，得到请求处理时间。
           4、通用行为：读取cookie得到用户信息并将用户对象放入请求头中，从而方便后续流程使用。

        实现： 
        
            * 实现接口 HandleInterceptor,重写里面的三个方法  preHandle、postHandle、afterCompletion
           
           1 . preHandler
           
                方法将在请求处理之前进行调用。SpringMVC中的Interceptor同Filter一样都是链式调用。每个Interceptor的调用会依据它的声明顺序依次执行，
            而且最先执行的都是Interceptor中的preHandle方法，
            所以可以在这个方法中进行一些前置初始化操作或者是对当前请求的一个预处理，也可以在这个方法中进行一些判断来决定请求是否要继续进行下去。
            该方法的返回值是布尔值Boolean 类型的，当它返回为false时，表示请求结束，后续的Interceptor和Controller都不会再执行；
            当返回值为true时就会继续调用下一个Interceptor 的preHandle 方法，如果已经是最后一个Interceptor 的时候就会是调用当前请求的Controller 方法。

           2 . postHandler
           
               在当前请求进行处理之后，也就是Controller 方法调用之后执行，但是它会在DispatcherServlet 进行视图返回渲染之前被调用，
            所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。

           3 . afterCompletion
           
               该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。顾名思义，
           该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。这个方法的主要作用是用于进行资源清理工作的。
           
           
        拦截器写完需要注册
        
            实现类直接实现WebMvcConfigurer （官方推荐）或者 直接继承WebMvcConfigurationSupport（不如第一种实现起来简单，使用可能存在问题。下面单独解释。）
            (WebMvcConfigurerAdapter 已经废弃)
            
             bug分享： 
             
                存在 继承WebMvcConfigurationSupport不起作用，是因为覆盖了@EnableAutoConfiguration里的所有方法，每个方法都需要重写，
             比如，若不实现方法addResourceHandlers()，则会导致静态资源无法访问。因此大家在使用2.X版本以后的springboot的时候
             使用WebMvcConfigurationSupport类配置拦截器时一定要重写addResourceHandlers来实现静态资源的映射,不要使用application.properties中添加配置来实现映射，
             不然资源会映射不成功导致打开页面资源一直加载不到。
    
    `

二、过滤器Filter、

    `
    过滤器
    
        实现Filter接口，
        
            1 . 重写接口里的三个方法：init、doFilter、destroy。
            
                init: 初始化过滤器
                
                doFilter: 执行过滤，释放/拦截
                
                public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {`
                    long start = System.currentTimeMillis();
                    filterChain.doFilter(servletRequest, servletResponse);//重点
                    System.out.println("Execute cost=" + (System.currentTimeMillis() - start));
                    }
                    
                destroy : 容器销毁。
                
            2 . 配置过滤器方式之一:过滤器实现编写好进行配置过滤器
             
                @Configuration
                public class FilterConfig {
                
                    @Bean
                    public FilterRegistrationBean registFilter() {
                
                        FilterRegistrationBean registration = new FilterRegistrationBean();
                        registration.setFilter(new 自己写的过滤器());// 此位置注册前面写的过滤器。
                        registration.addUrlPatterns("/*");//拦截路径
                        registration.setName("LogCostFilter");//设置过滤器的名字
                        registration.setOrder(1);//过滤器的执行顺序
                        return registration;
                    }
                }
                
            2 . 配置过滤器方式之二：（通过注解）,需要支持servlet 3.0规范以上。
            
                    @WebFilter(urlPatterns = "/*", filterName = "XXX")// 对应填上过滤路径，过滤器名称
                
    
**注：**

    @WebFilter这个注解并没有指定执行顺序的属性，其执行顺序依赖于Filter的名称，是根据Filter类名（注意不是配置的filter的名字）的字母顺序倒序排列，并且@WebFilter指定的过滤器优先级都高于FilterRegistrationBean配置的过滤器。


    `

