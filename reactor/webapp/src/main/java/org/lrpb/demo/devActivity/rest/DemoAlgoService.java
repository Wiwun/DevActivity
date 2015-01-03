package org.lrpb.demo.devActivity.rest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.lrpb.demo.devActivity.algorythm.SorthAlgo;
import org.lrpb.demo.devActivity.algorythm.impl.JDKSortingAlgo;
import org.lrpb.demo.devActivity.beans.InputArraySessionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;


@Service
@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DemoAlgoService {
	
	
	@Autowired
	private SorthAlgo algo;
	
	@Autowired 
	private InputArraySessionBean inputArray;
	
	public DemoAlgoService()
	{
		algo = new JDKSortingAlgo();
	}
	
	
	public DemoAlgoService(SorthAlgo pAlgo,InputArraySessionBean pInputArray)
	{
		algo = pAlgo;
		inputArray = pInputArray;
	}
	
	public Integer getAnswer()
	{
		if ( inputArray == null || inputArray.getInputArray() == null  || inputArray.getInputArray().size() <= 0)
		{
			throw new IllegalStateException("Input Array not set in session.");
		}
	
		List<Integer> noDupList = new ArrayList<Integer> (new HashSet<Integer>(inputArray.getInputArray()));
		
		int N =  noDupList.size();
		
		int n = (int) Math.floor(N/3);
		
		//Since the list are sorted in increasing order.
		//We need to look at the end of the list
		int indexOfAnwser = N-n-1;
		
		if(indexOfAnwser < 0)
		{
			indexOfAnwser = 0;
		}
		
		return algo.sort(noDupList).get(indexOfAnwser);
	}
	
	
}
