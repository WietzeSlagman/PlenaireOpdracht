import java.io.*;

class Dictionary{

	public static void main(String[] args){
		
	}

	private Array wordsList(String file){
		String[] wordsList = new String[10000]
		int i = 0;

		try{
			File words = newFile(file);
			reader = new BufferedReader(new FileReader(file));

			String line=;
			while(line = reader.readLine() != null){
				wordsList[i] = line;
				i++;
				if(wordsList[i] == null){
					String[] newWordsList = new String[wordsList.length * wordsList.length]
					for(int j = 0; j < wordsList.length; j++){
						newWordsList[j] = wordsList[j];
					}
					wordsList = newWordsList;
				}
			}

		} catch(IOException e){
			e.printStackTrace();
		}
		try{
			reader.close();
			return wordsList;

		} catch(IOException e){
			e.printStackTrace();
		}
	}

}
