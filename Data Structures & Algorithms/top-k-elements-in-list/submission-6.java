class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<int[]> frequencyList = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            frequencyList.add(new int[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(frequencyList, (a, b) -> b[1] - a[1]);

        int[] topKFrequentElements = new int[k];

        int i = 0;
        while(i < k) {
            topKFrequentElements[i] = frequencyList.get(i)[0];

            i++;
        }

        return topKFrequentElements;
    }
}
