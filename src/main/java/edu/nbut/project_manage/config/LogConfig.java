package edu.nbut.project_manage.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class LogConfig {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @GetMapping("/login")
    public String login(){
        logger.info("test logging...");
        return "hello login LOG";
    }
}
