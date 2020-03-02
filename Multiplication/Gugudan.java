public class Gugudan {

	public void print() {
		// TODO Auto-generated method stub
			
	//규칙성:반복, 상황에 따라 :if
	//한 번, 최소 처리 단위를 찾아라.
	//최소 단위에서 변화하는 부분, 변화하지 않는 부분 나누기
	//System.out.println(2 + " x " + 1 + " = " + 2);
	//변하는 부분을 변수로 두기
	//System.out.println(d + " x " + i + " = " + (d * i));
	int di = 1; //1씩 더하는것을 변수로둬서 수정편하게
	for ( int a = 2 ; a <= 9 ; a += di ) {
		
		for ( int b = 1; b <= 9; b += di ) {
			
			System.out.println( a + " x " + b + " = " + (a * b));
			
			}
		
		}
	}

}
	
