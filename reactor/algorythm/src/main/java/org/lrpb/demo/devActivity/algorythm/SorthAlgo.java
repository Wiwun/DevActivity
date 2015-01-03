/**
 * 
 */
package org.lrpb.demo.devActivity.algorythm;

import java.util.List;

/**
 * @author Louis-Rene
 */
public interface SorthAlgo {

	
    /**
     * Sort the given list 
     * @param pArrayToSort The array of Integer to sort
     * @return the list sorted in increasing
     */
    public List<Integer> sort(List<Integer> pArrayToSort);
}
