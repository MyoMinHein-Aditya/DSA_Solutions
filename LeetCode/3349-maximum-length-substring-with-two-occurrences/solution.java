class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;
        int n = s.length();
        for (int left = 0; left < n; left++) {
            int[] count = new int[26];
            for (int right = left; right < n; right++) {
                count[s.charAt(right) - 'a']++;
                boolean valid = true;
                for (int i = 0; i < 26; i++) {
                    if (count[i] > 2) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) break;
                int currentLength = right - left + 1;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            }
        }
        return maxLength;
    }
}

