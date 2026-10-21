class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int n = products.length;

        int lo = 0, hi = n - 1;
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            while (lo <= hi && (products[lo].length() <= i || products[lo].charAt(i) != c)) {
                lo++;
            }
            while (lo <= hi && (products[hi].length() <= i || products[hi].charAt(i) != c)) {
                hi--;
            }
            List<String> suggestions = new ArrayList<>();
            for (int j = lo; j <= Math.min(lo + 2, hi); j++) {
                suggestions.add(products[j]);
            }
            result.add(suggestions);
        }
        return result;
    }
}