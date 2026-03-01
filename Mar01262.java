public class Mar01262 {

    public static void main(String[] args) {
        String[] strs = { "bat", "bag", "bank", "band" };
        Mar01262 mar = new Mar01262();
        System.out.println("longg---->" + mar.longestCommonPrefix(strs));
    }

    /**
     * Vertical Scanning Algorithm for Longest Common Prefix
     * 
     * Algorithm:
     * 1. Use first string as reference
     * 2. For each character position i (0 to length of first string):
     * a. Get char at position i from first string
     * b. Compare with char at position i in all other strings
     * c. If any string is too short OR char doesn't match -> return prefix so far
     * d. If all match -> continue to next position
     * 3. If we complete the loop, entire first string is the common prefix
     * 
     * Time: O(S) where S = sum of all characters (worst case scans all)
     * Space: O(1) extra space (we return a substring, not building new string)
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || first.charAt(i) != strs[j].charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

}
