class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            prereqMap.get(prereq[0]).add(prereq[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, prereqMap, visited, cycle, list)) return new int[0];
        }

        int[] result = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> map, 
        Set<Integer> visited, Set<Integer> cycle, List<Integer> list) {

        if(visited.contains(course)) return true;

        if(cycle.contains(course)) return false;

        cycle.add(course);
        for(int c : map.get(course)) {
            if(!dfs(c, map, visited, cycle, list)) return false;
        }

        cycle.remove(course);
        visited.add(course);
        list.add(course);

        return true;
    }
}
