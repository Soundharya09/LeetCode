class Solution {
    public double[] convertTemperature(double celsius) {
        double k = 0;
        double f = 0;

        k = 273.15 + celsius;
        f = celsius * 1.80 + 32.00;

        double[] result = {k,f};
        return result;
        
    }
}