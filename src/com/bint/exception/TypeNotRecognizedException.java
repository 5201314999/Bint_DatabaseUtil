package com.bint.exception;

public class TypeNotRecognizedException extends Exception{
	private static final long serialVersionUID = 1L;

	public TypeNotRecognizedException(String type){
		super("�������������޷�ʶ��:" + "��������Ϊ" + type);
	}
}
