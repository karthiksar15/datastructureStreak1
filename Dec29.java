  public static void main(String[] args) {
        String ransomNote = "fihjjjjei";
        String magazine = "hjibagacbhadfaefdjaeaebgi";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] output = new int[26];
        int[] input = new int[26];
        int flag = 0;
        for (char c : ransomNote.toCharArray()) {
            output[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            input[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (output[i] > 0 && output[i] > input[i]) {
                flag = 1;
            }
        }
        if (flag == 1)
            return false;
        else
            return true;
    }

