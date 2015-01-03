package org.lrpb.demo.devActivity.beans;

import org.lrpb.demo.devActivity.algorythm.SorthAlgo;
import org.lrpb.demo.devActivity.algorythm.impl.JDKSortingAlgo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SorthAlgoFactory {

	
   @Bean
   public SorthAlgo getSorthAlgo()
   {
	   return new JDKSortingAlgo();
   }
}
