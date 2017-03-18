import java.util.ArrayList;

public class RandCode {
	
	ArrayList<String> conveyor = new ArrayList<String>();
	ArrayList<String> barcode = new ArrayList<String>();
	ArrayList<String> trayId = new ArrayList<String>();
	
	public RandCode() {
		
		this.setConveyor();
		this.setBarcode();
		this.setTrayId();
		
	}
	
	private void setConveyor() {
		String code = new String();
		
		for (int i = 1; i < 3; i++) {
			char c = 65;
			for (int j = 0; j < 5; j++) {
				code = Integer.toString(i) + c;
				conveyor.add(code);
				c += 1;
			}
		}
	}
	
	public String getConveyor(int i) {
		String result = new String();
		
		result = conveyor.get(i);
				
		return result;
	}
	
	public int getConvSize() {
						
		return conveyor.size();
	}
	
	private void setBarcode() {
		String code = new String();

		for (int i = 1; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				char c = this.charRand();
				for (int k = 0; k < 10; k++) {
					int v = this.intRand();
					code = Integer.toString(i) + c + Integer.toString(v).substring(1);
					barcode.add(code);
				}
			}
		}
	}
	
	public String getBarcode(int i) {
		String result = new String();
		
		result = barcode.get(i);
				
		return result;
	}
	
	public int getBarvSize() {
		
		return barcode.size();
	}
	
	private void setTrayId() {
		String code = new String();
		
		for (int i = 0; i < 50; i++) {
			String tray = new String();
			for (int j = 0; j < 4; j++) {
				char c = this.charRand();
				tray += c;
			}
			int id1 = this.intRand();
			int id2 = this.intRand();

			code = tray + id1 + " " + tray + id2;
			
			trayId.add(code);
		}

	}
	
	public String getTrayId(int i) {
		String result = new String();
		
		result = trayId.get(i);
				
		return result;
	}
	
	public int getTraySize() {
		
		return trayId.size();
	}
	
	private char charRand(){
		int v;
		char c;
		
		v = (int)(Math.random()*25)+65;
		c = (char)v;
		
		return c;
	}
	
	private int intRand(){
		int v;
		v = (int)(Math.random()*900000)+100000;
		return v;
	}
}
