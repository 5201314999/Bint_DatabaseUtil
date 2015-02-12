package com.bint.db.info;

public class OracleInfo implements IDataBaseInfo {
	public static final String ORACLED_DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String ORACLE_URL_PART = "jdbc:oracle:thin:@127.0.0.1:1521:";
	public static final String ORACLE_TABLE_QUERY_SQL = "SELECT table_name from tabs";
	//查询表所有的字段名及其数据类型
	public static final String ORACLE_COLUMN_QUERY_SQL= "select column_name , data_type from user_tab_columns where Table_Name= ?";
	//查询某个表的主键为外键的约束
	public static final String ORACLE_CONSTRAIN_NAME_QUERY_SQL = "select constraint_name from user_constraints e where e.table_name=? and constraint_type='P'";
	
	
	
	@Override
	public String getUrl() {
		return ORACLE_URL_PART ;
	}
	@Override
	public String getDriverName() {
		return ORACLED_DRIVER_NAME;
	}
	@Override
	public String getTablesQuerySql() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getColumnquerySql() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
