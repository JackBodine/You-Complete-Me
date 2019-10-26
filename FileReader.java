import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

/**
 * Write a description of class FileReader here.
 *
 * @author Jack, Angel, Andy
 * @version (a version number or a date)
 */
public class FileReader
{
    // instance variables - replace the example below with your own

    private Scanner keyboard = new Scanner(System.in); 
    protected static ArrayList<Word> words;
    
    /**
     * Constructor for objects of class FileReader
     */
    public FileReader()
    {
       words = new ArrayList<>();
    }

    public static ArrayList<Word> train(String fileName) throws FileNotFoundException{

        Scanner keyboard = new Scanner(System.in);  // Used to get keyboard input
        Scanner file = new Scanner(new File(fileName));
        
        while(file.hasNext()== true){
            String line = file.nextLine();
            String[] wordsInLine = line.split(" ");
            long score = Long.parseLong(wordsInLine[0]);
            words.add(new Word(wordsInLine[1].toLowerCase(), score));
        }
        // For Testing Purposes.
        /*for(int i = 0; i < words.size(); i++){
            System.out.println("Word: "+words.get(i).getWord());
            System.out.println("Score: "+words.get(i).getScore());
            System.out.println(" ");

        }*/

        return words;
    }

}
