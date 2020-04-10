package org;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calc {
	String appname;
	Frame f;
	TextField t;
	GridBagConstraints c;
	Handler hand;
	Panel p; 
	Panel p1; 
	Panel p2_1;
	Panel p2_2;
	Panel p2_3;
	Panel p2_4;
	Panel p2; 
	Panel p3;
	
	int num1;
	int num2;
	Boolean state1;
	Boolean state2;
	Boolean oper;
	Boolean minus1;
	Boolean minus2;
	Boolean finish;
	String operate;
	String screen;
	


	public Calc() {
		
		appname="간단 계산기";
		num1 =0;
		num2 =0;
		
		state1=false;
		state2=false;
		oper=false;
		minus1=false;
		minus2=false;
		finish=false;
		operate="";
		screen="0";
		
		f = new Frame(appname);
		p = new Panel(new GridBagLayout());
		p1 = new Panel(new GridLayout(5, 1));
		p2_1 = new Panel(new GridLayout(1, 2));
		p2_2 = new Panel(new GridLayout(1, 2));
		p2_3 = new Panel(new GridLayout(1, 2));
		p2_4 = new Panel(new GridLayout(1, 2));
		p2 = new Panel(new GridLayout(5, 1));
		p3 = new Panel(new GridLayout(5, 1));
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
				System.exit(0);
			}
		});
		hand = new Handler();
		f.setSize(200, 300);
		String[] btn = {"CE","7","4","1","±","C","<<","8","9","5","6","2", "3","0","÷","×","-","+","="}; 
		Button[] btns = new Button[19];
		for(int i = 0; i<btns.length; i++) {
			btns[i]=new Button(btn[i]);
			btns[i].addActionListener(hand);
		}
		int i = 0;
		for(;i<5;) {
			p1.add(btns[i++]);
		}
		for(;i<7;) {
			p2_1.add(btns[i++]);
		}
		for(;i<9;) {
			p2_2.add(btns[i++]);
		}
		for(;i<11;) {
			p2_3.add(btns[i++]);
		}
		for(;i<13;) {
			p2_4.add(btns[i++]);
		}
		p2.add(p2_1);
		p2.add(p2_2);
		p2.add(p2_3);
		p2.add(p2_4);
		p2.add(btns[i++]);
		for(;i<19;) {
			p3.add(btns[i++]);
		}
		p.add(p1);
		p.add(p2);
		p.add(p3);
		t = new TextField(screen);
		t.setVisible(true);
		f.setLayout(new GridBagLayout());
		
		c = new GridBagConstraints();
		
		c.weightx=2;
		c.weighty=0.2;
		c.gridx =0;
		c.gridy =0;
		c.gridwidth=4;
		c.gridheight =1;
		c.fill=GridBagConstraints.BOTH;
		f.add(t,c);
		
		c.weightx=1;
		c.weighty=1;
		c.gridx =0;
		c.gridy =1;
		c.gridwidth=1;
		c.gridheight =5;
		f.add(p1,c);

		c.weightx=2;
		c.weighty=2;
		c.gridx =1;
		c.gridy =1;
		c.gridwidth=2;
		c.gridheight =5;
		f.add(p2,c);

		c.weightx=1;
		c.weighty=1;
		c.gridx =3;
		c.gridy =1;
		c.gridwidth=1;
		c.gridheight =5;
		f.add(p3,c);
		
		f.setVisible(true);
		
		
	}
	
	class Handler implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() instanceof Button) {
				Button btn = (Button)e.getSource();
				String s = btn.getLabel();
				calc(s);
			}
		}
	}

	public void calc(String s) {

		if(Character.isDigit(s.charAt(0))) {					//입력이 숫자면
			int a = Character.getNumericValue(s.charAt(0));
			System.out.print("숫자입력:"+a+"\n");
			
			if(finish) {System.out.println("finish면 클리어");clear();}
			System.out.println("finish클리어 끝");
			if(!(oper)) {								//연산자아직없으면,num1의 입력	
				if(a==0) { 				//0입력이면
					if(state1) {
						//num1이있으면
						num1=num1*10+a;
					} else {
						return;
					}
				} else { 				//0이외 입력이면
					if(state1) {
						num1=num1*10+a;
					} else {
						state1=true;
						System.out.println("num1: "+num1);
						num1=a;
					}
				}
			} else { 									//연산자있으면,num2의 입력
				if(a==0) {				// 0이면
					if(!state2) {
						return;
					} else {//num2가 있으면
						num2 = num2*10;
					}
				} else {				// 0아니면
					state2=true;
					num2 = num2*10+a;
				}
			}
		} else {													//입력이 숫자아니면
			if(finish) {
				clear();
			}
			
			if(state1&&!state2) {		//숫자1 O, 숫자2 X
				switch(s) {
				
				case "CE":clear(); break;
					
				case "±":if(oper) {if(minus2)minus2=false; else minus2=true;} else {if(minus1)minus1=false; else minus1=true;} break;
			
				case "C":clear(); break;
				
				case "<<":
					if(oper) {
						operate="";
						oper = false;
					} else {
					num1=num1/10;
					}
					break;
				
				case "÷":operate="÷"; oper = true; break;
				
				case "×":operate="×"; oper = true; break;
				
				case "-":operate="-"; oper = true; break;
				
				case "+":operate="+"; oper = true; break;
				
				case "=":break;
					
				}

			} else if(state2) {			//숫자1 O, 숫자2 O
				switch(s) {
				
				case "CE":clear2();break; //숫자2만 없앰
					
				case "±":
					if(minus2) {minus2=false;}
					else {minus2=true;} 
					break;						
				case "C":clear();break;
				
				case "<<":
					if(num2>10) {num2=num2/10;}
					else clear2();							
					break;
				case "÷":break;
				
				case "X":break;
				
				case "-":break;
				
				case "+":break;
				
				case "=":
					if(oper) {opera(operate, num1, num2); System.out.println("계산");} 
					break;
				}
			} else { 					//숫자 둘 다 입력안되어있으면
					switch(s) {
				
				case "CE":break;
					
				case "±":if(minus1)minus1=false; else minus1=true; break;
				
				case "C":break;
				
				case "<<":break;
				
				case "÷":break;
				
				case "X":break;
				
				case "-":break;
				
				case "+":break;
				
				case "=":break;
					
				}
			}

		}//이프숫자면 엘스숫자아니면 끝 입력끝
		System.out.println("state1"+state1+"   oper"+oper+"   state2"+state2+"   finish:"+finish);
		if(!finish) {
			if(state1) {
				System.out.println("시작.스크린을넘1로-"+num1+" "+screen);
				if(minus1) {
					screen="-";
				} else screen="";
				screen += Integer.toString(num1);
				if(oper) {
					screen+=operate;
					if(state2) {
						if(minus2) {
							screen+="(-";
						}
						screen+=Integer.toString(num2);
						if(minus2) {
							screen+=")";
						}
					}
				}
				System.out.println("끝  .스크린을넘1로-"+num1+" "+screen);
			}
			System.out.print(" num1:"+num1+"    num2:"+num2+"    스크린:"+screen+"\n");
			t.setText(screen);
		}
	
	}
		
		
	
	public void opera(String s, int a, int b) {
		finish=true;
		int x = 0;
		if(minus1) a = 0-a;
		if(minus2) b = 0-b;
		System.out.println("A:"+a+"      B:"+b+"     s:"+s);
		switch(s) {

		case "÷":x=a/b; System.out.println("a/b="+(a/b));break;
		
		case "×":x=a*b; System.out.println("a*b="+(a*b));break;
		
		case "-":x=a-b; System.out.println("a-b="+(a-b));break;
		
		case "+":x=a+b; System.out.println("a+b="+(a+b));break;
		

		}
		screen=Integer.toString(x);
		t.setText(screen);
		System.out.println("x:"+x);
	}
	
	public void clear() {

		num1 =0;
		num2 =0;
		state1=false;
		state2=false;
		oper=false;
		minus1=false;
		minus2=false;
		finish=false;
		operate="";
		screen="0";
		t.setText(screen);
	}
	
	public void clear2() {
	
		state2=false;
		minus2=false;
		num2=0;
		screen=Integer.toString(num1)+operate;
		t.setText(screen);
	}
	

	public static void main(String[] args) {
		new Calc();
	}

}
