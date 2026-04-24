class Solution {
    public int countSubstrings(String s) {
        
        int count = 0;

        for(int i = 0; i < s.length(); i++) {

            int l = i;
            int r = i;
            count += helper(s, l, r);

            count += helper(s, l, r + 1);
        }

        return count;
    }

    public int helper(String s, int l, int r) {

        int count = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }

        return count;
    }
}
