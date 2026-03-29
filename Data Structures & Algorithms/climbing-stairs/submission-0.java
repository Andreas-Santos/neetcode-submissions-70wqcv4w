class Solution {
    public int climbStairs(int n) {

        if(n == 0) {
            return 0;
        }

        int previous = 0;
        int current = 1;

        for(int i = 0; i < n ; i++) {
            int next = current + previous;
            previous = current;
            current = next;
        }

        return current;
    }
}
