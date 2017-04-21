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
	//���Ϻ��� �о�ͼ�  ���ϳѹ�, ���γѹ��� parameter�� �޴� method,String
	// �� method�� fillenumber,linenumber,String �� �����ִ� ���·� �����
	
	public FileRead() {
		
		dataSet.add(null); //��̸���Ʈ 0�� �ε��� null�� �߰�, ���� ��ȣ 1������ ���� ���������� �ϱ� ���ؼ�
		
	}
	
	public void readFiles(){
		try(Stream<Path> paths = Files.walk(Paths.get("/home/you/Desktop"))) {
		    paths.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
		            System.out.println(filePath);
		        }
		    });

		    //�ӽ� variable
		    Fnum = 1; //������ ���� ���� �ѹ�
			Lnum = 10; // ������ ���� ���� ����
			String s = "2017-03-12 09:3869:03.883 [EQP_OPERATION      ][Conveyor1B        ][001P11310][     Conveyor1E/__I_D1310_D_ReqReadBCR_Observa][17   ] Retval : �԰��� ,������ : 2 ,TrayID : EXOO421528 EXOO247711";
			//�о�� �α� ��
		    
			/*
			 * �򰥸��� �� --> readFile���� ���� �� �о makeSet���� ������ ����, ��ü�� �о makeSet���� ���پ� ó���ؾ� �ϴ� ����?
			 * ���� �ڵ�� ���ڷ� �ۼ���
			 * ���ڶ�� �ڵ� ���� �ʿ�(For���� �� Ŭ������ �;���)
			 */
			
			makeSet(Fnum, Lnum, s);
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
	
	public void makeSet(int Fnum, int Lnum, String s) { //������ ���� �����͸� DataSet���� ����
		
		DataSet set = new DataSet(""); //����
	
		set.makeHash(Lnum, s); //Lnum(���� ��)��ŭ HashMap ����
		
		dataSet.add(Fnum, set.getHashMap()); //������ HashMap ��̸���Ʈ(dataSet) �߰�
		
/*
 * ��̸���Ʈ Ȯ�� �׽�Ʈ �ڵ�
		
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
