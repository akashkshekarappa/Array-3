import java.util.*;
/********************************************Using Brute Force*************************************/
//Time Complexity :O(nlogn + n), number of elements in the array
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Iterate over the array, find h index, (diff = citations.length - i)
 * if h index becomes equal or crosses the citations, return the h index **/

class H_Index_Brute_Force {
	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0)
			return 0;

		Arrays.sort(citations); //O(nlogn)
		for(int i=0; i<citations.length; i++){ // O(n)
			int diff = citations.length - i;

			if(diff <= citations[i])
				return diff;
		}
		return 0;
	}
}

/********************************************Using Binary Search*************************************/
//Time Complexity :O(nlogn + log n) ,  number of elements in the array
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Using Binary search, find a mid, then find the N-i (citations.length - mid)
 * if it is equal to the citation return mid. if diff is greater then move low=mid+1 else move high to mid-1*/

class H_Index_Binary_Search {
	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0)
			return 0;

		Arrays.sort(citations); //O(nlogn)
		int low =0;
		int high = citations.length -1;
		while(low <= high){ //O(logn)
			int mid = low + (high - low)/2;
			int diff = citations.length - mid;	// finding h index
			if(citations[mid] == diff)	// if the citations become equal to h index
				return citations[mid];
			else if (citations[mid] < diff)	// if citation is less than diff we have to move right
				low = mid + 1;
			else
				high = mid - 1;
		}
		return citations.length - low;	// if they don't become equal and citations crosses it, the h index is found at low index
	}
}
