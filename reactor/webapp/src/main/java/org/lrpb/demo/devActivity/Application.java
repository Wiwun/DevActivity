package org.lrpb.demo.devActivity;

import org.lrpb.demo.devActivity.beans.InputArraySessionBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new ErrorPageCustomizer();
    }

  
   
    
    private static class ErrorPageCustomizer implements EmbeddedServletContainerCustomizer {

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
  
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        }

		

    }
}
