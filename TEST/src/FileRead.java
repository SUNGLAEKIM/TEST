import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileRead {
	
	//DataSet set =new Dataset("filename");
	//set.method(fillenumber,linenumber,String);
	//���Ϻ��� �о�ͼ�  ���ϳѹ�, ���γѹ��� parameter�� �޴� method,String
	// �� method�� fillenumber,linenumber,String �� �����ִ� ���·� �����
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
		     * for( file ������ŭ)
		     *     {
		     *     hashmap=new HashMape();
		     *     
		     *     ������ ����
		     *     �� ���Ͽ� ���ؼ� 
		     *     ������ �ϴ� ������
		     *     ������ ][ ©��, ex)11, 12, 13, 14,15 (����� class ���� ����)
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
