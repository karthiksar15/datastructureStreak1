public class Aug14267 {

    public static void main(String[] args) {
        int[] piles = { 1, 2, 3, 1 };
        Aug14267 aug = new Aug14267();
        System.out.println("stone game--->" + aug.stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // The Net Advantage. Net Advantage = (My Score) - (Opponent's Score)
        // dp[i][j] represents the max net advantage for the subarray from index i to j
        int[][] dp = new int[n][n];

        // 1. Base Case: Subarrays of length 1
        // If there is only one pile, the current player takes it,
        // gaining that exact advantage.
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // 2. Build up from subarrays of length 2 up to length n
        for (int len = 2; len <= n; len++) {
            int chk = n - len;
            // 3. Iterate through all possible starting points (left) for this length
            for (int left = 0; left <= n - len; left++) {

                // Calculate the corresponding end point (right)
                int right = left + len - 1;

                // 4. The Minimax Choice (Same as top-down!)
                // Take left pile minus opponent's best future advantage
                int pickLeft = piles[left] - dp[left + 1][right];

                // Take right pile minus opponent's best future advantage
                int pickRight = piles[right] - dp[left][right - 1];

                // Record the best choice for this interval
                dp[left][right] = Math.max(pickLeft, pickRight);
            }
        }

        // 5. The answer for the full array is stored at dp[0][n-1]
        // If the net advantage > 0, the first player wins.
        return dp[0][n - 1] > 0;

    }

}
