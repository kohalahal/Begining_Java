package com.bit.demo.carpark;
//패키지 같으니까 스캐너 임포트 필요없다

import com.bit.demo.carpark.model.Car;

public class ParkService {

	//스페이스안에 카들이 여러개 저장되어있다...... 
	//카가 들어있는것은   스페이스. 서비스는 그 중간연결역할
	private Space cardao = new Space(20);//data access object
	private int min;
	private int n;
	private double gibonryo;
	private double hourfee;
	private double income;
	
	
	public ParkService() {
		
		min = 30;
		n = 5;
		gibonryo = 900d;
		hourfee = 400;
		income = 0;
		
	}
	
	
	
	
	public int spaceCheck() {
		return cardao.spaceCheck();
	}
	
	public int carnoCheck(String carno) {
		return cardao.indexOfNo(carno); 
		
	}
	
	public Car getCar(String carno) {
		return cardao.selectByNo(carno);
	}
	
	public void saveCar(Car car) {
		cardao.save(car);
		
	}
	
	public void clearCar(String carno) {
		cardao.clear(carno);
	}

	public int getHour(Car car) {
		return car.getOutTime()-car.getInTime();
		
	}
	public double getPrice(Car car) {
		double price = 0;
		//11:00~10:00 영업 전제.
//		int inMint = car.
//		inMint += (car.getInTime()/100)*60; //분단위로 바꿈 /시를 자름.
//		
//		int outMint = (car.getOutTime()%100);
//		outMint += (car.getOutTime()/100)*60; //분단위로 바꿈 /시를 자름.
//		
//		int diff = (outMint - inMint) / 10; //나가는시간이 더 큰 것 전제, 분으로 바꿈.
		
		price = gibonryo + (hourfee * (((getHour(car)-min)/n)+((getHour(car)-min)%n>0 ? 1 : 0)));
		income += price;
		return price;
		
	}

	public double getIncome() {
		return income;
	}

	public int finish() {
		// TODO Auto-generated method stub
		return cardao.finish();
	}

	public Car[] carLeft() {
		return cardao.carLeft();
	}
		
	public void feeTable() {
		System.out.println("최초 "+min+"분 기본 요금 : "+gibonryo+"원");
		System.out.println("추가 "+n+"분 마다 : "+hourfee+"원 ");
	}

}
