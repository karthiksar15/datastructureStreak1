class Nov1426 {

    public static void main(String[] args) {
        String senate = "RRDDD";
        Nov1426 nov = new Nov1426();
        System.out.println("predict-->" + nov.predictPartyVictory(senate));
    }

    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder(senate);
        int cnt = 0, i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == 'R') {
                if (cnt < 0)
                    sb.append('D');
                cnt++;
            } else {
                if (cnt > 0)
                    sb.append('R');
                cnt--;
            }
            i++;
        }
        return cnt > 0 ? "Radiant" : "Dire";
    }

}