public class Dec16 {

    public static void main(String[] args) {
        // String test = "0-1";
        // String test1 = "1337c0d3";
        // String test2 = "-042";
        // String test3 = "42";
        // String test4 = " -042";
        String test5 = "2147483648";
        System.out.println(myAtoi(test5));

    }

    // soluntion:1
    // public static int myAtoi(String s) {
    // String result = "";
    // int i = 0;
    // int begin = 0;
    // while (i < s.length()) {
    // if (begin == 0) {
    // if (s.charAt(begin) == ' ') {
    // i++;
    // }
    // begin++;
    // } else if (begin == 1 && (s.charAt(0) == ' ' || s.charAt(0) == '-' ||
    // s.charAt(0) == '+')) {

    // if ((s.charAt(begin) == '-' || s.charAt(0) == '-')) {
    // result = result + '-';
    // i++;
    // } else if (s.charAt(begin) == '+' || s.charAt(0) == '+') {
    // i++;
    // }
    // begin++;
    // } else if (i > -1 && ((s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'z' <= 25)
    // || (s.charAt(i) - 'A' >= 0 && s.charAt(i) - 'Z' <= 25))
    // || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '.') {
    // break;
    // } else if (i > -1 && (s.charAt(i) == '0' || s.charAt(i) == ' ')) {
    // i++;
    // } else {
    // result = result + s.charAt(i);
    // i++;
    // }

    // }
    // if (result.length() == 0)
    // result = result + "0";
    // return Integer.valueOf(result);
    // }
    public static int myAtoi(String input) {

        int sign = 1;
        int result = 0;
        int index = 0;
        while (index < input.length() && input.charAt(index) == ' ') {
            index++;
        }
        if (index < input.length() && input.charAt(index) == '+') {
            index++;
        } else if (index < input.length() && input.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        while (index < input.length() && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';
            if ((result > (Integer.MAX_VALUE / 10)) ||
                    ((result == Integer.MAX_VALUE / 10) && (digit > Integer.MAX_VALUE % 10))) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return result * sign;
    }
}
