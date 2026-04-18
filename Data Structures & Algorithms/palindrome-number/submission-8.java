class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || x == Integer.MAX_VALUE) return false;

        StringBuilder build = new StringBuilder(String.valueOf(x));
        String reversedString = build.reverse().toString();

        if(Integer.parseInt(reversedString) == x) {
            return true;
        }

        return false;
    }
}