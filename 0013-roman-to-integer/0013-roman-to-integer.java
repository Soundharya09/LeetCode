class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> roman = new HashMap<>();
        roman.put("M",1000);
        roman.put("CM",900);
        roman.put("D",500);
        roman.put("CD",400);
        roman.put("C",100);
        roman.put("XC",90);
        roman.put("L",50);
        roman.put("XL",40);
        roman.put("X",10);
        roman.put("IX",9);
        roman.put("V",5);
        roman.put("IV",4);
        roman.put("I",1);
        int num = 0;
        for(int i = 0; i <= s.length() - 1; i++) {
            if (i + 1 < s.length() && roman.get(s.substring(i, i + 1)) < roman.get(s.substring(i + 1, i + 2))) num -= roman.get(s.substring(i, i + 1));
            else num += roman.get(s.substring(i, i + 1)); 
        }
        return num;
    }
}