package org.zhang.leetCode;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 */
public class _27RemoveElement {
	public int removeElement(int[] nums, int val) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                for(int j=nums.length-1;j>-1;j--){
                    if(nums[j]!=val){
                        if(i>j) {
                            return i;
                        }else{
                            nums[i]=nums[j];
                            nums[j]=val;
                            break;
                        }
                    }
                    if(j==0) return 0;
                }
            }
        }
        
        return nums.length;
    }
}
