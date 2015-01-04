package org.lrpb.demo.devActivity.rest;





import javax.validation.Valid;

import org.lrpb.demo.devActivity.beans.InputArraySessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Scope("request") //Need to be request scoped to work around jackson serialization issue with aop proxy
public class InputArrayRestService {
	
	@Autowired
	private InputArraySessionBean inputArray;

    @RequestMapping(value="/rest/inputArray", method = RequestMethod.POST)
    public InputArraySessionBean   setInputArray( @Valid @RequestBody InputArraySessionBean pInputArray) {
    	
    	inputArray.assing(pInputArray);
    	return inputArray;
    }
    	
    @RequestMapping(value="/rest/inputArray", method = RequestMethod.GET)
    public InputArraySessionBean  getInputArray() {

    	return new InputArraySessionBean(inputArray);
    }
}
