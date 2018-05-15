package com.util;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.entity.Resource;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationAPI extends ResourceConfig {
        public ApplicationAPI() {
// 加载resources
            register(Resource.class);
            register(CORSResponseFilter.class);

// 注册数据转换器
            register(JacksonJsonProvider.class);

// 注册日志
            register(LoggingFilter.class);
//加载CORS
            register(CORSResponseFilter.class);
        }

}
