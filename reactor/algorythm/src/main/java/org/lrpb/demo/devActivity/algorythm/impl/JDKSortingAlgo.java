/**
 * 
 */
package org.lrpb.demo.devActivity.algorythm.impl;

import java.util.Collections;
import java.util.List;

import org.lrpb.demo.devActivity.algorythm.SorthAlgo;

/**
 * Implementation of SothAlgo using JDK Classes.
 * 
 * 
 * @author Louis-Rene Poirier Beauchemin
 */
public class JDKSortingAlgo implements SorthAlgo {

	/** 
	 * Sort the given pArrayList with JDK Collection.sort class implementation
	 * According to the JDK docuemntaton, this function should have a O(nlogn +n)
	 * 
	 * @see org.lrpb.demo.devActivity.algorythm.SorthAlgo#sorthDecreasing(java.util.List)
	 */
	@Override
	public List<Integer> sort(List<Integer> pArrayToSort) {

		//According to the JDK, Colleciton.sort use mergesort in worst case when the input is random
		//MergeSort have O(nlogn)
		Collections.sort(pArrayToSort);

		return pArrayToSort;
	}

}
