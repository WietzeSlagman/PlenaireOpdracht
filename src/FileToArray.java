

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileToArray {
 	BufferedReader br;
 	String path;
 	FileReader fr;

 	public FileToArray(String path)  {
 		this.path = path;
 	}

 	public String[] readLines() {
 		List<String>  
 		try {
	 		fr = new FileReader(path);
	 		br = new BufferedReader(fr);
	 		List<String> lines = new ArrayList<String>();
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

