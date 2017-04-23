import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileRead {
	
	ArrayList<DataSet> data=new ArrayList<DataSet>();
	
	int Fnum;
	int Lnum;

	private String defaultDir;
	private File dirFile;
	private File []fileList;
	private File file;
	private BufferedReader br;
	private String line;
	private DataSet dataSet;
	//DataSet set =new Dataset("filename");
	//set.method(fillenumber,linenumber,String);
	//파일별로 읽어와서  파일넘버, 라인넘버를 parameter로 받는 method,String
	// 위 method에 fillenumber,linenumber,String 을 던져주는 형태로 만들기
	
	public FileRead() {
		
		defaultDir=System.getProperty("user.dir");
		defaultDir+="\\logFiles";
	}
	
	public ArrayList<DataSet> readFiles()  {

		dirFile=new File(defaultDir);
		fileList=dirFile.listFiles();
		for(int i=0;i<fileList.length;i++){
			//System.out.println(fileList[i].getName());
			 try {
				 
				br= new BufferedReader(new FileReader(fileList[i]));
				dataSet=new DataSet(fileList[i].getName()); 
				int lineCount=0;
				  try {
					while ((line = br.readLine()) != null) {
					        //System.out.println(line);
						lineCount++;
						dataSet.makeHash(lineCount, line);
					      }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		     
			data.add(dataSet); 
		}
		return data;
	}
	
	
}
