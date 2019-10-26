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
    /**
     * train(String) doesn't really train anything but it reads the file into an arraylist of Word objects
     * each Word is used to store the frequency and the word.
     */
    public static ArrayList<Word> train(String fileName) throws FileNotFoundException{

        Scanner keyboard = new Scanner(System.in);  // Used to get keyboard input
        Scanner file = new Scanner(new File(fileName));
        
        while(file.hasNext()== true){
            String line = file.nextLine();
            String[] wordsInLine = line.split(" ");
            long score = Long.parseLong(wordsInLine[0]);
            words.add(new Word(wordsInLine[1].toLowerCase(), score));
        }
        
        return words;
    }
}
