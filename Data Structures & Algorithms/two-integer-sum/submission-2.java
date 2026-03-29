class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sumIndex = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(target == nums[i] + nums[j]) {
                    if(i < j) {
                        sumIndex[0] = i;
                        sumIndex[1] = j;
                    }
                    else {
                        sumIndex[0] = j;
                        sumIndex[1] = i;
                    }

                }
            }
        }

        return sumIndex;
    }
}
