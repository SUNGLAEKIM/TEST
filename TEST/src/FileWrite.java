import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWrite {

	File dir = new File("C:\\Users\\speed\\Desktop\\logFiles");
	File file;
	private int fileListNumber=10;
	private int fileLine=100;
	
	public void write(){
		BufferedWriter bw = null;
		FileWriter fw = null;
		String content="";
		

		try {

			for(int i=0;i<fileListNumber;i++){

				//fw = new FileWriter(FILENAME+i+".txt");
				//((Object) fw).getParentFile().mkdirs();
			    dir.mkdir();
				file=new File(dir,i+".txt");
				fw = new FileWriter(file);
				bw = new BufferedWriter(fw);
				for(int j=0;j<fileLine;j++){

					// LogLine 에서 받을 String
					content = "This is LogLine 에서 받을 String +"+j+" line\r\n";
					bw.write(content);
					
				}
				bw.close();
				fw.close();
			}
			
			

			System.out.println("Done");

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
