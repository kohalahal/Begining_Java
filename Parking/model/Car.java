package model;

public class Car {
	private int inhour;
	private int inmin;
	private int outhour;
	private int outmin;
	private String carno;

	public Car() {
		inhour = 0;
		inmin = 0;
		outhour = 0;
		inmin = 0;
	}
	
	public int getInTime() {

		return inhour*60+inmin;
//		System.out.print(inhour +" 시 "+inmin+" 분");
	}
	
	public void setInTime(int inTime) {
//인타임 아웃타임을 int하나로 뒀을때 분으로 계산해서 저장하기
//		this.intime = (intime%100) + (intime/100)*60;
		
//걍 따로 하기
		inhour = inTime/100;
		inmin = inTime%100;		
	}

	public void setOutTime(int outTime) {
//		this.outtime = (outtime%100) + (outtime/100)*60;
		outhour= outTime/100;
		outmin = outTime%100;	
	}
	
	public int getOutTime() {
		return outhour*60 + outmin;
//		System.out.print(outhour +" 시 "+outmin+" 분");
	}

	public void setNo(String carno) {
		this.carno = carno;
	}
	
	public String getNo() {
		return carno;
	}

	@Override//컴파일러가 @보면 추가처리 준비등등 해주는 에노테이션표시
	public String toString() {
		String s = "";
		s += "차량 번호 : "+carno+"\n";
		s += "입차 시간 : "+inhour+"시 "+inmin+"분"+"\n";
		s += "출차 시간 : "+outhour +"시 "+outmin+"분";
		return s;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


}
