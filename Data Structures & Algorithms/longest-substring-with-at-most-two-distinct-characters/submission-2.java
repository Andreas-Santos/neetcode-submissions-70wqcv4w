class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3) return s.length();

        int longest = 0;

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        for(int right = 0; right < s.length(); right++) {

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1); 

            while(map.size() > 2) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }

                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}