class Solution {
    public int minimumDeletions(String s) {
        Integer[][] memo = new Integer[s.length() + 1][2];
        return dfs(s, 0, 1, memo);
    }

    int dfs(String s, int i, int a, Integer[][] memo) {
        if (i == s.length()) {
            return 0;
        }
        if (memo[i][a] != null) {
            return memo[i][a];
        }
        int res = Integer.MAX_VALUE;
        char cur = s.charAt(i);
        if ((cur == 'a' && a == 1) || (cur == 'b' && a == 0)) {
            res = dfs(s, i + 1, a, memo);
        } else if (cur == 'b' && a == 1) {
            res = Math.min(dfs(s, i + 1, 0, memo), dfs(s, i + 1, a, memo) + 1);
        } else if (cur == 'a' && a == 0) {
            res = dfs(s, i + 1, 0, memo) + 1;
        }
        memo[i][a] = res;
        return res;
    }
}