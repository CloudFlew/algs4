package org.zhang.leetCode;

import java.util.Arrays;

/** 更快的算法还未完成,即不需要额外数组的方法
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 */
public class Mark_189RotateArray {
	
	//需要额外的空间,长度为 nums.length 的数组
	public void rotate(int[] nums, int k) {
		int[] copy = nums.clone();
		k = k % nums.length;
		for (int i = 0; i < (nums.length - k); i++) {
			nums[i + k] = copy[i];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = copy[nums.length - k + i];
		}
	}
	
	//需要额外的空间,长度为 k 的数组
	public void rotate2(int[] nums, int k) {
        int[] copy;
        int N ;
        k = k % (N=nums.length);
        if(k<=N/2){
            copy = new int[k];
            for(int i= N-k,j=0;i<N;i++,j++){
                copy[j]=nums[i];
                nums[i]=nums[i-k];
            }
            for(int i=N-k-1;i>=k;i--){
                nums[i]=nums[i-k];
            }
            for(int i=0;i<k;i++){
                nums[i]=copy[i];
            }
        } else {
            k=N-k;
            copy = new int[k];
            for(int i=0;i<k;i++){
                copy[i] = nums[i];
                nums[i]= nums[N-k];
            }
            for(int i=0;i<N-k;i++){
                nums[i]=nums[i+k];
            }
            for(int i=0;i<k;i++){
                nums[N-k+i]=copy[i];
            }
        }
    }
	
	public static void rotate3(int[] nums, int k) {
        // for(int i=0;i<k;i++){
        //     int temp=nums[i];
        //     int temp2;
        //     for(int j=i+k;;j+=k){
        //         if(j<nums.length){
        //             temp2=nums[j];
        //             nums[j]=temp;
        //             temp=temp2;
        //         }else{
        //             nums[j-nums.length]=temp;
        //             break;
        //         }
        //     }
        // }
        int temp=nums[0];
        int temp2;
        for(int i=k;;i+=k){
            if(i<nums.length){
                temp2=nums[i];
                nums[i]=temp;
                temp=temp2;
            }else{
                i=i-nums.length;
                if(i!=0){
                	temp2=nums[i];
                	nums[i]=temp;
                	temp=temp2;
                }else{
                	nums[i]=temp;
                	break;
                }
            }
        }
    }
	
	public static void main(String[] args) {
		int[] nums={1,2,3,4,5,6,7};
		rotate3(nums,3);
		System.out.println(Arrays.toString(nums));
		String a="aaa";
	}
}
