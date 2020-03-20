

import java.util.Scanner;

public class Gugudan6 {
	
	static Scanner sc = new Scanner(System.in);
	
	public void print(int startDan, int endDan) {
		
//		int startDan = 0;
//		int endDan = 0;
		
		int a;
		int b;
		
//		System.out.print("시작 단 입력:");
//		startDan = sc.nextInt();
//		System.out.print("종료 단 입력:");
//		endDan = sc.nextInt();
//		System.out.println("-------");
//		
		//a = (startDan<endDan)? startDan:endDan;
		//b = (a==startDan)? endDan:startDan;
		
		int temp;
		
		if (startDan>endDan) {
			temp = startDan;
			startDan = endDan;
			endDan = temp;
		}
		
		a = startDan;
		b = endDan;
				
		for(int i = a; i <= b; i++) {
			for(int j = 1; j<10; j++) {
				System.out.printf("%d*%d=%d\n", i, j, i*j);
			} System.out.println("-------");
		}
		
	}

}