import java.util.ArrayList;
import java.util.Scanner;

public class main {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileWrite fw = new FileWrite();

		//fw.write();	
		
		//System.out.println(System.getProperty("user.home"));
		
		FileRead fr=new FileRead();
		
		ArrayList<DataSet> data;
		data = fr.readFiles();
		
		
		//��� ����Ʈ�� �� ������ Ȯ���ϴ� ����
		for(int k = 0; k < data.size(); k++) {
	          System.out.println("k : " + k);
	          for(int l = 0; l < data.get(k).dataMap.size()/6; l++) {
	            // System.out.print(l+1 + ": ");
	             for(int m = 0; m < 6; m++) {
	                String key = String.valueOf(l+1)+String.valueOf(m+1);
	                //System.out.print(data.get(k).dataMap.get(key) + " / ");
	             }
	            // System.out.println();
	          }   
	       }
		
		

		FindWhere where = new FindWhere(data);

		where.result("6", "VSTH832719");
		Scanner sc = new Scanner(System.in);
		int select = 0;
		String fKey ="";
		String fValue = "";
		String fCheck = "N";
		
		while(select < 1 || select > 3) {
		System.out.println("What do you want to find?");
		System.out.println("1.Tray ID / 2.Sereal Number / 3.Barcode");
		
		select = sc.nextInt();
		sc.nextLine();
		}
		
		switch (select) {

		case 1:
			fKey = "6";
			break;

		case 2:
			fKey = "3";
			break;

		case 3:
			fKey = "4";
			break;

		}
		
		while (fCheck.equals("N")) {
			System.out.println("Enter your keyword");
			System.out.print(": ");
			fValue = sc.nextLine();

			System.out.println("Your keyword: " + fValue + " (Y/N)");

			fCheck = sc.nextLine();

		}
		
		//key, value �޴� ����
		ArrayList<String> result = where.result(fKey, fValue);
		
		// result �� ���Ͽ� ���
		ResultFile rf = new ResultFile(result);
		rf.writeResult();
		
		
	}

}