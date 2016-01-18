package org.zhang.algs4.chap2sort;

import java.io.File;
import java.io.IOException;
import jxl.JXLException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**用来将算法运行数据(String)保存到 excel 中
 * @author zhang
 *
 */
public class Utils {
	public static boolean savetoXLS(String data) throws IOException, JXLException{
		File file=new File("data.xls");
		if(!file.exists()){
			file.createNewFile();
			WritableWorkbook b=Workbook.createWorkbook(file);
			b.createSheet("sort", 0);
			b.write();
			b.close();
		}
		Workbook book=Workbook.getWorkbook(file);
		WritableWorkbook b=Workbook.createWorkbook(file, book);
		WritableSheet sheet = b.getSheet(0);
		int rows=sheet.getRows();
		System.out.println(rows);
		String[] a=data.split("\\r?\\n");
		int length=0;
		for (int i = 0; i < a.length; i++) {
			String[] cell=a[i].split("\\s+");
			int k=0;
			length=cell.length;
			for (int j = 0; j < length; j++) {
				if (!cell[j].equals("")) {
					Label l=new Label(k++, rows+i+1, cell[j]);
					sheet.addCell(l);
					
				}
			}
			k=0;
		}
		sheet.mergeCells( length+1, rows+1, length+6,rows+a.length);
		b.write();
		b.close();
		
		return true;
	}
	
	public static void main(String[] args) throws Throwable {
		String data="aa bb cc\r\n dd ee ff\r\n gg ";
		savetoXLS(data);
		String[] a=data.split("\\r?\\n");
		for (int i = 0; i < a.length; i++) {
			String[] cell=a[i].split("\\s+");
			for (int j = 0; j < cell.length; j++) {
				if(cell[j].length()>0){
				System.out.println(cell[j]);
				}
			}
		}
		
		System.out.println("".equals(null));
		
	}
}
