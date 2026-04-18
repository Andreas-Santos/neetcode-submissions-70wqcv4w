class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;

        int absX = Math.abs(x);

        StringBuilder sb = new StringBuilder(String.valueOf(absX));
        String reversedSt = sb.reverse().toString();
        long reversedX = Long.parseLong(reversedSt);

        if(x < 0) {
            reversedX *= -1;
        }

        if(reversedX < -(1 << 31) || reversedX > (1 << 31) - 1) {
            return 0;
        }

        return (int) reversedX;
    }
}
