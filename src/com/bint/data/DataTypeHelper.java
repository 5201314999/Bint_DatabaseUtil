package com.bint.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.bint.exception.TypeNotRecognizedException;
/**
 * �����������֣������������ݿ�����ص���������
 * @author BintLin
 *
 */
public class DataTypeHelper {
	/**
	 * �ж����ݿ��������Java��������Ӧ�Ĺ�ϵ
	 * @param type
	 * @return Java����������Ӧ�����ͣ���Ӧ��ϵ���£�
	 * 		data      ---  Data
	 *  	varchar   ---  String
	 *  	varchar2  ---  String
	 *  	bigint    ---  long
	 *  	int		  ---  int
	 * 		number    ---  long
	 * 	 	clob 	  ---  byte[]
	 *      blob      ---  byte[]
	 *      text      ---  String
	 * @throws TypeNotRecognizedException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static String judgeDataType(String type) throws TypeNotRecognizedException, FileNotFoundException, IOException{
		String lowResult = StringUtils.lowerCase(type);
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/type.properties"));
		Enumeration<Object> es = prop.keys();
		//��Properties��ȡ��keyȥ�ȶ�
		while(es.hasMoreElements()){
			String lowTypeStr = (String) es.nextElement();
			if(StringUtils.equals(lowTypeStr,lowResult)){
				return prop.getProperty(lowTypeStr);
			}
		}
		throw new TypeNotRecognizedException(type);
	}
}
