class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        for(int i = 1; i < n; i++)
            for(int j = 1; j < m; j++)
                dp[i][j] = 1000000007;
        for(int i = 0; i < puddles.length; i++)
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        dp[0][0] = 1;
        for(int i = 1; i < m; i++){
            if(dp[0][i] == -1)
                break;
            dp[0][i] = 1;
        }
        for(int i = 1; i < n; i++){
            if(dp[i][0] == -1)
                break;
            dp[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(dp[i][j] != -1){
                    if(dp[i][j-1] == -1 && dp[i-1][j] == -1)
                        dp[i][j] = 0;
                    else if(dp[i][j-1] == -1)
                        dp[i][j] = dp[i-1][j];
                    else if(dp[i-1][j] == -1)
                        dp[i][j] = dp[i][j-1];
                    else
                        dp[i][j] = Math.min((dp[i-1][j] + dp[i][j-1]) % 1000000007, dp[i][j]);
                }
            }
        }
        return dp[n-1][m-1] % 1000000007;
    }
}