package com.bint.generation;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bint.data.Column;
import com.bint.data.DataTypeHelper;
import com.bint.data.Table;
import com.bint.exception.TypeNotRecognizedException;
/**
 * TODO ƴдҪ����д��java�ļ����������
 * @author  BintLin
 * @data:  2015��1��8�� ����3:09:51
 * @version:  V1.0
 */
public class Speller {
	private static final String NEW_LINE = "\n";
	public static String getTableName (Table table){
		return getAapitalizeFomat(table.getName());
	}
	/**
	 * ����һ��������������Ӧ��javabean���������
	 * @param table
	 * @return String
	 */
	public static String getTableContent(Table table){
		System.out.println("table: " + table.getName() );
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("public class ");
		//��������
		stringBuffer.append(StringUtils.capitalize(getTableName(table)));
		stringBuffer.append("{");
		stringBuffer.append(NEW_LINE);
		stringBuffer.append(getProperty(table));
		stringBuffer.append(getMethod(table));
		return stringBuffer.toString();
	}
	
	/**
	 * �õ�һ�������������������������,�磺
	 * 		private String name;
	 * 		private int age;
	 * @param table
	 * @return StringBuffer
	 */
	private static StringBuffer getProperty(Table table){
		StringBuffer stringBuffer = new StringBuffer();
		for (Column column : table.getList()){
			stringBuffer.append("       ");
			stringBuffer.append("private ");
			//�жϷ������ݿ��е�������������Ӧ��Java����,������StringBuffer
			try {
				stringBuffer.append(DataTypeHelper.judgeDataType(column.getType()));
			} catch (TypeNotRecognizedException e) {
				e.printStackTrace();
			}
			stringBuffer.append(" ");
			stringBuffer.append(propertyFomat(column.getName()));
			stringBuffer.append(";");
			stringBuffer.append(NEW_LINE);
		}
		return stringBuffer;
	}
	/**
	 * TODO ��ʽ�����ԣ�ȥ��_���������Ը�Ϊ�շ�д��(����ĸСд)
	 *  FORM_CODE -- formCode
	 * @param property
	 * @return String
	 */
	private static String propertyFomat(String property){
		property = StringUtils.lowerCase(property);
		StringBuffer stringBuffer = new StringBuffer();
		String[] strings ;
		strings = StringUtils.split(property, "_" );
		for(int i = 0 ; i<strings.length ; i++){
			if( i > 0){
				stringBuffer.append(StringUtils.capitalize(strings[i])) ;
			}else{
				stringBuffer.append(strings[0]);
			}
		}
		return stringBuffer.toString();
	}
	/**
	 * 
	 * TODO �õ�������д��
	 * @param table
	 * @return String
	 * @throws TypeNotRecognizedException 
	 */
	private static String getMethod(Table table){
		List<Column> columns = table.getList();
		StringBuffer stringBuffer = new StringBuffer();
		for (Column column : columns){
			String camelCase = null;
			String columnName = column.getName();
			try {
				camelCase = DataTypeHelper.judgeDataType(column.getType());
			} catch (TypeNotRecognizedException e) {
				e.printStackTrace();
			}
			
			
			/*************************set ����****************************/
			stringBuffer.append("       ");
			stringBuffer.append("public ");
			stringBuffer.append(camelCase);
			stringBuffer.append(" " + "set");
			stringBuffer.append(getAapitalizeFomat(columnName));
			stringBuffer.append(" (String ");
			stringBuffer.append(propertyFomat(column.getName()));
			stringBuffer.append(")" + "{" + NEW_LINE);
			stringBuffer.append("           this." + propertyFomat(columnName) + " = " +propertyFomat(columnName));
			stringBuffer.append(";" + NEW_LINE + "       }" + NEW_LINE);
			
			/*********************get ���� ******************************/
			stringBuffer.append("       ");
			stringBuffer.append("public ");
			stringBuffer.append(getAapitalizeFomat(column.getName()));
			stringBuffer.append(" " + "get");
			stringBuffer.append(getAapitalizeFomat(column.getName()));
			stringBuffer.append("()");
			stringBuffer.append("{" + NEW_LINE);
			stringBuffer.append("           ");
			stringBuffer.append("return ");
			stringBuffer.append("this.");
			stringBuffer.append(propertyFomat(column.getName()));
			stringBuffer.append(";" + NEW_LINE);
			stringBuffer.append("       }" + NEW_LINE);
		}
		stringBuffer.append(NEW_LINE + "}");
		return stringBuffer.toString();
	}
	/**
	 * TODO �������String���շ�д��(����ĸ��д),����:
	 * WF_FORM_PRINT_TEMPLET -- WfFormPrintTemplet
	 * @param string
	 * @return String
	 */
	private static String getAapitalizeFomat(String string){
		return StringUtils.capitalize(propertyFomat(string));
	}
}
 