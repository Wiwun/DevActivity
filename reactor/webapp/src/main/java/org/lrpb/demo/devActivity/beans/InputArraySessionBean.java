package org.lrpb.demo.devActivity.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,isGetterVisibility = JsonAutoDetect.Visibility.ANY,getterVisibility = JsonAutoDetect.Visibility.ANY)
@Scope(value="session")
public class InputArraySessionBean  implements Serializable{


	@JsonIgnore
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	@NotNull
	@NotEmpty
	@NotContainNull
	List<Integer> inputArray = new ArrayList<Integer>();

	public InputArraySessionBean() 
	{
		
	}
	
	public InputArraySessionBean(InputArraySessionBean input) 
	{
		setInputArray(input.getInputArray());
	}
	public List<Integer> getInputArray() {
		return inputArray;
	}

	public void setInputArray( List<Integer> pInputArray) {
		inputArray = pInputArray;
	}

	public void assing(InputArraySessionBean pInputArray) {
	
		setInputArray(pInputArray.getInputArray());
	}
	


	
}
