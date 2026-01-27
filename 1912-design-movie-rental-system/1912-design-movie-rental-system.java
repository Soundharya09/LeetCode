class MovieRentingSystem {
    private Map<Integer, TreeSet<int[]>> unrentedByMovie;
    private TreeSet<int[]> rented;
    private Map<String, Integer> prices;

    public MovieRentingSystem(int n, int[][] entries) {
        unrentedByMovie = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        prices = new HashMap<>();
        for (int[] entry : entries) {
            int shop = entry[0];
            int movie = entry[1];
            int price = entry[2];
            unrentedByMovie.putIfAbsent(movie, new TreeSet<>((a, b) -> {
                if (a[2] != b[2]) return a[2] - b[2];
                return a[0] - b[0];
            }));
            unrentedByMovie.get(movie).add(new int[]{shop, movie, price});
            prices.put(shop + "," + movie, price);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!unrentedByMovie.containsKey(movie)) return result;        
        int count = 0;
        for (int[] entry : unrentedByMovie.get(movie)) {
            if (count >= 5) break;
            result.add(entry[0]);
            count++;
        }
        return result;
    }
    
    public void rent(int shop, int movie) {
        int price = prices.get(shop + "," + movie);
        unrentedByMovie.get(movie).remove(new int[]{shop, movie, price});
        rented.add(new int[]{shop, movie, price});
    }
    
    public void drop(int shop, int movie) {
         int price = prices.get(shop + "," + movie);
        rented.remove(new int[]{shop, movie, price});
        unrentedByMovie.get(movie).add(new int[]{shop, movie, price});
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int[] entry : rented) {
            if (count >= 5) break;
            result.add(Arrays.asList(entry[0], entry[1]));
            count++;
        }
        return result;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */