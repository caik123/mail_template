package com.ghostkang.mail_template_server.framework.configurer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ghostkang.mail_template_server.framework.core.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.MultipartConfigElement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@EnableWebMvc
@Configuration
public class WebMvcConfg implements WebMvcConfigurer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Resource resource;

    @Autowired
    private SecurityInterceptor securityInterceptor;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(new ResourceHttpMessageConverter());
        converters.add(new AllEncompassingFormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(jackson2HttpMessageConverter());
    }

    /**
     * 时间格式转换器,将Date类型统一转换为yyyy-MM-dd HH:mm:ss格式的字符串
     */
    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();

        //日期格式转换
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        //Long类型转String类型
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        mapper.registerModule(simpleModule);

        converter.setObjectMapper(mapper);
        return converter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor)// 注册拦截器
                .addPathPatterns("/**")// 拦截所有请求
                .excludePathPatterns("/user/**");//排除user下面的拦截

    }

    /**
     * 跨域支持
     *
     * @param registry registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600 * 24);
    }

    /**
     * 配置静态页面请求处理
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        List<String> list = new ArrayList<>();
        list.add("classpath:/META-INF/resources/");
        list.add("classpath:/resources/");
        list.add("classpath:/static/");
        list.add("classpath:/public/");
        list.add("file:" + resource.API_UPLOAD_PATH);
        String[] RESOURCE_LOCATIONS = new String[list.size()];
        list.toArray(RESOURCE_LOCATIONS);
        logger.info(list.toString());
        registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATIONS);
    }

    /**
     * 设置文件上传大小
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.ofMegabytes(10)); //MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofMegabytes(100));
        return factory.createMultipartConfig();
    }
}
