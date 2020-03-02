public class Gugudan2 {
	
	public void print() {
	int a = 2;
	int di = 1;
	
	while ( a <= 9 ) {
		for ( int b = 1; b <= 9; b += di ) {
			System.out.println(a + " x "+b+" = "+(a*b));
			}
		a += di;
	}	
	
}
	

}
