public class Jun13264 {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 3, 2, 2, 5, 1, 4 };
        Jun13264 jun = new Jun13264();
        System.out.println("max--->" + jun.maxTurbulenceSize(arr));
    }

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int res = 0, cnt = 0, sign = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                cnt = (sign == 0) ? cnt + 1 : 1;
                sign = 1;
            } else if (arr[i] < arr[i + 1]) {
                cnt = (sign == 1) ? cnt + 1 : 1;
                sign = 0;
            } else {
                cnt = 0;
                sign = -1;
            }
            res = Math.max(res, cnt);
        }
        return res + 1;
    }

}
