import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NBOcc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = args[0];
		String researched_word = args[1];
		int nb_occurence = 0;
		List<String> lines = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		}
		catch (Exception e)
		{
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		}
		for (String line : lines) {
			/* Parcourt les mots de chaque ligne en enlevant les caractères de ponctuation et en enlevant les majuscules */
			for (String word : line.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split(" ")) {
				if(word.contentEquals(researched_word))
					nb_occurence += 1;
			}
		}
		System.out.println("Nombre d'occurences : " + nb_occurence);
	}
}
