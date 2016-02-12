
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileToArray_util {
 	private BufferedReader br;
 	private String path;

 	public FileToArray_util(String path)  {
 		this.path = path;
 	}

 	public String[] readLines() {
 		List<String> lines = null;
 		try {
	 		br = new BufferedReader(new FileReader(path));
	 		lines = new ArrayList<String>();
	 		String line = null;

	 		while ((line = br.readLine()) != null) {
	 			lines.add(line);
	 		}
	 		br.close(); 			
 		} catch (IOException e){
 			e.printStackTrace();
 		}
 		return lines.toArray(new String[lines.size()]);
 	}
}

