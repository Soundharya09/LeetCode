class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();   
        boolean[] visitedRoutes = new boolean[routes.length];
        Set<Integer> visitedStops = new HashSet<>();
        if (!stopToRoutes.containsKey(source)) return -1;
        for (int routeIdx : stopToRoutes.get(source)) {
            if (!visitedRoutes[routeIdx]) {
                visitedRoutes[routeIdx] = true;
                queue.offer(routeIdx);
            }
        }
        visitedStops.add(source);
        int buses = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int routeIdx = queue.poll();
                for (int stop : routes[routeIdx]) {
                    if (stop == target) return buses; 
                    if (visitedStops.contains(stop)) continue;
                    visitedStops.add(stop);
                    for (int nextRoute : stopToRoutes.get(stop)) {
                        if (!visitedRoutes[nextRoute]) {
                            visitedRoutes[nextRoute] = true;
                            queue.offer(nextRoute);
                        }
                    }
                }
            }
            buses++; 
        }
        return -1;
    }
}