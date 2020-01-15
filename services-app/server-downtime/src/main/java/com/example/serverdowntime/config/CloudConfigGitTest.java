package com.example.serverdowntime.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: cowwa
 * @Date: 2020/1/10 15:02
 * @Description:
 */
@Data
@Component
public class CloudConfigGitTest {
    @Value(value = "${git.config.test}")
    public String test;
}
