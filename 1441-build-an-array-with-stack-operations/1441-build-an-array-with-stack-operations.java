class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int targetIdx = 0;
        int curr = 1;
        while(targetIdx < target.length) {
            if(curr == target[targetIdx]) {
                res.add("Push");
                targetIdx++;
            }
            else {
                res.add("Push");
                res.add("Pop");
            }
            curr++;
        }
        return res;
    }
}