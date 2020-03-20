package stars;

import java.util.Scanner;

public class Star1 {

	static Scanner sc = new Scanner(System.in);
	static public void main(String[] args) {
		
		int min = 1;
		int max;
		int blank;
		int t = 2; //몇 개씩 늘어남?
		
		do {
			System.out.println("별을 몇 개까지 찍어볼까?(홀수) >");
			max = sc.nextInt();
			
		} while( max % 2 == 0 );
		
		System.out.printf("%d개부터 %d개까지 마름모로 별찍기\n", min, max);
		sc.close();
		
		blank = (max - min)/2;
		int end = blank;
		
		for ( int i = 0; i < max; i++) {
			
			for (int j = 0; j < max; j++) {
				
				System.out.print((blank <= j && j <= end)? "*" : " ");
			}


			blank = (i < max/2) ? blank - 1 : blank + 1;
			end = (i < max/2) ? end+1 : end -1;
			System.out.println();
		}
		
		
	}
}
