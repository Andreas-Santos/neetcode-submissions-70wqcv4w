class Solution {
    public int maxProduct(int[] nums) {
        
        int largestProduct = nums[0];
        int curMin = 1;
        int curMax = 1;

        for(int num : nums) {
            int temp = curMax * num;

            curMax = Math.max(Math.max(temp, num * curMin), num);
            curMin = Math.min(Math.min(temp, num * curMin), num);

            largestProduct = Math.max(largestProduct, curMax);
        }

        return largestProduct;
    }
}
