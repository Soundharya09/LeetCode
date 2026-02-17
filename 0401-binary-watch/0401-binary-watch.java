class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int hours = 0; hours < 12; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                if (Integer.bitCount(hours) + Integer.bitCount(minutes) == turnedOn) {
                    String time = hours + ":";
                    if (minutes < 10) time += "0";
                    time += minutes;
                    ans.add(time);
                }
            }
        }
        return ans;
    }
}