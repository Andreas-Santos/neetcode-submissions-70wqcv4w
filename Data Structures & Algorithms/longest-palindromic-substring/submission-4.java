class Solution {
    public String longestPalindrome(String s) {
        
        int index = 0;
        int length = 0;

        for(int i = 0; i < s.length(); i++) {

            int l = i;
            int r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                
                if(length < r - l + 1) {
                    index = l;
                    length = r - l + 1;
                }

                l--;
                r++;

            }

            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                
                if(length < r - l + 1) {
                    index = l;
                    length = r - l + 1;
                }

                l--;
                r++;

            }
        }

        return s.substring(index, index + length);
    }
}
