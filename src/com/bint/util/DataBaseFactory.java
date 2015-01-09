package com.bint.util;

import com.bint.data.DataBase;
import com.bint.data.DataSource;
import com.bint.data.OracleDataBase;

public class DataBaseFactory {
	private static DataSource dataSource = new DataSource();
	
	public static DataBase getDataBaseInstance(){
		return getDataBase();
	}
	public static DataBase getDataBase(){
		XMLUtil xmlUtil = new XMLUtil();
		System.out.println(xmlUtil.dbType);
		String result = xmlUtil.dbType.toLowerCase();
		System.out.println("result:" + result);
		if ("mysql".equals(result)){
			DataBase oracle =  new OracleDataBase(dataSource);
			System.out.println(" atfer new OracleDataBase" );
			return oracle;
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
