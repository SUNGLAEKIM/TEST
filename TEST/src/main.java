import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWrite fw=new FileWrite();
		//fw.write();	
		
		//System.out.println(System.getProperty("user.home"));
		
		FileRead fr=new FileRead();
		
		ArrayList<DataSet> data;
		data=fr.readFiles();
		
		
		
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
		
		
		FindWhere where =new FindWhere(data);
		where.result("6", "VSTH832719");
		//key, value 받는 로직
		//ArrayList<String> result=where.result(key, value);
		// result 를 파일에 출력
	}

}