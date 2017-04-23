import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DataSet {
String fileName;
	
//	ArrayList<HashMap<String, String>> dataSet = new ArrayList<HashMap<String, String>>();

	HashMap<String, String> dataMap = new HashMap<String, String>();
	
/*	
 * 	임시 variable
	int f = 1;
	int l = 10;
	String logString = "2017-03-12 09:3869:03.883 [EQP_OPERATION      ][Conveyor1B        ][001P11310][     Conveyor1E/__I_D1310_D_ReqReadBCR_Observa][17   ] Retval : 입고성공 ,단정보 : 2 ,TrayID : EXOO421528 EXOO247711";
*/
	
	
	public DataSet(String s) { //constructor
		
		fileName = s;
		
//		dataSet.add(null); //어레이리스트 0번 인덱스 null값 추가, 파일 번호 1번부터 만들어서 직관적으로 하기 위해서
		
	}
	
	public void makeHash(int Lnum, String s){
				
		StringTokenizer st = new StringTokenizer(s, "][");
//		for (int i = 0; i < Lnum; i++) { // 로그의 줄 수 만큼 루프해서 각 줄 내용 파싱, i+1 = 현재 로그의 줄 번호
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
					System.out.println(String.valueOf(Lnum + 1) + String.valueOf(j + 1) + ", " + tokenList[j]);
				}

			}
//		}
		
	}
	
	public String getFileName() {
		
		return this.fileName;
	}

	public HashMap<String, String> getHashMap() {
		
		return dataMap;
		
	}
}
