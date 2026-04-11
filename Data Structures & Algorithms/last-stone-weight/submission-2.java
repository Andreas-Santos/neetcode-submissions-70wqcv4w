class Solution {
    public int lastStoneWeight(int[] stones) {
        int greater = 0;
        int secondGreater = 3;

        if(stones.length == 0) {
            return 0;
        }
        else if(stones.length == 1) {
            return stones[0];
        }

        while(secondGreater != 0) {
            Arrays.sort(stones);

            greater = stones[stones.length-1];
            secondGreater = stones[stones.length-2];

            if(secondGreater == 0 || greater == 0) {
                return greater;
            }

            if(greater == secondGreater) {
                stones[stones.length-1] = 0;
                stones[stones.length-2] = 0;
            }
            else {
                stones[stones.length-2] = 0;
                stones[stones.length-1] = greater - secondGreater;
            }
        }

        return greater;
    }
}
