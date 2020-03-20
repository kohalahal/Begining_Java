import java.util.Scanner;
import static java.lang.System.out;

public class Comparison {

static Scanner sc = new Scanner(System.in);
	
	static public void main(String args[]) {
		
		
		int a, b, c;
		int min, mid, max;
		
		out.print("입력1:"); a=sc.nextInt();
		out.print("입력2:"); b=sc.nextInt();
		out.print("입력3:"); c=sc.nextInt();
		
	
			if(a>b) {
				if(a>c) {
					max = a;
					if(b>c) {
						mid = b;
						min = c;
					} else {
						mid = c;
						min = b;
					}
				} else { 
					max = c;
					mid = a;
					min = b;
				} 
			} else {
					if(b>c) {
						max = b;
						if(a>c) {
							mid = a;
							min = c;
						} else {
							mid = c;
							min = a;
						}
					} else {
						max = c;
						mid = b;
						min = a;
				} 
			}
			
			System.out.printf("min:%d\nmid:%d\nmax:%d\n", min, mid, max);
	}
}
