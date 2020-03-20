package stars;

public class Star2 {

		static public void main(String[] args) {
		
		int f = 1; //시작 별 갯수
		int t = 2; //몇개씩 늘어남?
		int l = 7; //젤 많은 별 개수
		int a; //계산 위해서 바뀌는 별개수
		int b; //바뀌는 공백 수
		
		for (a = f; a <= l-t ; a += t) {
			
			b= (l-a)/2;
			for (int i = 0; i < b; i++) {
				System.out.print(" ");
				}
			for ( int i = f; i <= a; i++) {
				System.out.print('*');
				}				
			System.out.println();
		}
				
		for  (; a >= f; a -= t) {
			
			b= (l-a)/2;
			
			for (int i =0; i < b; i++) {
				System.out.print(" ");
			}
			for (int i = a; i >= f; i -= 1) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}