class Solution {
    public int earliestAcq(int[][] logs, int n) {

        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            map.put(i, set);
        }

        for(int[] log : logs) {
            int time = log[0];
            int x = log[1];
            int y = log[2];

            Set<Integer> setX = map.get(x);
            Set<Integer> setY = map.get(y);

            if(setX == setY) continue;

            if(setX.size() < setY.size()) {
                Set<Integer> temp = setX;
                setX = setY;
                setY = temp;
            }

            for(int person : setY) {
                setX.add(person);
                map.put(person, setX);
            }

            if(setX.size() == n) {
                return time;
            }
        } 

        return -1;
    }
}
