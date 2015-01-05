package org.lrpb.demo.devActivity;

import org.lrpb.demo.devActivity.algorythm.SorthAlgo;
import org.lrpb.demo.devActivity.algorythm.impl.JDKSortingAlgo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan
@EnableAutoConfiguration
@EnableWebMvc
public class Application extends WebMvcAutoConfigurationAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new ErrorPageCustomizer();
    }

    
    @Bean
    public SorthAlgo getSorthAlgo()
    {
       //Could also Use  new HeapSortSortingAlgo()
 	   return new JDKSortingAlgo();
    }
    private static class ErrorPageCustomizer implements EmbeddedServletContainerCustomizer {

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
  
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        }

    }
}
