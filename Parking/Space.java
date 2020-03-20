

import model.Car;

public class Space {

		private Car[] carList;
		
		//스페이스:::: CRUD. 저장 출력 수정 삭제. 배열에 대한 처리를 주로 한다.
		//배열안에 저장되는 각 데이터 - 요소
		//요소는 정수번호로 구분. 0~ length-1(배열명.length하면 길이나옴)
		//요소명 = 배열명[요소번호]
		
		
		//카리스트 생성해야쓸수있으니 생성자만들자
		 public Space(int size) {
			 //생성자 없으면 VM이 저절로만들건데, 내가 만들었으니까 안만들것임.
			 //직접 이것만 만들면 변수 빈 ()기본생성자는 안만들어진다는 것임. 그래서 변수없이 쓸수없음.
			 //사이즈 전달받는 이유는, 배열은 반드시 길이를 지정해야하기때문에. 
			 carList = new Car[size];
		 }//생성자
		 
	
		 
		 
		 //앞으로 많이 쓸 것
		 private int isEmpty() { //외부유출 위험한것은 프라이빗으로 가려서 보안하에
			 for(int i = 0 ; i<carList.length ; ++i ) { //for문은 검색해야되니 나왔소.요소번호가 표현되기때문. i=0부터. 요소번호 필요없이 값만 찾아봐도되면 포문필요없음. for each면 값을 바로처리. 요소번호 없이.
				 if ( carList[i] == null ) {
					 return i; //return은 함수종료. 반복끝.
				 }
			 }//빈 요소 가 없어갖구 포문 끝났다
			 	return -1;//만차일때. 배열요소번호는 음수가 없다. 그래서 음수는 오류남. 0번은 0번요소라서 쓰면안댐. 
		 }
		 
		/*
		 * for(Car c : carList) { //for each는 요소번호말고 요소속 데이터내에서 반복하고 나옴. }
		 */
		 
		 public int spaceCheck() {
			 int n = 1;
			 if (isEmpty() == -1) n = -1; 
			 return n;	 
		}
		 
		 
		 
		 //배열을 다루기
		 //1.데이터 집어넣어서 저장하기
		 public void save(Car car) {
			 //주차장에 입차
			 int idx = isEmpty();//빈 곳을 찾기/ null이 있으면 빈곳이고, null인 곳의 요소번호를 받아야한다. 요소번호는 정수.
			 if ( idx >= 0 ) {
			 carList[idx] = car;
			 System.out.println("주차 정보가 입력되었습니다.");//배열 중 한 요소에 저장을 하는 것. 찾은 빈 곳에 차넣는것.
			 System.out.println(car);
			 }
			 else System.out.println("만차 오류입니다.");
		 }//save
		 
		 //2. 데이터 읽어오기
	
		 //차번호 즈면 요소번호 달라
		 public int indexOfNo(String no) {
			 for (int i = 0; i < carList.length; ++i) {
				 if ( carList[i] != null ) {
				 
					 if (carList[i].getNo().equals(no)) { //배열형의 요소인 Car형.안의 String타입.의 메소드를 실행시켜서 처리 - 점을 찍어갈수록 타입이 바뀜. 배열이 스트링으로나옴.
						 //의 스트링차번호가 차번호랑 같으면
						 return i;
					 	}
				  }//null아니고 겹치는게 있으면 i
			  }
			 return -1;//없었으면 -1
			}
		 
		 //차번호로 차 정보 달라
		 public Car selectByNo(String carno) {
			 int i = indexOfNo(carno);
			 if(i == -1) {
				 return null;
			 }
			 return carList[i];
		}//selectByNo
		 
		 //남아있는 차정보 달라
		 //1.대수
		 public int finish() {
			 int t = 0;
			 for (int i = 0; i < carList.length; ++i) {
				 if ( carList[i] != null ) { t++; } 
			 }
			 return t;
		 }
		 
		 //2.정보
		 public Car[] carLeft() {
			 int b = 0;
 				 
			 Car[] carLeft = new Car[finish()];
			 
			 for (int i = 0; i < carList.length; ++i) {
				 if ( carList[i] != null ) { 
					 carLeft[b] = carList[i];
					 b++;
				 }
			 }
			 return carLeft;
			
		 }
		 
		 
		 //4.차가 나간다
		 public void clear(String carno) {//idx 자리에 있던 차가 나갔다. 어디차인지 받아야 내보낼수있다.
			 //출차
			 int idx = indexOfNo(carno);
			 if (idx != -1) {
				 carList[idx] = null;//자바에서 비었다=null
			 }
		 }//clear


}
