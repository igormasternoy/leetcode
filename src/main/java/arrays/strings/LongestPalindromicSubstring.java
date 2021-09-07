package arrays.strings;

import java.util.Arrays;

/**
 * Expand around center
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String input = "bb"; //args[0]
        int start = 0;
        int end = 0;



        for (int i = 0; i < input.length(); i++) {
            int len1 = expandAroundCenter(input, i, i);
            int len2 = expandAroundCenter(input, i, i+1);

            int len = Math.max(len1, len2);

            if(len > end - start ){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        System.out.println(input.substring(start, end+1));
    }

        public static int expandAroundCenter(String s, int start, int end){
            if (s.equals("") || start > end ) return 0;

            while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            }
            return end - start - 1;
        }


}
