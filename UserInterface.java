import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class UserInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserInterface
{
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void main()
    {
        ArrayList<Word> words = new ArrayList<>();
        String fileName = "";
        Scanner scan = new Scanner(System.in);
        
        System.out.println("What is the file name?");
        fileName = scan.nextLine();
        
        FileReader fr = new FileReader();
        try{
            words = fr.train(fileName);
        } 
        catch(Exception e){
            System.out.println("Error: "+e);
        }
        
        boolean askForPrefix = true;
        while (askForPrefix){
            
            
        }
    }
}
