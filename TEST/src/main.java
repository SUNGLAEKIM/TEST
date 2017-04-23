import java.util.ArrayList;

import javax.xml.crypto.Data;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWrite fw=new FileWrite();
		fw.write();	
		
		System.out.println(System.getProperty("user.home"));
		
		FileRead fr=new FileRead();
		//fr.readFiles();
		
		
		
		//file 정보를 객체화...(성래형)
		
		ArrayList<DataSet> data;
		data=fr.readFiles();
		
		for(int i=0;i<data.size();i++){
			System.out.println(data.get(i).fileName);
			
		}
		
		//
		
	}

}