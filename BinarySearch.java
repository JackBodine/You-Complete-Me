import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

/**
 * Write a description of class BinarySearch here.
 *
 * @author Andy Chamberlain
 * @version (a version number or a date)
 */
public class BinarySearch
{
    private static ArrayList<Word> possibleWords = new ArrayList<>();

    /**
     * Constructor for objects of class BinarySearch
     */
    public BinarySearch(){
    }

    /**
     * So basically, binary search for a Word where the word within has the input prefix, then check up and down from that one
     * until you find ones that don't have the prefix. Add each of the words with the prefix to possibleWords
     */
    public static ArrayList<Word> searchFor(String str, ArrayList<Word> allWords){
        Boolean prefixFound = false;
        int minimum = 0;
        int maximum = allWords.size() - 1;
        int mid;
        int theFirstIndexFound = -1;
        int theFirstIndexWithPrefix = -1;
        int theLastIndexWithPrefix = -1;

        while(!prefixFound){
            // did you update also remember to push
            mid = (minimum + maximum) / 2;
            String s = allWords.get(mid).getWord();  // s is the word in allWords whose index is mid
            String sPrefix = s.substring(0, Math.min(s.length(), str.length()));  // sPrefix = first n letters of s where n is the length of str

            if(sPrefix.equals(str)){
                theFirstIndexFound = mid;
                prefixFound = true;
            }
            else if(sPrefix.compareTo(str) < 0){  // sPrefix comes after input str
                minimum = mid;
            }
            else if(sPrefix.compareTo(str) > 0){  // sPrefix comes before input str
                maximum = mid;
            }
        }

        if(theFirstIndexFound >= 0){ // here we will check up and down from the one the while loop found
            Boolean firstIndexIsFound = false;
            Boolean lastIndexIsFound = false;
            int i = 1;
            while(!firstIndexIsFound){
                String sPrevious = allWords.get(theFirstIndexFound - i).getWord();
                String sPreviousPrefix = sPrevious.substring(0, Math.min(sPrevious.length(), str.length()));
                if(!sPreviousPrefix.equals(str)){
                    firstIndexIsFound = true;
                    theFirstIndexWithPrefix = theFirstIndexFound - i + 1;
                }
                i++;
            }
            i = 1;
            while(!lastIndexIsFound){
                String sNext = allWords.get(theFirstIndexFound + i).getWord();
                String sNextPrefix = sNext.substring(0, Math.min(sNext.length(), str.length()));
                if(!sNextPrefix.equals(str)){
                    lastIndexIsFound = true;
                    theLastIndexWithPrefix = theFirstIndexFound + i - 1;
                }
                i++;
            }

            for(int k = theFirstIndexWithPrefix; k <= theLastIndexWithPrefix; k++){
                possibleWords.add(allWords.get(k));
            }
        }
        return possibleWords;
    }
}
