class Solution {
    public String reformatDate(String date) {
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String[] parts = date.split(" ");
        String day = parts[0].replaceAll("[^0-9]", "");
        String year = parts[2];
        int month = 0;
        for(int i = 0; i < months.length; i++) {
            if(months[i].equals(parts[1])) {
                month = i + 1;
                break;
            }
        }
        return String.format("%s-%02d-%02d", year, month, Integer.parseInt(day));
    }
}