class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        // routes[i] -> bus route
        // routes[i] -> stop

        // source -> stop
        // target -> stop

        if(source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stops = new HashMap<>();

        for(int i = 0; i < routes.length; i++) {
            int[] bus = routes[i]; 

            for(int stop : bus) {
                if(!stops.containsKey(stop)) {
                    stops.put(stop, new ArrayList<>());
                }

                stops.get(stop).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        Set<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);

        int count = 0;
        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int stop = q.poll();

                if(stop == target) return count;

                for(int bus : stops.getOrDefault(stop, new ArrayList<>())) {

                    for(int route : routes[bus]) {

                        if(visitedStops.contains(route)) {
                            continue;
                        }

                        q.add(route);
                        visitedStops.add(route);
                    }

                }

            }

            count++;
        }


        return -1;
    }
}