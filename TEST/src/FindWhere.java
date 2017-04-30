import java.util.ArrayList;
import java.util.HashMap;

public class FindWhere {

	ArrayList<DataSet> data;
	ArrayList<String> result=new ArrayList<String>();
	private String key="";
	HashMap<String, String> dataMap;
	private int lineSize=0;
	
	public FindWhere(ArrayList<DataSet> data){
		this.data=data;
	}
	
	
	
	public ArrayList<String> result(String key ,String value){
		this.key=key+"";
			
		//System.out.println(dataMap.get("16"));
		for(int i=0;i<data.size();i++){//file 갯수 만큼
			
			dataMap=data.get(i).getHashMap();
			
			//System.out.println(this.key);
			lineSize=dataMap.size()/6;
			//System.out.println(lineSize);
			//System.out.println(dataMap.get("16"));
			for(int k=1;k<=lineSize;k++){
				this.key=k+key+"";
				
				//System.out.println(value+" : "+dataMap.get(this.key));
				//System.out.println(this.key+" : "+dataMap.get(this.key));
				if((dataMap.get(this.key).contains(value))){
					System.out.println((data.get(i).fileName+" 의 ["+k+"] 번째 줄 : "
							+dataMap.get(k+"1")+" "
							+dataMap.get(k+"2")+" "
							+dataMap.get(k+"3")+" "
							+dataMap.get(k+"4")+" "
							+dataMap.get(k+"5")+" "
							+dataMap.get(k+"6")+" "
									));
					result.add(
							data.get(i).fileName+" 의 ["+k+"] 번째 줄 : "
									+dataMap.get(k+"1")+" "
									+dataMap.get(k+"2")+" "
									+dataMap.get(k+"3")+" "
									+dataMap.get(k+"4")+" "
									+dataMap.get(k+"5")+" "
									+dataMap.get(k+"6")+" "
											
							
							);
				}					
						
			}
			
			
		}
		//System.out.println(data.size());
		//System.out.println(dataMap.size());
		
		
		return result;
	}
}
