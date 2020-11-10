package com.ghostkang.mail_template_server.framework.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Resource {

    @Value("${api.upload-path}")
    public String API_UPLOAD_PATH;

}

