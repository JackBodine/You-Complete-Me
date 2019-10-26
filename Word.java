
/**
 * Write a description of class Word here.
 *
 * @author Jack Bodine
 * @version (a version number or a date)
 */
public class Word implements Comparable<Word>
{
    private String word;
    private long score;

    /**
     * Constructor for objects of class Word
     */
    public Word(String w, long s)
    {
        this.word = w.toLowerCase();
        this.score = s;
    }
    
    /**
     * gets the frequency, or score of a Word object
     */
    public long getScore()
    {
        return this.score;
    }
    
    /**
     * gets the actual word in the Word object
     */
    public String getWord()
    {
        return this.word;
    }
    
    /**
     * Overrides compareTo in order to properly compare and alphabetize Word objects by their words.
     */
    @Override
    public int compareTo(Word compareWord)
    {
        return this.word.compareTo(compareWord.getWord());
    }
}
