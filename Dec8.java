public class Dec8 {

    /**
     * Main method to demonstrate the checkIfPangram method.
     * <p>
     * The main method creates a sample pangram and prints the result of the
     * checkIfPangram method to the console.
     * </p>
     * 
     * @param args
     *             Ignored command line arguments.
     */
    public static void main(String[] args) {

        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));

    }

    public static boolean checkIfPangram(String sentence) {

        int[] arr = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            arr[sentence.charAt(i) - 'a'] = 1;
        }
        for (int i = 0; i < arr.length; i++) { // 26
            if (arr[i] != 1)
                return false;
        }
        return true;

    }

}
