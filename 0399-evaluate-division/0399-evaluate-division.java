class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];
            
            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / val);
        }
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
                continue;
            }
            
            if (start.equals(end)) {
                results[i] = 1.0;
                continue;
            }
            
            Queue<String> queue = new LinkedList<>();
            Map<String, Double> visited = new HashMap<>();
            
            queue.offer(start);
            visited.put(start, 1.0);
            
            boolean found = false;
            while (!queue.isEmpty()) {
                String node = queue.poll();
                double currVal = visited.get(node);
                
                if (node.equals(end)) {
                    results[i] = currVal;
                    found = true;
                    break;
                }
                
                for (Map.Entry<String, Double> neighbor : graph.get(node).entrySet()) {
                    String nextNode = neighbor.getKey();
                    double edgeVal = neighbor.getValue();
                    
                    if (!visited.containsKey(nextNode)) {
                        visited.put(nextNode, currVal * edgeVal);
                        queue.offer(nextNode);
                    }
                }
            }
            
            if (!found) results[i] = -1.0;
        }
        
        return results;
    }
}