package com.bit.demo.carpark;

import java.util.Scanner;

import com.bit.demo.carpark.model.Car;//하위 패키지도 임포트해야한다.

/**
 * 
 * 
 * 부트앱은 입출력만 담당. 다른 클래스에서는 입출력안함. 명확하게 담당 범위 설정.
 * 
 * @author hb2015
 *
 */
//서비스 대수랑 클론만들어서 주는 것

public class BootApp {
//	public static int size = 5; //주차 가능 대수????????????????????????서비스???????????
	
	public static void main(String[] args) {
		
		ParkService service = new ParkService();
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("----------------------------");
			System.out.println("☆★☆★  커피콩 공영 주차장입니다  ★☆★☆");
			System.out.println("☆★☆★  관리 시스템 접속중입니다  ★☆★☆");
			System.out.println("[1] 입차    [2] 출차    [3] 영업종료");
			System.out.println("[4] 주차요금 보기  [5] 현재 상태 보기");
			System.out.println("----------------------------");

			String menu = input.nextLine();
			
			if (menu.equals("4")) {
				System.out.println("<우리 주차장 요금 안내>");
				service.feeTable();
			}
			
			else if (menu.equals("5")) {
				System.out.println("<현재 주차된 차량 정보>");
				System.out.println("----------------------------");
				System.out.println("남은 차량 : " + service.finish() +" 대");
				System.out.println("----------------------------");
				for (int i = 0 ; i < service.finish(); i++) {
					
					System.out.println(service.carLeft()[i].toString());
					System.out.println("----------------------------");
				}

				System.out.println("오늘 매상 : "+ service.getIncome() + " 원");
				
			}

			else if (menu.equals("3")) {
				System.out.println("☆★☆★  고생하셨습니다**안녕히가세요  ★☆★☆");
				System.out.println("----------------------------");
				System.out.println("<현재 주차된 차량 정보>");
				System.out.println("----------------------------");
				System.out.println("남은 차량 : " + service.finish() +" 대");
				System.out.println("----------------------------");
				for (int i = 0 ; i < service.finish(); i++) {
					
					System.out.println(service.carLeft()[i].toString());
					System.out.println("----------------------------");
				}

				System.out.println("오늘 매상 : "+ service.getIncome() + " 원");
				System.out.println("----------------------------");
				break;
				
			} // if3

			// 차 나갈 때
			else if (menu.equals("2")) {
				System.out.println("----------------------------");
				System.out.println("출차  ☆★  요금 정산하기");
				System.out.println("차량 번호 :");
				String carno = input.nextLine();
				
				if (service.getCar(carno) == null ) {
					System.out.println("등록된 차량이 아닙니다");

				}
				else {	
				Car car = service.getCar(carno);// 서비스의 겟카에 카번호를 넘겨준다. 그럼 반환되는게 있다. 받아옴.
				// 검색해서 inTime을 알아내어야함
				//이전에 들어온 차가 이제 나오니깐 겟카해서 이제 시간 알아내고 계산할것인데
				//null이면 안되니깐 확인하는것 꼭만들기
				//차의 정보가 없으면 큰일났어 문제임. 이런 상황까지 다 생각해내야함. 구멍안나게.
				

				System.out.println("출차 시간 :");
				int outTime = Integer.parseInt(input.nextLine());

				if ( outTime > 0 && outTime/100 < 60 && ((outTime%100) + (outTime/100)*60) > car.getInTime()) {
				car.setOutTime(outTime);

				
				System.out.println(car);

				// 돈의 액수는 실수형으로
				System.out.println("주차 시간 : 총" +service.getHour(car)+"분");
				double price = service.getPrice(car); // 출력해야하니까 변수는 메인에놓지만 계산은 Service한테 시키기

				System.out.println("요금 : " + price + " 원");

				// 들어와서 저장했던 기록 비우기를 직접 해야한다.
				// 비우려면 위치를 알아야한다. 그러면 배열이 적합-요소 번호가 위치이기때문에
				service.clearCar(carno);
				
				}
				else {
					System.out.println("시간 입력이 잘못되었습니다.");}
				}
			
			} // if2

			// 차 들어올 때
			else if (menu.equals("1")) {
				// 차가 생겨야됨
				System.out.println("----------------------------");
				if ( service.spaceCheck() == 1) { //if space O
				System.out.println("어서오세요.");
				
				Car car = new Car();

				System.out.println("입차  ☆★ 정보 기록하기");
				System.out.println("차량 번호:");
				String carno = input.nextLine();
				// nextInt해도 되지만, nextLine은 키보드입력을 전~부다가져온다. 그래서 잔존값이없어서 에러 줄인다.
				// 사용자가 HHmm 제대로 입력한다는 전제
				
					//같은 차량 번호 주차 정보가  있는지 체크
					if ( service.carnoCheck(carno) == -1 ) {
					car.setNo(carno);
					System.out.println("입차 시간:");
					
					int inTime = Integer.parseInt(input.nextLine());
					if ( inTime > 0 && inTime%100 < 60) {
					car.setInTime(inTime);
					service.saveCar(car);
					} else {
						System.out.println("시간 입력 오류");
					}
					
					// 문자열을 합치는 과정 중요!
					/*
					 * String s = ""; 
					 * s += "차량" + carno + "는 "; 
					 * s += inTime; 
					 * s += "에 들어왔습니다."; 
					 * System.out.println("입차:"+s);
					 * 얘네를 이제 toString으로 넣어버리기
					 */
					}//if carnocheck ok
					
					//만약에 차가 들어왔는데 원래있던 차야-나간차가 초기화가 안돼서 오류났을수도.
					//아직 주차중인데왜여깃지? 같은 문제생길 수 있다.
					//프로그램상 문제없이해야지. 사고방식이 중요하다.
					else { 
						System.out.println("이미 주차된 차량입니다."); 
					} //else carnocheck X
				
				}//if space O
				else { 
					System.out.println("만차입니다."); 
					;} //if space X
			
	
			} // if1

			// 어떻게하죠?
			else {
				System.out.println("메뉴 똑바로 고르세요.");

			} // 입력 검사

		} // while

	}// main

}// class
