class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);

            map.put(charS, map.getOrDefault(charS, 0) + 1);
            map.put(charT, map.getOrDefault(charT, 0) - 1);
        }

        for(int value : map.values()) {
            if(value != 0) return false;
        }

        return true;
    }
}
