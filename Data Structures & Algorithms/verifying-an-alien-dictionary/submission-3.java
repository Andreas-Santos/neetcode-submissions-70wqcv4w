class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character, Integer> mapLetters = new HashMap<>();

        for(int i = 0; i < order.length(); i++) {
            mapLetters.put(order.charAt(i), i);
        }

        int L = 0;
        for(int R = 1; R < words.length; R++) {
            int charIndex = 0;

            while(charIndex < words[L].length() && charIndex < words[R].length() && words[L].charAt(charIndex) == words[R].charAt(charIndex)) {
                charIndex++;
            }

            if(charIndex >= words[R].length()) return false;

            if(charIndex < words[L].length() && mapLetters.get(words[R].charAt(charIndex)) < mapLetters.get(words[L].charAt(charIndex))) {
                return false;
            }
            
            L++;
        }


        return true;
    }
}