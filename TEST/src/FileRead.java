import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileRead {
	
	//DataSet set =new Dataset("filename");
	//set.method(fillenumber,linenumber,String);
	//파일별로 읽어와서  파일넘버, 라인넘버를 parameter로 받는 method,String
	// 위 method에 fillenumber,linenumber,String 을 던져주는 형태로 만들기
	public void readFiles(){
		try(Stream<Path> paths = Files.walk(Paths.get("/home/you/Desktop"))) {
		    paths.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
		            System.out.println(filePath);
		        }
		    });
		    
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
}
