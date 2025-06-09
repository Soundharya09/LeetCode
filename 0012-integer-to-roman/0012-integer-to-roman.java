class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> roman = new HashMap<>();
        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String res = "";
        
        for(int value : values) {
            while(num >= value) {
                res += roman.get(value);
                num -= value;
            }
        }
        return res;
    }
}