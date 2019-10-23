
/**
 * Write a description of class Word here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Word implements Comparable<Word>
{
    // instance variables - replace the example below with your own
    private String word;
    private int score;
    
    /**
     * Constructor for objects of class Word
     */
    public Word(String w, int s)
    {
        this.word = w.toLowerCase();
        this.score = s;
    }

    public int getScore()
    {
        return this.score;
    }
    public String getWord()
    {
        return this.word;
    }
    @Override
    public int compareTo(Word compareWord)
    {
        return 0;
    }
}
