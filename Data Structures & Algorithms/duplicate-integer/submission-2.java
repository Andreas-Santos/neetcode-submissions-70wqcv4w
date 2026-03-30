class Solution {
    public boolean hasDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; i < nums.length; j++) {
                if(j == nums.length) {
                    break;
                }

                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}