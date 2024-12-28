public class Dec18 {

    public static void main(String[] args) {
        int num = 3749;
        System.out.println(intToRoman(num));

    }

    public static String intToRoman(int num) {
        if (num < 1 && num > 4000)
            return "";

        int thousands = num / 1000;
        int hundreds = (num % 1000) / 100;
        int tens = (num % 100) / 10;
        int ones = num % 10;

        String result = "";

        result += convert(thousands, "M", "", "");
        result += convert(hundreds, "C", "D", "M");
        result += convert(tens, "X", "L", "C");
        result += convert(ones, "I", "V", "X");

        return result;
    }

    private static String convert(int num, String one, String five, String ten) {
        String roman = "";
        if (num == 0)
            return roman;
        else if (num <= 3)
            for (int i = 0; i < num; i++)
                roman += one;
        else if (num == 4)
            roman = one + five;
        else if (num <= 8) {
            roman = five;
            for (int i = 0; i < num - 5; i++)
                roman += one;
        }
        // num == 9
        else
            roman = one + ten;
        return roman;
    }
}
