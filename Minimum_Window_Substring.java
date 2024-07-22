class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int[] m1 = new int[128];

        int c = t.length();

        int start = 0, end = 0, min_start=0, min_len=Integer.MAX_VALUE;

        for (char ch:t.toCharArray())
            m1[ch]++;

        while (end < s.length()){
            if (m1[s.charAt(end++)] -->0)
                c--;

            while (c==0){
                if (end - start<min_len){
                    min_start =start;
                    min_len = end-start;
                }
                if(m1[s.charAt(start++)]++ == 0)
                    c++;
            }
        }        
        return min_len == Integer.MAX_VALUE?"":s.substring(min_start, min_start + min_len);
    }
}

/* Approaching the Solution:
Let's break down the solution into steps:

Step 1: Character Frequency Count

First, we need to count the frequency of each character in the target string 't'.
We can use an array or a hash map for this. An array is usually faster if we know the character set is limited (e.g., only uppercase and lowercase English letters).
Step 2: Initialize the Sliding Window

We'll use two pointers: 'start' and 'end', both initially at the beginning of string 's'.
These pointers define our current window.
Step 3: Expand the Window

Move the 'end' pointer to the right, including more characters in our window.
As we include characters, we'll check if they're needed (part of string 't').
We'll keep track of how many characters we still need to find.
Step 4: Contract the Window
  Once we have all the required characters, we'll try to make our window smaller.
Move the 'start' pointer to the right, removing characters from the start of our window.
We'll stop contracting when removing the next character would make our window invalid (i.e., no longer containing all required characters).

  Step 5: Update the Result

Each time we have a valid window (containing all required characters), we check if it's the smallest we've seen so far.
If it is, we update our result to this new, smaller window.
Step 6: Repeat

We continue this process of expanding and contracting the window until we reach the end of string 's'.

  Detailed Algorithm:
Create a frequency map for characters in 't':

Use an integer array of size 128 (covering ASCII characters).
Iterate through 't', incrementing the count for each character.
Initialize variables:

'start' and 'end' pointers, both at 0.
'minStart' to store the starting index of the minimum window.
'minLength' to store the length of the minimum window, initially set to infinity.
'count' to keep track of how many unique characters from 't' we still need to find.
Sliding Window:

While 'end' is less than the length of 's':
a. Expand the window:

Consider the character at 'end'.
If it's a character we need (its count in our frequency map is > 0), decrement 'count'.
Decrement this character's count in our frequency map.
Move 'end' to the right.
b. Contract the window if possible:

While 'count' is 0 (meaning we have all required characters):
Update 'minStart' and 'minLength' if current window is smaller.
Consider the character at 'start'.
If it's a required character (its count in frequency map becomes > 0), increment 'count'.
Increment this character's count in our frequency map.
Move 'start' to the right.
Return the result:

If 'minLength' is still infinity, return an empty string.
Otherwise, return the substring of 's' from 'minStart' with length 'minLength'. */
