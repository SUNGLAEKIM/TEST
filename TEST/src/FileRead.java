import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {
	
	ArrayList<DataSet> data=new ArrayList<DataSet>();

	private String defaultDir;
	private File dirFile;
	private File []fileList;
	private BufferedReader br;
	private String line;
	private DataSet dataSet;
	
	public FileRead() {
		
		defaultDir=System.getProperty("user.dir");
		defaultDir+="\\logFiles";
	}
	
	public ArrayList<DataSet> readFiles()  {

		dirFile=new File(defaultDir);
		fileList=dirFile.listFiles();
		for(int i=0;i<fileList.length;i++){
			 try {
				 
				br= new BufferedReader(new FileReader(fileList[i]));
				dataSet=new DataSet(fileList[i].getName()); 
				int lineCount=0;
				  try {
					while ((line = br.readLine()) != null) {
						
						dataSet.makeHash(lineCount, line);
						lineCount++;
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
