import variations.Gugudan;
import variations.Gugudan2;
import variations.Gugudan3;
import variations.Gugudan4;
import variations.Gugudan5;
import variations.Gugudan6;


public class BootApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("========gugu1========");
		Gugudan gugu = new Gugudan();
		gugu.print();
		System.out.println("========gugu2========");
		Gugudan2 gugu2 = new Gugudan2();
		gugu2.print();
		System.out.println("========gugu3========");
		Gugudan3 gugu3 = new Gugudan3();
		gugu3.print();
		System.out.println("========gugu4========");
		Gugudan4 gugu4 = new Gugudan4();
		gugu4.print();
		System.out.println("========gugu5========");
		Gugudan5 gugu5 = new Gugudan5();
		gugu5.print(2, 6);
		System.out.println("========gugu6========");
		Gugudan6 gugu6 = new Gugudan6();
		gugu6.print(3, 7);
		
	}

}
