package datastructure.string;
import java.util.Scanner;
 
public class StringSearchUsingNaiveMethod
{
    private final int BASE;
    private int[]     occurrence;
    private String    pattern;
 
    public StringSearchUsingNaiveMethod(String pattern)
    {
        this.BASE = 256;
        this.pattern = pattern;
        occurrence = new int[BASE];
        for (int c = 0; c < BASE; c++)
            occurrence[c] = -1;
        for (int j = 0; j < pattern.length(); j++)
            occurrence[pattern.charAt(j)] = j;
    }
 
    public int search(String text)
    {
        int n = text.length();
        int m = pattern.length();
        int skip = 0;
        int steps = 0;
        for (int i = 0; i <= n - m; i += skip)
        {
        	
            for (int j = m - 1; j >= 0; j--)
            {steps++;
            	
                if (pattern.charAt(j) != text.charAt(i + j))
                {
                    skip = Math.max(1, j - occurrence[text.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0){
            	System.out.println("Number Of Steps: "+steps);
                return i;
            }
        }
        System.out.println("Number Of Steps: "+steps);
        return n;
    }
 
    public static void main(String[] args)
    {
        
        String pattern = "are";
        StringSearchUsingNaiveMethod nsm = new StringSearchUsingNaiveMethod(
                pattern);
        int first_occur_position = nsm.search("Ankur and Girish are friends");
        System.out.println("The text '" + pattern
                + "' is first found after the " + first_occur_position
                + " position.");
    }
}