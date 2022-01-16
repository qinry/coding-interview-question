package io.dure.coding.graph;

public class NumSimilarGroups {
    public int numSimilarGroups(String[] strs) {
        int[] fathers = new int[strs.length];

        for (int i = 0; i < fathers.length; i++) {
            fathers[i] = i;
        }
        int group = strs.length;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i+1; j < strs.length; j++) {
                if (similar(strs[i], strs[j]) && union(fathers, i, j)) {
                    group--;
                }
            }
        }
        return group;
    }

    private boolean similar(String str1, String str2) {
        int difference = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                difference++;
            }
        }
        return difference <= 2;
    }

    private boolean union(int[] fathers, int i, int j) {
        int fatherOfI = findFather(fathers, i);
        int fatherOfJ = findFather(fathers, j);

        if (fatherOfI != fatherOfJ) {
            fathers[fatherOfI] = fatherOfJ;
            return true;
        }
        return false;
    }

    private int findFather(int[] fathers, int i) {
        if (fathers[i] != i) {
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }
}
