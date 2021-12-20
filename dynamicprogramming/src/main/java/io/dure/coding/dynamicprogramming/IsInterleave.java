package io.dure.coding.dynamicprogramming;

public class IsInterleave {
    // O(mn) time | O(mn) space
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length() + s2.length() != s3.length()) {
//            return false;
//        }
//        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
//        dp[0][0] = true;
//        for (int i = 0; i < s1.length(); i++) {
//            dp[i+1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
//        }
//        for (int j = 0; j < s2.length(); j++) {
//            dp[0][j+1] = s2.charAt(j) == s3.charAt(j) && dp[0][j];
//        }
//
//        for (int i = 0; i < s1.length(); i++) {
//            for (int j = 0; j < s2.length(); j++) {
//                char ch1 = s1.charAt(i);
//                char ch2 = s2.charAt(j);
//                char ch3 = s3.charAt(i + j + 1);
//                dp[i+1][j+1] = (ch1 == ch3 && dp[i][j+1]) || (ch2 == ch3 && dp[i+1][j]);
//            }
//        }
//        return dp[s1.length()][s2.length()];
//    }

    // O(mn) time | O(min(m,n)) space
//    public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.length() + s2.length() != s3.length()) {
//            return false;
//        }
//        if (s1.length() < s2.length()) {
//            return isInterleave(s2, s1, s3);
//        }
//        boolean[][] dp = new boolean[2][s2.length() + 1];
//        dp[0][0] = true;
//
//        for (int j = 0; j < s2.length(); j++) {
//            dp[0][j+1] = s2.charAt(j) == s3.charAt(j) && dp[0][j];
//        }
//
//        for (int i = 0; i < s1.length(); i++) {
//            dp[(i+1)%2][0] = s1.charAt(i) == s3.charAt(i) && dp[i%2][0];
//            for (int j = 0; j < s2.length(); j++) {
//                char ch1 = s1.charAt(i);
//                char ch2 = s2.charAt(j);
//                char ch3 = s3.charAt(i + j + 1);
//                dp[(i+1)%2][j+1] = (ch1 == ch3 && dp[i%2][j+1]) || (ch2 == ch3 && dp[(i+1)%2][j]);
//            }
//        }
//        return dp[s1.length()%2][s2.length()];
//    }

    // O(mn) time | O(min(m,n)) space
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() < s2.length()) {
            return isInterleave(s2, s1, s3);
        }

        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;

        for (int j = 0; j < s2.length(); j++) {
            dp[j+1] = s2.charAt(j) == s3.charAt(j) && dp[j];
        }
        for (int i = 0; i < s1.length(); i++) {
            dp[0] = dp[0] && s1.charAt(i) == s3.charAt(i);
            for (int j = 0; j < s2.length(); j++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);
                dp[j+1] = (ch1 == ch3 && dp[j+1])|| (ch2 == ch3 && dp[j]);
            }
        }
        return dp[s2.length()];
    }
}
