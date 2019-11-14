package array;
class SlidingWindow_Count_of_substrings_which_contains_a_given_character_K_times_II  
{ 
      
// Function to return the count of required sub-strings 
static int countSubString(char[] s, char c, int k) 
{ 
  
    // Left and right counters for characters on 
    // both sides of sub-string window 
    int leftCount = 0, rightCount = 0; 
  
    // Left and right pointer on both 
    // sides of sub-string window 
    int left = 0, right = 0; 
  
    // Initialize the frequency 
    int freq = 0; 
  
    // Result and length of string 
    int result = 0, len = s.length; 
  
    // Initialize the left pointer 
    while (s[left] != c && left < len)  
    { 
        left++; 
        leftCount++; 
    } 
  
    // Initialize the right pointer 
    right = left + 1; 
    while (freq != (k - 1) && (right - 1) < len)  
    { 
        if (s[right] == c) 
            freq++; 
        right++; 
    } 
  
    // Traverse all the window sub-strings 
    while (left < len && (right - 1) < len) 
    { 
  
        // Counting the characters on left side 
        // of the sub-string window 
        while (s[left] != c && left < len) 
        { 
            left++; 
            leftCount++; 
        } 
  
        // Counting the characters on right side 
        // of the sub-string window 
        while (right < len && s[right] != c) 
        { 
            if (s[right] == c) 
                freq++; 
            right++; 
            rightCount++; 
        } 
  
        // Add the possible sub-strings 
        // on both sides to result 
        result = result + (leftCount + 1) * (rightCount + 1); 
  
        // Setting the frequency for next 
        // sub-string window 
        freq = k - 1; 
  
        // Reset the left and right counters 
        leftCount = 0; 
        rightCount = 0; 
  
        left++; 
        right++; 
    } 
    return result; 
} 
  
// Driver code 
public static void main(String[] args) 
{ 
    String s = "abada"; 
    char c = 'a'; 
    int k = 2; 
  
    System.out.println(countSubString(s.toCharArray(), c, k)); 
} 
} 