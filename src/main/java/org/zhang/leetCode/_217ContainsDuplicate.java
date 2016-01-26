package org.zhang.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**2016-01-24 LeetCode 217. Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct. 看数组中是否存在重复的数.
 * 方法1:可以使用二分法,在排序的同时,寻找重复的数. 复杂度 2n~5n.
 * 方法2:构造链表数组,类似于 HashSet.复杂度 n.主要时间花费在构造 Node 对象上
 * 当重复的数字出现在数组前端时,方法2超级快.方法1则比较稳定
 * @author zhang
 */
public class _217ContainsDuplicate {
	
	static class Node{
		final int value;
		Node next;
		public Node(int value, Node next) {
			super();
			this.value = value;
			this.next = next;
		}
	}
	
	public boolean containsDuplicate(int[] nums){
		int N=nums.length;
		int cap=2;
		while(N>cap)
			cap*=2;
		Node[] table =new Node[cap];
		boolean flag=false;
		Node p;
		int v;
		for(int i=0;i<N;i++){
//			int index=Math.abs((v=nums[i])%N);
			int index=(cap-1)&(v=nums[i]);
			if((p=table[index])==null){
				table[index]=new Node(v,null);
			}else{
				while(true){
					if(p.value==v){
						System.out.println(v);
						i=N;
						flag=true;
						break;
					}
					if(p.next==null){
						p.next=new Node(v,null);
						break;
					}
					p=p.next;
					 
				}
			}
		}
		return flag;
	}
	

	static boolean flag;

	public boolean containsDuplicate2(int[] nums) {
		flag=false;
		shuffle(nums);
		find(0, nums.length - 1, nums);
		return flag;
	}

	public static void find(int lo, int hi, int[] nums) {
		if (flag || lo >= hi)
			return;
		int p = partition(lo, hi, nums);
		find(lo, p - 1, nums);
		find(p + 1, hi, nums);
	}

	/* 分割数组 */
	public static int partition(int lo, int hi, int[] nums) {

		int comp = nums[lo];
		int i = lo;
		int j = hi + 1;
		// i 从左向右递增,遇到比 nums[lo]大的数停止; j 从右向左递减,遇到比 nums[lo]小的数停止. 然后交换 nums[i]
		// 和 nums[j]. 循环往复,直到 i, j 相遇, 交换 nums[lo], nums[j].至此,
		// nums[lo]左边的数全部小于右边.
		// 在这个过程中, 如果遇到等于 nums[lo] 的,则 flag=true, 得证.
		while (true) {
			while (nums[++i] < comp) {
				if (i == hi)
					break;
			}
			if (nums[i] == comp) {
				// System.out.println(comp);
				flag = true;
				break;
			}
			while (nums[--j] > comp) {
				if (j == lo)
					break;
			}
			if (nums[j] == comp && j != lo) {
				// System.out.println(comp);
				flag = true;
				break;
			}
			if (i >= j) {

				break;
			}
			exchange(nums, i, j);
		}
		if (flag)
			return lo;
		exchange(nums, j, lo);
		return j;
	}
	static long count;
	/* 交换两个元素 */
	private static void exchange(int[] nums, int m, int n) {
		count++;
		int temp = nums[m];
		nums[m] = nums[n];
		nums[n] = temp;
	}
	
	/* 打乱数组	 */
	private static void shuffle(int[] nums){
		Random random = new Random();
		int N =nums.length;
		for(int i=0;i<N-1;i++){
			int rd=random.nextInt(N-i);
			exchange(nums,i,rd);
		}
	}
	public static void main(String[] args) {
		
		HashSet<Integer> set=new HashSet<>();
		Random r=new Random();
		
		for(int i=0;i<100000;i++){
			set.add(r.nextInt());
		}
		ArrayList<Integer> list=new ArrayList<>();
		list.addAll(set);
		
		int[] nums=new int[list.size()+1];
		for (int i=0;i<list.size();i++) {
			nums[i]=list.get(i);
		}
		nums[list.size()]=list.get(500);
		
		int temp=nums[501];
		nums[501]=nums[list.size()];
		nums[list.size()]=temp;
		
		System.out.println(list.get(500));
//		int[] nums={4,14,24,34,44,54,64,74,84,94,11,21,31,22,32,42,33,43,53,94};
		long st=System.currentTimeMillis();
		System.out.println(new _217ContainsDuplicate().containsDuplicate(nums));
		long en=System.currentTimeMillis();
		System.out.println((en-st)/1000.0);
//		set.clear();
//		long st2=System.currentTimeMillis();
//		boolean f=false;
//		for(int i=0;i<nums.length;i++){
//			if(!set.add(nums[i])){
//				f=true;
//				break;
//			}
//		}
//		long en2=System.currentTimeMillis();
//		System.out.println((en2-st)/1000.0);

		
	}

}
