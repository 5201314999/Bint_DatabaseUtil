package com.bint.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.bint.data.Table;
/**
 * ��д��
 * @author  linhongbin
 * @data:  2015��2��12�� ����11:00:42
 * @version:  V1.0
 */
public class Writer {
	List<Table> tables = null;
	public Writer(List<Table> tables){
		this.tables = tables;
	}
	/**
	 * ����tables����javabean
	 * @throws IOException
	 */
	public void creatJavaBean() throws IOException{
		Speller speller = new Speller();
		File dir = new File("javabean");
		dir.mkdir();
		for(Table table : tables){
			File file = new File("javabean/" + speller.getTableName(table) + ".java");
			file.createNewFile();
			FileWriter fileWritter = new FileWriter("javabean/" + speller.getTableName(table) + ".java", true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(speller.getTableContent(table));
			bufferWritter.close();
		}
		for(Table table : tables){
			System.out.println(table.toString());
		}
	}
}
