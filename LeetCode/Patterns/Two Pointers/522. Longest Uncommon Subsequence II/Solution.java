class Solution {
    public int findLUSlength(String[] strs) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : strs) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        
        Arrays.sort(strs, (a, b) -> Integer.compare(b.length(), a.length()));
        
        for (int i = 0; i < strs.length; i++) {
            if (freq.get(strs[i]) > 1) continue;
            boolean isSubsequence = false;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSub(strs[i], strs[j])) {
                    isSubsequence = true;
                    break;
                }
            }
            if (!isSubsequence) {
                return strs[i].length();
            }
        }
        
        return -1;
    }
    
    private boolean isSub(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) i++;
            j++;
        }
        return i == s1.length();
    }
}
