package variations;


public class Gugudan5 {

	public void print(int a, int b) {
		
				
		int start = a;
		int end = b;
		
		
		
		for (int i = 0; i <10; i++) {
			
			if(i==0) {
				for(int k = 0; k <= end-start; k++) {
					int j = start + k;
					System.out.printf("***%d***\t\t", j);	
				} System.out.println();
			}	else {
				for(int k = 0; k <= end-start; k++) {
					int j = start + k;
					System.out.printf("%d*%d=%d\t\t", j, i, j*i);
				} System.out.println();
			}
			
		}
		
	}
}
