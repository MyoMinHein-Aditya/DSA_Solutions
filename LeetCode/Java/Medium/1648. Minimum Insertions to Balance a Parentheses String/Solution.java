class Solution {
    public int minInsertions(String s) {
        int insert = 0;
        int oCount = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == '(') {
                oCount++;
                i++;
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    insert++;
                    i++;
                }
                if (oCount > 0) {
                    oCount--;
                } else {
                    insert++;
                }
            }
        }
        return insert + (oCount * 2);
    }
}
