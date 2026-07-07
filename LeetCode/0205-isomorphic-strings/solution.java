class Solution {
    public boolean isIsomorphic(String s, String t) {
        int []freq_s = new int[128];
        int []freq_t = new int[128];
        for(int i = 0; i < s.length(); i++){
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);
            if(freq_s[ch_s] != freq_t[ch_t]) return false;
            freq_s[ch_s] = i + 1;
            freq_t[ch_t] = i + 1;
        }
        return true;
    }
}
