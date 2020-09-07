/********************************************Using Brute Force*************************************/
//Time Complexity :O(n * k), n is length of array and k is number of times to rotate array
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**Rotate all the elements of the array in k steps by rotating the elements by 1 unit in each step
 * **/
class Rotate_Array_Brute {
	public void rotate(int[] nums, int k) {
		if(nums == null || nums.length < 2) // there should be atleast 2 numbers to rotate the array
			return;
		if(k > nums.length)
			k = k % nums.length;    //if k is greater than array length, then reset k accroding to mod value taken

		for(int i=0; i<k; i++){
			int previous = nums[nums.length -1];
			for(int j=0; j<nums.length; j++){
				int temp= nums[j];
				nums[j] = previous;
				previous = temp;
			}
		}
	}
}

/********************************************Using Brute Force*************************************/
//Time Complexity :O(n * k), n is length of array and k is number of times to rotate array
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Rotate_Array_Brute_Force {
	public void rotate(int[] nums, int k) {
		int i=0;
		while(k > 0){	//terminating condition when k is greater than 0
			int temp = nums[nums.length - 1];	//store the last element of an array in temp

			//run a loop from last element and copy the previous element
			for(i = nums.length -1; i>0; i--)
				nums[i] = nums[i-1];

			nums[i] = temp;	// at last copy the temp variable in first index
			k--;	// decrement k
		}
	}
}


/********************************************Using Reverse*************************************/
//Time Complexity :O(n), number of elements reversed
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**First we reverse all the elements of the array
 * Then, reversing the first k elements followed by reversing the rest n-k elements gives us the required result
 * ***/


class Rotate_Array_Reverse {
	public void rotate(int[] nums, int k) {
		if(nums == null || nums.length < 2) // there should be atleast 2 numbers to rotate the array
			return;
		if(k > nums.length)
			k = k % nums.length;    //if k is greater than array length, then reset k accroding to mod value taken
		reverse(nums, 0, nums.length-1);    //reverse all elements
		reverse(nums, 0 , k -1);  //reversing first k elements
		reverse(nums, k, nums.length-1);    //reverse last nums.length-k elements
	}
	private void reverse(int[] nums, int start, int end){
		while(start< end){
			int temp= nums[start];
			nums[start] = nums[end];
			nums[end] = temp;

			start++;
			end--;
		}
	}
}