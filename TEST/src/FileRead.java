import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class FileRead {
	
	ArrayList<HashMap<String, String>> dataSet = new ArrayList<HashMap<String, String>>();

	int Fnum;
	int Lnum;
	
	//DataSet set =new Dataset("filename");
	//set.method(fillenumber,linenumber,String);
	//파일별로 읽어와서  파일넘버, 라인넘버를 parameter로 받는 method,String
	// 위 method에 fillenumber,linenumber,String 을 던져주는 형태로 만들기
	
	public FileRead() {
		
		dataSet.add(null); //어레이리스트 0번 인덱스 null값 추가, 파일 번호 1번부터 만들어서 직관적으로 하기 위해서
		
	}
	
	public void readFiles(){
		try(Stream<Path> paths = Files.walk(Paths.get("/home/you/Desktop"))) {
		    paths.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
		            System.out.println(filePath);
		        }
		    });

		    //임시 variable
		    Fnum = 1; //위에서 읽은 파일 넘버
			Lnum = 10; // 위에서 읽은 라인 개수
			String s = "2017-03-12 09:3869:03.883 [EQP_OPERATION      ][Conveyor1B        ][001P11310][     Conveyor1E/__I_D1310_D_ReqReadBCR_Observa][17   ] Retval : 입고성공 ,단정보 : 2 ,TrayID : EXOO421528 EXOO247711";
			//읽어온 로그 줄
		    
			/*
			 * 헷갈리는 것 --> readFile에서 한줄 씩 읽어서 makeSet으로 보내는 건지, 전체를 읽어서 makeSet에서 한줄씩 처리해야 하는 건지?
			 * 현재 코드는 후자로 작성함
			 * 전자라면 코드 수정 필요(For문이 본 클래스로 와야함)
			 */
			
			makeSet(Fnum, Lnum, s);
			/*
		     * 
		     * 
		     * for( file 갯수만큼)
		     *     {
		     *     hashmap=new HashMape();
		     *     
		     *     데이터 가공
		     *     한 파일에 대해서 
		     *     한줄을 일단 들고오고
		     *     한줄을 ][ 짤라서, ex)11, 12, 13, 14,15 (기능은 class 따로 빼고)
		     *     
		     *     hashmap.add(key,value);
		     *     hashmap.add("11","2017-01-02:23:11:11..");
		     *     hashmap.add("12"....)
		     *     
		     *     arraylist.add(hashmap);
		     *     }
		     */
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		//ArrayList<DataSet> dateSet=new ArrayList<>();
	}
	
	public void makeSet(int Fnum, int Lnum, String s) { //위에서 읽은 데이터를 DataSet으로 가공
		
		DataSet set = new DataSet(""); //선언
	
		set.makeHash(Lnum, s); //Lnum(라인 수)만큼 HashMap 생성
		
		dataSet.add(Fnum, set.getHashMap()); //생성된 HashMap 어레이리스트(dataSet) 추가
		
/*
 * 어레이리스트 확인 테스트 코드
		
		for(int k = 1; k < dataSet.size(); k++) {
			System.out.println("k : " + k);
			for(int l = 0; l < dataSet.get(k).size()/6; l++) {
				System.out.print(l+1 + ": ");
				for(int m = 0; m < 6; m++) {
					String key = String.valueOf(l+1)+String.valueOf(m+1);
					System.out.print(dataSet.get(k).get(key) + " / ");
				}
				System.out.println();
			}	
		}
*/		
		
	}
	
}
