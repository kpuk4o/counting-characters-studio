import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CharacterCounter {
    // Class Variables

    // Constructors
    public CharacterCounter() {

    }

    // Methods
    public void countCharacters(String wordToCount) {

        //make string not case sensitive
        wordToCount = wordToCount.toLowerCase();

        char[] arrayOfChars = wordToCount.toCharArray();
        HashMap<Character, Integer> myCharacterCount = new HashMap<>();
        for (int i = 0; i < arrayOfChars.length; i++) {

            //Exclude non alpha characters
            if (Character.isLetter(arrayOfChars[i]) == false) {
                //Exclude the character i.e. ignore is
                continue;
            }

            // Add or update the count of each character into the hash map
            char theCharacter = arrayOfChars[i];
            if (myCharacterCount.containsKey(theCharacter) == false) {
                // doesn't contain the key
                myCharacterCount.put(theCharacter, 1);
            } else {
                //Contains the key
                Integer theValue = myCharacterCount.get(theCharacter);
                theValue += 1;
                myCharacterCount.put(theCharacter, theValue);
            }
        }
        ArrayList<Character> myCharacterKeys = new ArrayList<>(myCharacterCount.keySet());
        for (int i = 0; i < myCharacterKeys.size(); i++) {
            Integer theValue = myCharacterCount.get(myCharacterKeys.get(i));
            System.out.println(myCharacterKeys.get(i) + ": " + theValue);
        }
    }
    //Bonus
    public String getUserInput() {
        Scanner myScanner = new Scanner(System.in);
        String myUsersInput = myScanner.nextLine();
        myScanner.close();
        return myUsersInput;
    }

    //Create a new method to read text from a file
    public String getTextFromFile(String pathToTheFile) {
        String content = "";
        try {
            content = new String (Files.readAllBytes(Paths.get(pathToTheFile)));
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return content;
    }

}
