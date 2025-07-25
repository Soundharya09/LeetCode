class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'D') dire.add(i);
            else radiant.add(i);
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int indOfR = radiant.poll();
            int indOfD = dire.poll();

            if(indOfR < indOfD) radiant.add(indOfR + n);
            else dire.add(indOfD + n);
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";

    }
}