# Getting Started

Springboot-CorssOrigin 进行跨域问题

方法二: jsonp  
    这里不再讲解使用jsonp的方式来解决跨域，因为jsonp方式只能通过get请求方式来传递参数，而且有一些不便之处。
    JSOONP的解决跨域的原理  是借用js可以进行远程资源访问，JSONP 就是把返回的结果伪装成js脚本，“骗过”浏览器。
方法二: 注解  @CrossOrigin  
    1、前提 spring 4.2版本以上，这个注解可以实现方法级别的细粒度的跨域控制。
    我们可以在类或者方添加该注解，如果在类上添加该注解，该类下的所有接口都可以通过跨域访问，如果在方法上添加注解，那么仅仅只限于加注解的方法可以访问。
    
方法三: 实现WebMvcConfigurer
    1、通过实现WebConfigure接口，实现接口中的方法，addCorsMapping()方法来实现跨域。
    `【补充：WebMvcConfigure、与WebMvcConfigurerAdapter 接口区别
        
        1.接口WebConfigure ：
            Springboot 2.0 以后出现替代WebMvcConfigureradapter接口实现添加添加自定义拦截器，消息转换器等。
        
        2.接口WebMvcConfigurerAdapter：
            springboot 1.5 ，在springboot 2.0以后被标记 @Deprecated 被废弃。
            
        3.接口 WebMvcConfigurationSupport：
            WebMvcConfigurer中有的方法，此类中全都存在。可完全替代WebMvcConfigurer~~~~
            
    】`
方法三：通过实现Filter过滤器
    1、拦截器的在所有访问到达前进行对响应体进行设置。
    2、步骤：通过实现Filter 接口 ，重写doFilter方法。
        将响应ServletResponse 转换为HttpServletResponse 对象
        然后设置响应体的信息
        `HttpServletResponse res = (HttpServletResponse) response;
                 res.addHeader("Access-Control-Allow-Credentials", "true");
                 res.addHeader("Access-Control-Allow-Origin", "*");
                 res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
                 res.addHeader("Access-Control-Allow-Headers", "Content-Type,X-CAF-Authorization-Token,sessionToken,X-TOKEN");
                 if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
                     response.getWriter().println("ok");
                     return;
                 }
                 chain.doFilter(request, response);`
                 
方法四：使用Nginx 进行跨域
（如果我们在项目中使用了Nginx，可以在Nginx中添加以下的配置来解决跨域）
    
    1、
    `location / {
                add_header Access-Control-Allow-Origin *;
                add_header Access-Control-Allow-Headers X-Requested-With;
                add_header Access-Control-Allow-Methods GET,POST,PUT,DELETE,OPTIONS;
             
                if ($request_method = 'OPTIONS') {
                  return 204;
                }
             }`

        
    
    