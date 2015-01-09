package com.bint.generation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.bint.data.Table;
/**
 * ��д��
 * @author Administrator
 *
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
			FileWriter fileWritter = new FileWriter("javabean/" + table.getName() + ".java", true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(speller.getTableContent(table));
			bufferWritter.close();
		}
	}
}
