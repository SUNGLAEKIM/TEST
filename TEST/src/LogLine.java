import java.util.ArrayList;

public class LogLine {
	
	ArrayList<String> logList = new ArrayList<String>();
	
	private RandCode r = new RandCode();;
	
	private int myTime = 32400000;
	
//	private String timeStamp = new String();
	private String conveyor = new String();
	private String barcode = new String();
	private String trayId = new String();
	
//	private int convSize;
//	private int barSize;
	private int traySize;
	
	private int barRange;
	private int lineSize;
	private int convNum;
	
	private void init() {		
//		timeStamp = "2017-03-12 ";
//		convSize = r.getConvSize();
//		barSize = r.getBarvSize();
		traySize = r.getTraySize();
		
		lineSize = 100; // �α� �� ���ϱ� :100��
		convNum = 0; // �����̾� ���ϱ�
		barRange = 10; // �� �����̾ ����ϴ� ���ڵ� ����
	}
	
	private String TimeString() {
		String result = new String();
		
		int hour = myTime/3600000;
		int temp = myTime%3600000;
		int minute = temp/600;
		int second = temp%60;
		String msecond = Integer.toString(myTime).substring(5);
		
		result = "2017-03-12 " + this.cal(hour) +":"+ this.cal(minute) +":"+ this.cal(second)+"."+msecond;
		
		return result;
	}
	
	private void PrintLine() {
		String myLog = new String();

		conveyor = r.getConveyor(convNum); 

		for (int i = 0; i < lineSize; i++) {
			int barRand = (int)(Math.random()*(barRange+10*convNum));
			int trayRand = (int)(Math.random()*traySize);
			barcode = r.getBarcode(barRand);
			trayId = r.getTrayId(trayRand);
			String timeStamp = this.TimeString();
			
			myLog = timeStamp + " [EQP_OPERATION      ][Conveyor" + conveyor + "        ][00" + barcode
					+ "][     Conveyor1E/__I_D" + barcode.substring(3)
					+ "_D_ReqReadBCR_Observa][17   ] Retval : �԰����� ,������ : 2 ,TrayID : " + trayId;

			System.out.println(myLog);
			
			myTime += barRand*trayRand;
		}
	}
	
	private String cal(int v) {
		String result = new String();
		
		if(v < 10)
			result = "0"+Integer.toString(v);
		else
			result = Integer.toString(v);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		LogLine l = new LogLine();
		
		l.init(); 
		l.TimeString();
		l.PrintLine();
        
	}	

}