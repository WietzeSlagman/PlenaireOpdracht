

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Dictionary{

	public static void main(String[] args){
		String file = args[0];
		System.out.println(file);
		String[] words = wordsList(file);
		System.out.println(words[5]);
	}

	private static String[] wordsList(String file){
		String[] wordsList = new String[10000];
		String[] tempWords;
		int i = 0;
		BufferedReader reader;

		try{
			File words = new File(file);
			reader = new BufferedReader(new FileReader(file));

			String line;
			while((line = reader.readLine()) != null){
				wordsList[i] = line;
				i++;
				if(wordsList[i] == null){
					tempWords = new String[wordsList.length * wordsList.length];
					
					for(int j = 0; j < wordsList.length; j++){
						tempWords[j] = wordsList[j];
					}
					wordsList = tempWords;
				}
			}

			reader.close();
	

		} catch(IOException e) {
			e.printStackTrace();
		}

		return wordsList;
	}

}
