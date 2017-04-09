import java.util.ArrayList;

public class LogLine {
	
	ArrayList<String> logList = new ArrayList<String>();
	
	private RandCode r;
	
	private int myTime = 32400000;
	
	
	private String conveyor = new String();
	private String barcode = new String();
	private String trayId = new String();
	
	private int traySize;
	
	private int barRange;
//	private int lineSize;
	private int convNum;
	
	
	public LogLine(int n) {		
		
		r = new RandCode(n);
		
		traySize = r.getTraySize();
		
//		lineSize = 10000; // 로그 줄 정하기 :100줄
//		convNum = 1; // 컨베이어 정하기
		barRange = 10; // 한 컨베이어가 사용하는 바코드 개수
	}
	
	public String TimeString() {
		String result = new String();
		
		int hour = myTime/3600000;
		int temp = myTime%3600000;
		int minute = temp/600;
		int second = temp%60;
		String msecond = Integer.toString(myTime).substring(5);
		
		result = "2017-03-12 " + this.cal(hour) +":"+ this.cal(minute) +":"+ this.cal(second)+"."+msecond;
		
		return result;
	}
	
	 public String PrintLine(int num) {
		String myLog = new String();

		conveyor = r.getConveyor(num); 

		int barRand = (int) (Math.random() * (barRange + 10 * convNum));
		int trayRand = (int) (Math.random() * traySize);
		barcode = r.getBarcode(barRand);
		trayId = r.getTrayId(trayRand);
		String timeStamp = this.TimeString();

		myLog = timeStamp + " [EQP_OPERATION      ][Conveyor" + conveyor + "        ][00" + barcode + "][     Conveyor"
				+ conveyor + "/__I_D" + barcode.substring(3)
				+ "_D_ReqReadBCR_Observa][17   ] Retval : 입고성공 ,단정보 : 2 ,TrayID : " + trayId+"\r\n";

//		System.out.println(myLog);

		myTime += barRand * trayRand;
		
		return myLog;
	}
	
	private String cal(int v) {
		String result = new String();
		
		if(v < 10)
			result = "0"+Integer.toString(v);
		else
			result = Integer.toString(v);
		
		return result;
	}
	/*
	public static void main(String[] args) {
		
		
        
	}	*/

}
