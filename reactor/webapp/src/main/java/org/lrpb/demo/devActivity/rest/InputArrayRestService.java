package org.lrpb.demo.devActivity.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.lrpb.demo.devActivity.beans.InputArraySessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


@RestController
@SessionAttributes("inputArray")
public class InputArrayRestService {
	
	@Autowired
	private InputArraySessionBean inputArray;
	
	
	@Autowired
	public InputArrayRestService(InputArraySessionBean pInputArray) {
		this.inputArray = pInputArray;
	}
	
    @RequestMapping(value="/rest/inputArray", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<InputArraySessionBean>   setInputArray(@Valid @RequestBody InputArraySessionBean pInputArray) {
    	
    	inputArray.assing(pInputArray);
    	ResponseEntity<InputArraySessionBean> response = new ResponseEntity<InputArraySessionBean>(pInputArray,HttpStatus.OK);

    	return response;
    }
    	
    @RequestMapping(value="/rest/inputArray", method = RequestMethod.GET)
    public InputArraySessionBean  getInputArray() {

    	return inputArray;
    }
}
