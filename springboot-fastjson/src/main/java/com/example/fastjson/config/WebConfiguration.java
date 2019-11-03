package com.example.fastjson.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhaojh
 * @date : 2019-11-03
 * @function :
 */

@SpringBootConfiguration
public class WebConfiguration extends WebMvcConfigurationSupport {


    /**
     * 重写 configureMessageConverters
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();//消息转换的对象
        FastJsonConfig fastJsonConfig = new FastJsonConfig();//消息转换的设置属性对象
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        /**
         * 设置UTF-8编码
         * 因为默认springboot 是对返回的字符串没有做编码处理的，此时使用第三方的转换器。设置了编码，以后在方法的住街上，无论是字符串还是对象都无需设置编码
         */
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);

    }

}
