

import java.util.Scanner;

public class Fibonacci {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int ttmp = 0;
		int tmp = 1;
		int num = 1;
		int sum = 1;
		int times = 1;
		
		do {
			System.out.println("피보나치 수열을 몇 개 더할까요?(두 개 이상) >");
			times = sc.nextInt();
		} while( times <= 1 );
	
		if ( times == 2) {
			System.out.println(tmp+"+"+num+"="+2);
			
		} else {
			System.out.print(tmp+"+");
		for (int i = 0; i < times-1; i++ ) {
			//System.out.println("/"+tmp+"/"+num+"/"+sum+"/");
			System.out.print(num);
			System.out.print((i < times-2)? "+":"=");
			sum += num;
			ttmp = num;
			num = tmp+ num;
			tmp = ttmp;
			
			//System.out.println("/"+tmp+"/"+num+"/"+sum+"/");
		}
		System.out.println(sum);
		
		}
		
	}
}