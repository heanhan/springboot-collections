# Getting Started

webservice是什么
        
        其实就是跨语言的和操作系统的的远程调用技术。
        WSDL(Web Service Description Language) 将无论用任何语言写的web service 描述出来。WSDL是服务端和客户端都能解读的标准格式。
        客户端通过url地址访问到WSDL文件，在调用服务端之前访问WDSL文件，读取到WSDL后通过客户端的API类可以生成代理类，调用这些代理类就可以访问webservice
        服务了。代理类将客户端的方法变为soap(Simple Object Access Protocol ，可以理解为http+xml)通过http发送请求，同时接受soap格式的返回值并解析。
        