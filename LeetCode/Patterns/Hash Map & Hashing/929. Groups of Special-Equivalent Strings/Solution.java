class Solution {
    public int numSpecialEquivGroups(String[] words) {
        if (words.length == 1) return 1;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(findAlphabet(words[i]));
        }
        return set.size();
    }

    private static String findAlphabet(String word) {
        byte[][] alph = new byte[2][26];
        for (int i = 0; i < word.length(); i+=2) {
            alph[0][word.charAt(i) - 'a']++;
        }
        for (int i = 1; i < word.length(); i+=2) {
            alph[1][word.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append(alph[0][i]);
            sb.append(alph[1][i]);
        }
        return sb.toString();
    }
}