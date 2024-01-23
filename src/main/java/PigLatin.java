import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String word) {
        //precondition: sWord is a valid String of length greater than 0.
        //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
	{
	  for(int i = 1; i <= word.length(); i++){
	    if((word.substring(i-1,i)).equals("a"))
	      return i-1;
	    if((word.substring(i-1,i)).equals("e"))
	      return i-1;
	    if((word.substring(i-1,i)).equals("i"))
	      return i-1;
	    if((word.substring(i-1,i)).equals("o"))
	      return i-1;
	    if((word.substring(i-1,i)).equals("u"))
	      return i-1;
	  }
        return -1;
    }

    public String pigLatin(String sWord)
        //precondition: sWord is a valid String of length greater than 0
        //postcondition: returns the pig latin equivalent of sWord
	{
	  if((sWord.substring(0,2)).equals("qu"))
	    return sWord.substring(2) + "quay";
	  if(findFirstVowel(sWord) == 0)
	    return sWord + "way";
	  if(findFirstVowel(sWord) == -1)
	  {
	    return sWord + "ay";
	  }
	  else if(findFirstVowel(sWord.substring(0,1)) == -1){
	    int i = 0;
	    while(findFirstVowel(sWord.substring(0,i)) == -1){
	      i++;
	    }
	    return sWord.substring(i-1) + sWord.substring(0,i-1) + "ay";
	  }
	  else
	  {
	    return "ERROR!";
	  }
    }
}

} //end PigLatin class

