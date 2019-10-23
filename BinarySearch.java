import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

/**
 * Write a description of class BinarySearch here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearch
{
    // instance variables - replace the example below with your own
    private ArrayList<Word> possibleWords;
    private String prefix;

    /**
     * Constructor for objects of class BinarySearch
     */
    public BinarySearch()
    {

    }
    /**
     * So basically, binary search for a Word where the word within has the input prefix, then check up and down from that one
     * until you find ones that don't have the prefix. Add each of the words with the prefix to possibleWords
     */
    public ArrayList<Word> searchFor(String str, ArrayList<Word> allWords){
        Boolean prefixFound = false;
        int i = 0;
        while(!prefixFound){
            // yo did you update also remember to push
        }

        return possibleWords;
    }
}
