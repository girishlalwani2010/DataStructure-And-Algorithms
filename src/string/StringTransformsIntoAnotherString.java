package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/string-transforms-into-another-string/discuss/355399/Placeholder-character-is-the-key-to-understand-this-question
 *
 *
 *If all 26 characters will be used in str2 then there is no case to break the cycle.
 *
 *For ex: str1 : abcd.........xyz
 *		  str2 : bcde.........yza, if last z is converted to a, then we have to convert second last as well as it was converted from 
 *		  y-z, so end two characters will have cyclic dependency it will aa after transform and that is false.
 *		
 *So there should be one temp character to do the transformation, for ex with cycle: abcd - bcda, how the conversion will take place.
 *
 *
 *abcd ---a to b--- bbcd ---b to c--- cccd ----c to d --- dddd wrong conversion.
 *
 *Suppose we start from end
 *abcd ---d to a--- abca ---c to d--- abda ---- b to c--- acda -- then a to b -- will change a to z then to b, 
 *as if we change it directly it will change another a as well due to cycle, so will first scan the string and will convert that 
 *into zcda --- then bcda.
 *
 *So will need one temporary lowercase character that is not used in string2
 *
 *hence the check   if (getFrequency(str2).size() >= 26) {
            return false;
        }
 *
 * 	
 */
public class StringTransformsIntoAnotherString {

	
	public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        if (getFrequency(str2).size() >= 26) {
            return false;
        }
		
        Map<Character, Character> map = new HashMap<>();
        for (int i = str1.length() - 1; i >= 0; i--) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        return true;
    }
    
    private Map<Character, Integer> getFrequency(String str) {
        Map<Character, Integer> res = new HashMap<>();
        for (final char c : str.toCharArray()) {
            res.putIfAbsent(c, 0);
            res.put(c, res.get(c) + 1);
        }
        return res;
    }
    
}
