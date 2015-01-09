package com.bint.data;

import org.apache.commons.lang.StringUtils;

import com.bint.exception.NotDealtException;
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
	 * @throws TypeNotRecognizedException
	 */
	public static String judgeDataType(String type) throws TypeNotRecognizedException{
		String low_result = StringUtils.lowerCase(type);
		if (StringUtils.equals("date",low_result)){
			return "Date";
		}if(StringUtils.equals("varchar2", low_result)){
			return "String";
		}if(StringUtils.equals("varchar",low_result)){
			return "String";
		}if(StringUtils.equals("bigint",low_result)){
			return "long";
		}if(StringUtils.equals("int", low_result)){
			return "int";
		}if(StringUtils.equals("number",low_result)){
			return "long";
		}if(StringUtils.equals("clob", low_result)){
			return "byte[]";
		}if(StringUtils.equals("blob", low_result)){
			return "byte[]";
		}
		throw new TypeNotRecognizedException(type);
	}
}
