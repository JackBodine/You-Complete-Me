import java.util.ArrayList;
/**
 * Write a description of class Tester here.
 *
 * @author Jack, Angel, Andy
 * @version (a version number or a date)
 */
public class Tester
{
    public static void mainTester(){
        ArrayList<Word> words = new ArrayList<>();
        Word word1 = new Word("police", 12);
        Word word2 = new Word("polyglot", 54);
        Word word3 = new Word("polymorphic", 24);
        Word word4 = new Word("polywally", 43);
        Word word5 = new Word("pom", 102);
        
        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);
        
        ArrayList<Word> possibleWords = BinarySearch.searchFor("poly", words);
        
        for(Word s : possibleWords){
            System.out.println(s.getWord());
        }
    }
}
