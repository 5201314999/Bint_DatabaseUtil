package com.bint.data.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.bint.data.Table;
import com.bint.db.DBConnection;
import com.bint.db.info.IDataBaseInfo;
import com.bint.util.DataSource;

public class DataUtil {
	public DBConnection dbCon = null;
	public PreparedStatement pstmt = null;
	public Connection conn = null;

	public DataUtil(DataSource dabaSource){
		/*try {
			dbCon = new DBConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		conn = this.dbCon.getConnection();
	}
	
	public List<Table> getTables(){
		//TODO �ж�ʲô���ݿ⣬���ظ����ݿ���ӵ�еı�
		
		return null;
	}
	
	
	
	public Table getOracleTable(){
		//TODO ��Oracle���б��ѯ������һ��table��
		
		return null;
	}
	
	public Table getMySQLTable(){
		//TODO
		return null;
	}
}
