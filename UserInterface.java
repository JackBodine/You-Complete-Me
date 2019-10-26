import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.lang.*; 
import java.io.*; 
/**
 * Write a description of class UserInterface here.
 *
 * @author Jack, Angel, Andy
 * @version (a version number or a date)
 */
public class UserInterface
{
    public static void main(String[] args)
    {
        ArrayList<Word> words = new ArrayList<>();
        String fileName = "";
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("What is the file name?");
            fileName = scan.nextLine();

            boolean askForPrefix = true;

            FileReader fr = new FileReader();
            try{
                words = fr.train(fileName);
            } 
            catch(Exception e){
                System.out.println("Error: " + e);
                askForPrefix = false;  //doesn't make sense to ask for the prefix if the file hasn't been read properly
            }

            Collections.sort(words);

            while (askForPrefix){
                System.out.println("What is your search?");
                String prefix = scan.nextLine();
                ArrayList<Word> result = BinarySearch.searchFor(prefix, words);

                // Sort result by frequency (score)
                Collections.sort(result, new Comparator<Word>(){
                        public int compare(Word a, Word b){
                            if(a.getScore() == b.getScore()){
                                return 0;
                            }
                            else if (a.getScore() > b.getScore()){
                                return 1;
                            }
                            else{
                                return -1;
                            }
                        }
                    });

                for(int i = result.size() - 1; i > result.size() - 11; i--){
                    System.out.print(result.get(i).getWord());
                }
            }
        }
    }
}
