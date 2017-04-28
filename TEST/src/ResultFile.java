import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ResultFile {

	private File dir;
	private File file;
	private String defaultDir;
	private ArrayList<DataSet> data;
	
	public ResultFile(ArrayList<DataSet> d) {
		defaultDir = System.getProperty("user.dir");
		defaultDir += "\\resultFiles";
		
		dir = new File(defaultDir);
		
		data.addAll(d);
		
	}
	
	public void writeResult() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String resultLine="";
		
		try {
			System.out.println("****Result directory :" + defaultDir);
			
			dir.mkdir();
			file = new File(dir, "result.txt");
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			//for result DataSet의 줄 수만틈
			//resultLine = DataSet 읽어오는 함수.라인 읽어오는 함수
			//bw.write(resultLine);
			
			bw.close();
			fw.close();
						
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
}
