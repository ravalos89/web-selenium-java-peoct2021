package com.java.basic;

public class SumOdd {
	
	public static void main(String[] args) {

		System.out.println(sumOdd(1,100));
		System.out.println(sumOdd(-1,100));
		System.out.println(sumOdd(100,100));
		System.out.println(sumOdd(13,13));
		System.out.println(sumOdd(100,-100));
		System.out.println(sumOdd(1,4));
		
	}
	
	public static boolean isOdd(int number){
		// Paso 1
        if(number<0){
            return false;
        }

        if(number % 2 != 0){
            return true;
        }else{
            return false;
        }
    }

    public static int sumOdd(int start, int end){
        if((start>end) || start<=0 || end <=0){
            return -1;
        }
        int sum=0;
        for(int i = start; i <=end; i++){
            if(isOdd(i)){
                sum+=i;
            }
        }
        return sum;
    }

}
