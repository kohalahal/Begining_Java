public class Gugudan3 {
	
	public void print() {
		
		int di = 1;
		int cols = 3 ;
		
		for ( int i = 2; i <= 9; i += 3 ) {
			for ( int b = 1 ; b<= 9; b+= di ) {
				for ( int k = 0; k < cols ; k++ ) {
					if(i+k <= 9) {System.out.print((i+k) + " x " + b + " = " +((i+k)*b)+ "   " );}
					
				}
				System.out.println();
				
			
		}
		
	}

}
}
