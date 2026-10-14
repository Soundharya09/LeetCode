class BusBooking {
    private Map<String, Integer> booked;
    private int total;
    
    public BusBooking(int n) {
        booked = new HashMap<>();
        total = 0;
    }
    
    public void toggle(String seat) {
        if(booked.containsKey(seat)) {
            total -= booked.remove(seat);
            return;
        }
        char c = seat.charAt(0);
        String row = seat.substring(1);
        int cost = 1;
        if(c == 'A' && booked.containsKey('B' + row)) cost = 3;
        else if(c == 'D' && booked.containsKey('C' + row)) cost = 3;
        booked.put(seat, cost);
        total += cost;
    }
    
    public int getTotalTime() {
        return total;
    }
    
    public int getMinTime() {
        return booked.size();
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */