// Every number of nums is unique
// The result list must not contain any duplicate subset

// How to solve it:
// Implement a List<List<Integer>> result, thats going to be the return list
// By default, even when nums is empty, the result list will have at least []
// So we can add this value already to the subsets
// then we can iterate each number of nums and add for each existing array in result list

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num : nums) {
            int size = result.size();
            for(int i = 0; i < size; i++) {
                List<Integer> tmp = new ArrayList<>(result.get(i));

                tmp.add(num);
                result.add(tmp);
            }
        }

        return result;
    }
}
