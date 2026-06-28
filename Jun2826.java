public class Jun2826 {

    public static void main(String[] args) {
        String senate = "RRDDD";
        Jun2826 jun = new Jun2826();
        System.out.println("partyVictory-->" + jun.predictPartyVictory(senate));
    }

    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder(senate);
        int cnt = 0, i = 0;
        while (i < sb.length()) {
            char c = sb.charAt(i);
            if (c == 'R') {
                if (cnt < 0) {
                    sb.append('D');
                }
                cnt++;
            } else {
                if (cnt > 0) {
                    sb.append('R');
                }
                cnt--;
            }
            i++;
        }
        return cnt > 0 ? "Radiant" : "Dire";
    }

}
