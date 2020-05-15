package net.xdclass.demo.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 服务器配置
 * @author hdz
 */
@Component
@ConfigurationProperties(prefix = "test")
@PropertySource({"classpath:application.properties"})
public class ServerSetting {

    /**
     * 名称
     */
    private String name;

    /**
     * 域名地址
     */
    private String domain;
/*
    *//**
     * 名称
     *//*
    @Value("${test.name}")
    private String name;

    *//**
     * 域名地址
     *//*
    @Value("${test.domain}")
    private String domain;*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
