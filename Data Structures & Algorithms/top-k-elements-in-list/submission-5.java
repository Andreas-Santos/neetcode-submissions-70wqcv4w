class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0) return new int[0];

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(list, (a, b) -> b[1] - a[1]);

        int[] topK = new int[k];

        int i = 0;
        while(i < k) {
            topK[i] = list.get(i)[0];
            
            i++;
        }

        return topK;
    }
}
