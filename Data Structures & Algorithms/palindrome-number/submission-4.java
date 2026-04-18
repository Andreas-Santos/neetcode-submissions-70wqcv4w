class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int end = s.length() - 1;
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(end)) {
                return false;
            }
            
            end--;
        }

        return true;
    }
}