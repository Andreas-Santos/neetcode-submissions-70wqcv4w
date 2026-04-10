class Solution {
    // total courses array 0 to numCourses-1
    private Map<Integer, List<Integer>> map = new HashMap<>();

    // set to store visiting courses
    private Set<Integer> set = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // coloca todos os cursos no map
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        // adicionando os pré requisitos para cada curso
        for(int[] prereq : prerequisites) {
            map.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) return false;
        }

        return true;
    }

    public boolean dfs(int course) {
        if(set.contains(course)) return false;

        if(map.get(course).isEmpty()) return true;

        set.add(course);

        for(int prereq : map.get(course)) {
            if(!dfs(prereq)) return false;
        }
        
        set.remove(course);

        map.put(course, new ArrayList<>());

        return true;
    }
}
