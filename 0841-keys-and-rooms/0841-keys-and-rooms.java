class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int room = stack.pop();
            if (visited[room]) continue;
            visited[room] = true;
            for (int key : rooms.get(room)) {
                if (!visited[key]) stack.push(key);
            }
        }
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}