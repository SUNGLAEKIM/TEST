import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWrite {
	
	File dir ;
	File file;
	private int fileListNumber;
	private int fileLine;
	private String defaultDir;
	LogLine l ;
	
	public FileWrite(){
		defaultDir=System.getProperty("user.dir");
		defaultDir+="\\logFiles";
		dir=new File(defaultDir);
			
		fileListNumber=10;
		fileLine=100;
		l= new LogLine(fileListNumber);
		
		 
		l.TimeString();
		
	}
	
	public void write(){
		BufferedWriter bw = null;
		FileWriter fw = null;
		String content="";
		

		try {
			System.out.println("****Deafulat directory :"+defaultDir);

			for(int i=0;i<fileListNumber;i++){

			    dir.mkdir();
				file=new File(dir,i+".txt");
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				for(int j=0;j<fileLine;j++){

					content=l.PrintLine(i);
					bw.write(content);
					
				}
				bw.close();
				fw.close();
			}
			
			

			//System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
}
