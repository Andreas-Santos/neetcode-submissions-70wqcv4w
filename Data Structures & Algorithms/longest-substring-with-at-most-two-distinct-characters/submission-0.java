class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3) return s.length();
        
        Map<Character, Integer> map = new HashMap<>();

        int longest = 0;

        int left = 0;
        for(int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            
            while(map.size() > 2) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }

                left++;
            }


            longest = Math.max(longest, r - left + 1);
        }

        return longest;
    }
}