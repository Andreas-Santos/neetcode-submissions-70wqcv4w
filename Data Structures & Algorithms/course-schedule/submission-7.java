class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] prereq : prerequisites) {

            if(!map.containsKey(prereq[0])) {
                map.put(prereq[0], new ArrayList<>());
            }

            map.get(prereq[0]).add(prereq[1]);
        }

        Set<Integer> currentCycle = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {

            if(!dfs(i, map, currentCycle)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> cycle) {

        if(!map.containsKey(i)) {
            return true;
        }

        if(cycle.contains(i)) {
            return false;
        }   

        cycle.add(i);

        for(int prereq : map.get(i)) {
            if(!dfs(prereq, map, cycle)) {
                return false;
            }
        }

        cycle.remove(i);
        map.remove(i);
        
        return true;
    }
}
