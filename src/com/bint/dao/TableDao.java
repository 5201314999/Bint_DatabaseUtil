package com.bint.dao;

import java.sql.SQLException;
import java.util.List;

import com.bint.data.Column;
import com.bint.data.Table;
/**
 * 
 * @author  linhongbin
 * @data:  2015��2��12�� ����10:52:51
 * @version:  V1.0
 */
public interface TableDao {
	/**
	 * �õ�ĳ��������е���
	 * @param tableName
	 * @throws SQLException
	 * @return List<Column>
	 * @author linhongbin
	 */
	public List<Column> getAllColumnByTableName(String tableName) throws SQLException;
	/**
	 * �õ���ǰ���ݿ�����еı�����
	 * @throws SQLException
	 * @return List<String>
	 */
	public List<String> getAllTableName() throws SQLException;
	/**
	 * �ж��Ƿ�Ϊ����
	 * @param column
	 * @param table
	 * @throws SQLException
	 * @return Column
	 * @author linhongbin
	 */
	public Column isPrimaryKey(Column column , Table table) throws SQLException; 
}
