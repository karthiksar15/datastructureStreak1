public class Jan2326 {

    public static void main(String[] args) {
        String[] strArrays = new String[] { "good", "dog", "did", "dee", "eat", "tomg" };// true
        String[] strArraysFalse = new String[] { "good", "dog", "did", "bee", "eat", "tomb" };// false
        Jan2326 jan = new Jan2326();
        System.out.println("can this form cycle--->" + jan.canThisFormCycle(strArraysFalse));
    }

    public boolean canThisFormCycle(String[] strArr) {
        int[] visited = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            visited[i] = 1;
            if (helper(strArr, visited, strArr[i], 1))
                return true;
        }
        return false;
    }

    public boolean helper(String[] strArr, int[] visited, String curr, int track) {
        boolean result = false;
        for (int i = 0; i < strArr.length; i++) {
            char currChar = curr.charAt(curr.length() - 1);
            char nextChar = strArr[i].charAt(0);
            if (currChar == nextChar && track == strArr.length - 1)
                return true;
            if (visited[i] == 0 && currChar == nextChar) {
                visited[i] = 1;
                result = helper(strArr, visited, strArr[i], track + 1);
            }
        }
        return result;
    }

}
