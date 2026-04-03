class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[id] = true;
        queue.offer(id);
        int currentLevel = 0;
        while (!queue.isEmpty() && currentLevel < level) {
            int size = queue.size();        
            for (int i = 0; i < size; i++) {
                int person = queue.poll();
                for (int friend : friends[person]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }
            currentLevel++;
        }
        Map<String, Integer> freqMap = new HashMap<>();
        while (!queue.isEmpty()) {
            int person = queue.poll();
            for (String video : watchedVideos.get(person)) {
                freqMap.put(video, freqMap.getOrDefault(video, 0) + 1);
            }
        }
        List<String> result = new ArrayList<>(freqMap.keySet());
        result.sort((a, b) -> {
            int freqDiff = freqMap.get(a) - freqMap.get(b);
            return freqDiff != 0 ? freqDiff : a.compareTo(b);
        });
        return result;
    }
}