public class May2426 {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 2, 1 };
        int target = 2;
        May2426 may = new May2426();
        System.out.println("mountainArray--->" + may.findInMountainArray(target, arr));
    }

    public int findInMountainArray(int target, int[] mountainArr) {
        int l = 0;
        int r = mountainArr.length - 1;
        int peakPoint = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mountainArr[l] < mountainArr[mid] && mountainArr[mid] > mountainArr[r]) {
                peakPoint = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = 0;
        r = peakPoint;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mountainArr[mid] < target) {
                l = mid + 1;
            } else if (mountainArr[mid] > target) {
                r = mid - 1;
            } else {
                peakPoint = mid;
                break;
            }
        }
        return peakPoint;

    }

}
