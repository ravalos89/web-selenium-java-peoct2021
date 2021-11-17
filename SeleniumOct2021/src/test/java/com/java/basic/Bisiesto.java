package com.java.basic;

public class Bisiesto {

	public static void main(String[] args) {
		boolean x = isLeapYear(2020);
		System.out.println(x);

	}
	
	public static boolean isLeapYear(int year){
        if(year>=1 && year<=9999){
            int divisible = year % 4;
            if( divisible == 0){
                divisible = year % 100;
                if(divisible == 0) {
                    divisible = year %400;
                    if(divisible==0){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
	
	public static boolean areEqualsblablabla(double x, double y) {
		
		// 4.00915717717167		
		// 4.01028772972
		
		x = x *1000;
		y = y *1000;
		
		int convertX = (int) x;
		int convertY = (int) y;
		
		if(convertX==convertY) {
			return true;
		}else {
			return false;
		}
	}

}
