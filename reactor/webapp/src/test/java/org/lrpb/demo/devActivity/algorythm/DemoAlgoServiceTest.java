package org.lrpb.demo.devActivity.algorythm;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.lrpb.demo.devActivity.algorythm.impl.JDKSortingAlgo;
import org.lrpb.demo.devActivity.beans.InputArraySessionBean;
import org.lrpb.demo.devActivity.rest.DemoAlgoService;

import com.google.common.primitives.Ints;

public class DemoAlgoServiceTest {

	
	private static List<Integer> inputExampleList; 
	
	@Before
	public void setUp() throws Exception {
		
		inputExampleList = Ints.asList(1,9,5,7,2,5,2,1); 
	}

	@Test
	public void testExample() {
		InputArraySessionBean inputArray = new InputArraySessionBean();
		inputArray.setInputArray(inputExampleList);
		DemoAlgoService algo = new DemoAlgoService(new JDKSortingAlgo(),inputArray);
		int response = algo.getAnswer();
		assertEquals(7,response);
		
	}

}
