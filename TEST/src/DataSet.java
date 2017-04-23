import java.util.HashMap;
import java.util.StringTokenizer;

public class DataSet {
	String fileName;
	

	HashMap<String, String> dataMap = new HashMap<String, String>();
	
	
	public DataSet(String s) { //constructor
		
		fileName = s;
		
		
	}
	
	public void makeHash(int Lnum, String s){
				
		StringTokenizer st = new StringTokenizer(s, "][");
			while (st.hasMoreTokens()) {
				String tokenList[] = new String[6];

				tokenList[0] = st.nextToken();
				tokenList[0] = tokenList[0].trim();

				st.nextToken();

				tokenList[1] = st.nextToken().substring(8, 10);

				tokenList[2] = st.nextToken();
				tokenList[2] = tokenList[2].trim();

				tokenList[3] = st.nextToken().substring(20, 25);

				st.nextToken();

				String str = st.nextToken();
				str = str.trim();
				int end = str.indexOf(" ,TrayID : ");
				tokenList[4] = str.substring(9, end);
				tokenList[5] = str.substring(end + 11);

				for (int j = 0; j < 6; j++) {
					dataMap.put(String.valueOf(Lnum + 1) + String.valueOf(j + 1), tokenList[j]); // Lnum+1번째 줄, j+1번째 토큰
				}

			}
		
	}
	
	public String getFileName() {
		
		return this.fileName;
	}

	public HashMap<String, String> getHashMap() {
		
		return dataMap;
		
	}
}
