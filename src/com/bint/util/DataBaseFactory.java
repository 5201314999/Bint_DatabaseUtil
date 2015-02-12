package com.bint.util;

import com.bint.data.DataBase;
import com.bint.data.DataSource;
import com.bint.data.MySQLDataBase;
import com.bint.data.OracleDataBase;
/**
 * ���ݿ⹤��
 * @author  linhongbin
 * @data:  2015��2��12�� ����10:55:19
 * @version:  V1.0
 */
public class DataBaseFactory {
	private static DataSource dataSource = new DataSource();
	
	public static DataBase getDataBaseInstance(){
		return getDataBase();
	}
	/**
	 * �õ����ݿ�ʵ��
	 * @return DataBase
	 * @author linhongbin
	 */
	public static DataBase getDataBase(){
		XMLUtil xmlUtil = new XMLUtil();
		String result = xmlUtil.dbType.toLowerCase();
		if ("mysql".equals(result)){
			return new MySQLDataBase(dataSource);
		}else if("oracle".equals(result)){
			return new OracleDataBase(dataSource);
		}else if("sqlserver".equals(result)){
			//TODO �½�һ��SQL Server�����ݿ�
			
		}else if("sqllit".equals(result)){
			//TODO �½�һ��SQLList�����ݿ�
		}
		return null;
	}

}
