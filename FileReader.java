import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

/**
 * Write a description of class FileReader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileReader
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class FileReader
     */
    public FileReader()
    {
        // initialise instance variables

    }

    public static ArrayList<Word> train(String fileName, ArrayList<Word> words) throws FileNotFoundException{
        Scanner keyboard = new Scanner(System.in);  // Used to get keyboard input
        Scanner file = new Scanner(new File(fileName));
        while(file.hasNext()== true){
            String line = file.nextLine();
            String[] wordsInLine = line.split(" ");
            for(int j = 1; j < (wordsInLine.length - 1); j++){

                int character = wordsInLine[j].charAt(0);
                if((65 <= character && character <= 90)||(97 <= character && character <= 122)){
                    int location = -1;
                    int score = Integer.parseInt(wordsInLine[0]);
                    //Finds the location of word in words.
                    location = Collections.binarySearch(words, new Word(wordsInLine[j]));
                    if (location < 0){
                        words.add(new Word(wordsInLine[j]));
                        location = words.size() -1;
                        //System.out.println("added a word");

                        Collections.sort(words);
                    } else {

                    }

                }
            }
        }
        // For Testing Purposes.
        for(int i = 0; i < words.size(); i++){
            System.out.println("Word: "+words.get(i).getName());
            //System.out.println("TotleScore: "+words.get(i).getTotalScore());
            System.out.println("AvgScore: "+words.get(i).getAvgScore());
            //System.out.println("Occurences: "+words.get(i).getOccurences());
            System.out.println(" ");

        }

        return words;
    }

}
