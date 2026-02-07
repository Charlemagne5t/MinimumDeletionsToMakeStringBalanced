class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int res = n;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                a++;
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.min(res, a + b);
            if (s.charAt(i) == 'a') {
                a--;
            } else b++;
        }
        res = Math.min(res, a + b);
        return res;
    }
}