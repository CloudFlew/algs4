package org.zhang.algorithms4th.chapter2_sort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 用来测试排序算法的性能
 * 
 * @author cloud
 *
 */
public class SortCompare {

	
	/**比较不同排序算法的运行时间
	 * @param args 算法类及其方法组成的数组， 格式：{ "ShellSort", "sort", "QuickSort", "sort5" , "ShellSort",...}
	 * @param size 排序数组的大小
	 * @param count 重复运行次数
	 * @param remark 对本次测试的备注
	 * @return String 本次测试的全部信息，包括时间、备注、算法名称及其运行时间，以备分析或保存の用
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String compare(String[] args, int size, int count, String remark) throws Exception {
		String packageName = "org.zhang.algs4.chap2sort.";
		StringBuffer sb = new StringBuffer();//用来存放算法运行的数据
		sb.append(remark + " size=" +size+" "+LocalDateTime.now()+  "\r\n");
		for (int i = 0; i < args.length; i += 2) {
			sb.append(args[i]+"."+args[i+1]+" ");
		}
		sb.append("比值\r\n");
		for (int j = 0; j < count; j++) {
			Comparable[] a = getDoubleArray(size);
			double[] times=new double[args.length/2];//存放每次排序所用时间
			for (int i = 0; i < args.length; i += 2) {
				Comparable[] b = a.clone();
				String sortClass = args[i];
				String methodName = args[i + 1];
				Class<?> clazz = Class.forName(packageName + sortClass);//通过反射获得算法类及其方法
				Method method = clazz.getDeclaredMethod(methodName, Comparable[].class);
				
				long st = System.currentTimeMillis();
				method.invoke(null, (Object) b);
				long end = System.currentTimeMillis();
				times[i/2] = (end - st) / 1000.0;  //排序用时
				
				System.out.println(sortClass+"."+methodName+" "+QuickSort.isSorted(b));
				sb.append(times[i/2] + " ");
			}
			for (int i = 0; i < times.length; i++) {
				sb.append( String .format("%.2f",times[i]/times[0])+":");
				if (i==times.length-1) {
					sb.deleteCharAt(sb.length()-1);
				}
			}
			sb.append("\r\n");
			
		}
//		sb.append("\n");
		System.out.println(sb.toString());
		return sb.toString();
	}

	/**将运行数据(String)保存到txt文件中,(不再使用,改为存到 excel 中,见 Utils 类)
	 * @param s
	 * @throws IOException
	 */
	public static void save(String s) throws IOException {
		File file = new File("src/main/java/org/zhang/algs4/chap2sort/log.txt");
		if (!file.exists())
			file.createNewFile();
		FileWriter writer = new FileWriter(file, true);
		writer.write(s);
		writer.flush();
		writer.close();
	}

	/**获取一个指定大小的随机 Double 数组
	 * @param size
	 * @return
	 */
	public static Double[] getDoubleArray(int size) {
		Double[] a = new Double[size];
		for (int k = 0; k < size; k++) {
			a[k] = Math.random();
		}
		return a;
	}

	public static void main(String[] args) throws Exception {
		String[] arg = {"QuickSort", "sort", "MergeSort","sort"};
		String remark = "测试快排和归并";
//		for (int i = 0; i < 20; i++) {
//			System.out.println("M: "+QuickSort.M);
//			compare(arg, 100000, 5, remark);
//			QuickSort.M++;
//		}
//		for (int i = 1; i < 2; i++) {
			
			String result=compare(arg, 2000000, 3, remark);
			Utils.savetoXLS(result);
//		}
//		save(result);
	}
}
