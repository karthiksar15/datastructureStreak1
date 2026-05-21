public class May21262 {

    public static void main(String[] args) {
        int[] mountainArr = { 2, 4, 5, 6, 7, 2, 1 };
        int target = 2;
        May21262 may = new May21262();
        System.out.println("target found--->" + may.findInMountainArray(target, mountainArr));
    }

    public int findInMountainArray(int target, int[] mountainArr) {
        int l = 0, r = mountainArr.length - 1;
        int peek = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mountainArr[mid] >= mountainArr[l] && mountainArr[r] <= mountainArr[mid]) {
                l = mid + 1;
                peek = mid;
            } else if (mountainArr[mid] < mountainArr[l] && mountainArr[mid] > mountainArr[r]) {
                r = mid - 1;
            }
        }
        return peek;
    }

}

interface MountainArray {
    public int get(int index);

    public int length();
}
