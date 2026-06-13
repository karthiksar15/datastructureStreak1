public class Jun13262 {

    public static void main(String[] args) {
        // int[] bills = { 5, 10, 5, 5, 20 };
        int[] bills = { 5, 20, 10, 5 };
        Jun13262 jun = new Jun13262();
        System.out.println("lemonade--->" + jun.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int b : bills) {
            if (b == 5) {
                five++;
            } else if (b == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                five--;
                ten--;
            } else {
                five -= 3;
            }
            if (five < 0) {
                return false;
            }
        }
        return true;
    }

}
