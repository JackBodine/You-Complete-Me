
/**
 * Write a description of class Word here.
 *
 * @author Jack Bodine
 * @version (a version number or a date)
 */
public class Word implements Comparable<Word>
{
    // instance variables - replace the example below with your own
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

    public long getScore()
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
        if (this.score > compareWord.getScore()){
            return 1;
        } else if(this.score < compareWord.getScore()){
            return -1;
        } else {
            return 0;
        }
    }
}
