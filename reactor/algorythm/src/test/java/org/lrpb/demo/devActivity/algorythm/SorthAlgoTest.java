package org.lrpb.demo.devActivity.algorythm;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.lrpb.demo.devActivity.algorythm.impl.HeapSortSortingAlgo;
import org.lrpb.demo.devActivity.algorythm.impl.JDKSortingAlgo;

import com.google.common.primitives.Ints;

public class SorthAlgoTest {

	private static List<Integer> inputExampleList; 
    private static List<Integer> outputExampleList; 
    
	
    @Before
    public void initArrays()
    {
    	inputExampleList = Ints.asList(1,9,5,7,2,5,2,1); 
    	outputExampleList = Ints.asList(1,1,2,2,5,5,7,9);
    }

	@Test
	public void testJdkImplementation() {
		checkExampleFit(new JDKSortingAlgo());
	}

	@Test
	public void testHeapSort()
	{ 
	
		checkExampleFit(new HeapSortSortingAlgo());
	}

	private void checkExampleFit(SorthAlgo pAlgo) {
		List<Integer> resultList = pAlgo.sort(inputExampleList);
		assertEquals(outputExampleList, resultList);
	}
	
}
