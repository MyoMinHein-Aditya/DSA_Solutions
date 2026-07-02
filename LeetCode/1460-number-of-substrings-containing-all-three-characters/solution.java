class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        Set<Character> set = new HashSet<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length();right++){
            char c = s.charAt(right);
            freq[c - 'a']++;
            set.add(c);

            while (set.size() == 3) {
                count += s.length() - right;
                char l_char = s.charAt(left);
                freq[l_char - 'a']--;
                if (freq[l_char - 'a'] == 0){
                    set.remove(l_char);
                }
                left++;
            }
        }
        return count;
    }
}

