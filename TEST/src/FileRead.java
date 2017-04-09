import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileRead {

	public void readFiles(){
		try(Stream<Path> paths = Files.walk(Paths.get("/home/you/Desktop"))) {
		    paths.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
		            System.out.println(filePath);
		        }
		    });
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
