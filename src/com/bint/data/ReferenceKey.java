package com.bint.data;

public class ReferenceKey extends Column {
	// �����ݿ��еı�����δ�����շ�д������
	private String referenceTable;
	private String column;

	public ReferenceKey(String tableName) {
		super(tableName);
	}
	
	
}
