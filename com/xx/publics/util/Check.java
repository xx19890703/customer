package com.xx.publics.util;

import javax.swing.JOptionPane;

public class Check {

	/**
	 * 校验是否为空
	 * @param value 校验值
	 * @param valueName 校验值的名称
	 */
	public static boolean checkNull(String[] valueNames,String[] values ){
		for(int i = 0;i<values.length;i++){
			if(values[i]==null||"".equals(values[i])){
				JOptionPane.showMessageDialog(null, valueNames[i]+"不能为空", "提示", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 校验是否为空
	 * @param value 校验值
	 * @param valueName 校验值的名称
	 */
	public static boolean checkNum(String[] valueNames,String[] values ){
		for(int i = 0;i<values.length;i++){
			if(values[i].matches("[0-9]*")){
			}else{
				JOptionPane.showMessageDialog(null, valueNames[i]+"必须是数字", "提示", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
//	public static void main(String[] args){
//		System.out.print("1231a32".matches("[0-9]*"));
//	}
}
