import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

/**
 * BinarySearch contains the function searchFor(String, ArrayList<Word>)
 * 
 * @author Jack, Angel, Andy
 * @version (a version number or a date)
 */
public class BinarySearch
{
    /**
     * Constructor for objects of class BinarySearch
     */
    public BinarySearch(){
    }

    /**
     * searchFor(String, ArrayList<Word> searches for a Word.getWord() which contains the input prefix in the sorted words ArrayList.
     * Once it has found one, it marks that with the index variable theFirstIndexFound, then it checks upward and downward from
     * that first Word.getWord() until it stops finding the prefix. All of the words it finds up until the prefix is no longer present
     * are added to the ArrayList possibleWords which is returned.
     * 
     * @parameters String, ArrayList<Word>
     */
    public static ArrayList<Word> searchFor(String str, ArrayList<Word> allWords){
        ArrayList<Word> possibleWords = new ArrayList<>();

        Boolean prefixFound = false;
        int minimum = 0;
        int maximum = allWords.size() - 1;
        int mid;
        int theFirstIndexFound = -1;
        int theFirstIndexWithPrefix = -1;
        int theLastIndexWithPrefix = -1;

        String lastWordChecked = "";

        while(!prefixFound){
            // did you update also remember to push
            mid = (minimum + maximum) / 2;
            String s = allWords.get(mid).getWord();  // s is the word in allWords whose index is mid
            String sPrefix = s.substring(0, Math.min(s.length(), str.length()));  // sPrefix = first n letters of s where n is the length of str

            //checks if the current word is the same as the last word; that indicates the prefix does not exist within BinarySearch
            if(s == lastWordChecked){
                prefixFound = true; // the prefix hasn't really been found but the loop needs to stop
                break;
            }

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
            lastWordChecked = s;
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
