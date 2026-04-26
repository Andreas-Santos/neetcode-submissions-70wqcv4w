class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] res = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;
        int index = nums.length - 1;

        while(l <= r) {

            if(nums[r] * nums[r] > nums[l] * nums[l]) {
                res[index] = nums[r] * nums[r];
                r--;
            }
            else {
                res[index] = nums[l] * nums[l];
                l++;
            }

            index--;
        }

        return res;
    }
}