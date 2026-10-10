class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = "" + nums[i];
        }

        for (int i = 0; i < strNums.length - 1; i++) {
            for (int j = i + 1; j < strNums.length; j++) {
                if (isGreater(strNums[j], strNums[i])) {
                    String temp = strNums[i];
                    strNums[i] = strNums[j];
                    strNums[j] = temp;
                }
            }
        }

        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strNums.length; i++) {
            result.append(strNums[i]);
        }

        return result.toString();
    }

    private boolean isGreater(String a, String b) {
        String order1 = a + b;
        String order2 = b + a;

        int len = order1.length();
        for (int i = 0; i < len; i++) {
            char ch1 = order1.charAt(i);
            char ch2 = order2.charAt(i);
            if (ch1 > ch2) {
                return true;
            } else if (ch1 < ch2) {
                return false;
            }
        }
        return false;
    }
}
