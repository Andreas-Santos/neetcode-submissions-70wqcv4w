class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hashS = new HashMap<>();
        Map<Character, Integer> hashT = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(!hashS.containsKey(s.charAt(i))) {
                hashS.put(s.charAt(i), 1);
            }
            else {
                hashS.computeIfPresent(s.charAt(i), (k, v) -> v + 1);
            }
        }

        for(int i = 0; i < t.length(); i++) {
            if(!hashT.containsKey(t.charAt(i))) {
                hashT.put(t.charAt(i), 1);
            }
            else {
                hashT.computeIfPresent(t.charAt(i), (k, v) -> v + 1);
            }
        }

        return hashS.equals(hashT);
    }
}
