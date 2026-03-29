import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Mar2926 {

    public static void main(String[] args) {
        int[] nums = { 1, 4, 1, 2 };
        // String[] strs = { "bat", "bag", "bank", "band" };
        String[] strs = { "flower", "flow", "flight" };
        int[] nums1 = { 5, 5, 1, 1, 1, 5, 5 };
        int[] nums2 = { 1, 2, 3, 3 };
        int[] nums3 = { 3, 5, 6, 7 };
        int[] nums4 = { 1, 1, 2, 3, 4 };
        int[] nums5 = { 10, 9, 1, 1, 1, 2, 3, 1 };
        // int[] nums5 = { 1, 2, 3 };
        int[] nums6 = { 1, 0, 1, 2 };
        int val = 1;
        int[] nums7 = { 1, 2, 2, 3, 3, 3 };
        int k = 2;

        String s = "racecarr";
        String t = "carrace";
        String[] strsAna = { "act", "pots", "tops", "cat", "stop", "hat" };
        Mar2926 mar = new Mar2926();
        System.out.println("concatenate--->" + Arrays.toString(mar.getConcatenation(nums)));
        System.out.println("longestCommonPrefix-->" + mar.longestCommonPrefix(strs));
        System.out.println("majorityElement-->" + mar.majorityElement(nums1));
        System.out.println("duplicate elements-->" + mar.hasDuplicate(nums2));
        System.out.println("majorityElement refined-->" + mar.majorityElementTuned(nums1));
        System.out.println("isAnagram--->" + mar.isAnagram(s, t));
        System.out.println("twoSum--->" + Arrays.toString(mar.twoSum(nums3, 7)));
        System.out.println("groupAnagrams--->" + mar.groupAnagrams(strsAna));
        System.out.println("removeElement-->" + mar.removeElement(nums4, val));
        System.out.print("sortt--->");
        mar.sortt(nums5);
        System.out.print(Arrays.toString(nums5));
        mar.sortColors(nums6);
        System.out.print("counting sortt--->");
        System.out.println(Arrays.toString(nums6));
        System.out.println("topk--->" + Arrays.toString(mar.topKFrequent(nums7, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (Integer.compare(map.get(b), map.get(a))));
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        pq.addAll(map.keySet());

        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i] = pq.poll();
            i++;
        }
        return res;
    }

    public void sortColors(int[] nums) {
        int max = 2;
        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] out = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            out[--count[nums[i]]] = nums[i];
        }
        System.arraycopy(out, 0, nums, 0, nums.length);
    }

    public void sortt(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int pivot = medianOfThree(nums, low, (low + (high - low)) / 2, high);
        swap(nums, high, pivot);
        int p = parition(nums, low, high);
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    public int parition(int[] arr, int low, int high) {
        int i = low - 1;
        int temp = arr[high];
        for (int j = low; j < high; j++) {
            if (arr[j] <= temp) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public int medianOfThree(int[] arr, int low, int mid, int high) {
        if (arr[mid] > arr[low] && arr[mid] < arr[high])
            return mid;
        if (arr[low] > arr[mid] && arr[low] < arr[high])
            return low;
        return high;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }

        }
        return k;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            for (int i : count) {
                sb.append(count[i]);
            }
            map.computeIfAbsent(sb.toString(), v -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.get(compliment) != null) {
                return new int[] { map.get(compliment), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0 || chars[i] < 0)
                return false;
        }
        return true;
    }

    public int[] getConcatenation(int[] nums) {
        int[] result = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        int smallest = Integer.MAX_VALUE;
        String smallestStr = "";
        for (String str : strs) {
            if (str.length() < smallest) {
                smallestStr = str;
                smallest = str.length();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int min = smallest;
        for (int i = 0; i < strs.length; i++) {
            if (!smallestStr.equals(strs[i])) {
                int j = 1;
                while (j <= smallest && strs[i].substring(0, j).equals(smallestStr.substring(0, j))) {
                    j++;
                }
                min = Math.min(min, j - 1);
            }
        }
        for (int i = 0; i < min; i++) {
            stringBuilder.append(smallestStr.charAt(i));
        }
        return stringBuilder.toString();
    }

    public int majorityElement(int[] nums) {

        Map<Integer, Integer> ma = new HashMap<>();
        int MAJ = nums.length / 2;
        for (int i : nums) {
            ma.put(i, ma.getOrDefault(i, 0) + 1);
            if (ma.get(i) > MAJ)
                return i;
        }
        return 0;
    }

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dups = new HashSet<>();
        for (int i : nums) {
            if (!dups.add(i))
                return true;
        }
        return false;
    }

    public int majorityElementTuned(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }
            count += (i == candidate) ? 1 : -1;
        }
        return candidate;

    }

}
