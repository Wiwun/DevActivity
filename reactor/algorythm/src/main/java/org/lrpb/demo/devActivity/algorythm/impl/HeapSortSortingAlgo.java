/**
 * 
 */
package org.lrpb.demo.devActivity.algorythm.impl;

import java.util.List;
import java.util.PriorityQueue;

import org.lrpb.demo.devActivity.algorythm.SorthAlgo;

/**
 * @author Louis-Rene
 *
 */
public class HeapSortSortingAlgo implements SorthAlgo {

	/** (non-Javadoc)
	 * This implementation of heapsoth use JDK Priority queue as heap implemetation.
	 * HeapSort algorythm is known to be O(nLogn) size
	 * @see org.lrpb.demo.devActivity.algorythm.SorthAlgo#sorthDecreasing(java.util.List)
	 */
	@Override
	public List<Integer> sort(List<Integer> pListToSort) {
		 // Java's PriorityQueue class functions as a min heap
	    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(pListToSort.size());
	 
	    // Add each array element to the heap
	    for (Integer element : pListToSort)
	        heap.add(element);
	 
	    // Elements come off the heap in ascending order
	    for (int i=0; i<pListToSort.size(); i++)
	    	pListToSort.set(i, heap.remove());
	    
		return pListToSort;
	}

}
