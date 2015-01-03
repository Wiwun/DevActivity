package org.lrpb.demo.devActivity.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Severity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.google.common.primitives.Ints;


@Service
@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class InputArraySessionBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Integer> inputArray = new ArrayList<Integer>();

	public InputArraySessionBean() 
	{
		
	}
	
	public InputArraySessionBean(InputArraySessionBean input) 
	{
		setInputArray(input.inputArray);
	}
	public List<Integer> getInputArray() {
		return inputArray;
	}

	public void setInputArray( List<Integer> inputArray) {
		this.inputArray.clear();
		this.inputArray.addAll(inputArray); 
	}

	public void assing(InputArraySessionBean pInputArray) {
	
		setInputArray(pInputArray.inputArray);
	}
	


	
}
