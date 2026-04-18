class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;

        int absX = Math.abs(x);

        StringBuilder builder = new StringBuilder(String.valueOf(absX));
        String reversedString = builder.reverse().toString();

        long reversedX = Long.parseLong(reversedString);

        if(x < 0) {
            reversedX = reversedX * -1;
        }

        if(reversedX < Integer.MIN_VALUE || reversedX > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) reversedX;
    }
}
