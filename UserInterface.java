import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
/**
 * This is where the high level commands happen
 *
 * @author Jack, Angel, Andy
 * @version October 2019
 */
public class UserInterface
{
    public static void main(String[] args)
    {
        ArrayList<Word> words = new ArrayList<>();
        String fileName = "";
        Scanner scan = new Scanner(System.in);
        
        boolean takeInput = true;
        while(takeInput){
            System.out.println("What is the file name?");
            fileName = scan.nextLine();
            if(fileName.equals(".quit") || fileName.equals(".exit")){
                takeInput = false;
                scan.close();
                return;
            }

            boolean askForPrefix = true;

            try{
                words = FileReader.train(fileName);
            } 
            catch(Exception e){
                System.out.println("Error: " + e);
                askForPrefix = false;  //doesn't make sense to ask for the prefix if the file hasn't been read properly
            }

            Collections.sort(words); //sorts words by Word.getWord() alphabetically

            while (askForPrefix){
                System.out.println("What is your search?");
                String prefix = scan.nextLine();
                if(prefix.equals(".quit") || prefix.equals(".exit")){
                    takeInput = false;
                    scan.close();
                    return;
                }
                
                ArrayList<Word> result = BinarySearch.searchFor(prefix, words);

                // Sort result by frequency using... COMPARATOR! hooray. Frequency is found with Word.getScore()
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
                    
                if(result.size() >= 10){
                    for(int i = result.size() - 1; i > result.size() - 11; i--){
                        System.out.println(result.get(i).getWord());
                    }
                }
                else{
                    for(int i = result.size() - 1; i > -1; i--){
                        System.out.println(result.get(i).getWord());
                    }
                }
            }
        }

        scan.close();
    }
}
