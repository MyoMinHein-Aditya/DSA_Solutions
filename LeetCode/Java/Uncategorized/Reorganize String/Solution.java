class Solution {
    public String reorganizeString(String S) {
        int n = S.length();

        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[S.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        char prevChar = '#';

        for (int i = 0; i < n; i++) {
            int bestCharIndex = -1;
            int bestCount = -1;

            for (int j = 0; j < 26; j++) {
                char currentChar = (char)('a' + j);

                if (count[j] > bestCount && currentChar != prevChar && count[j] > 0) {
                    bestCount = count[j];
                    bestCharIndex = j;
                }
            }

            if (bestCharIndex == -1) {
                return "";
            }

            char chosenChar = (char)('a' + bestCharIndex);
            result.append(chosenChar);
            count[bestCharIndex]--;
            prevChar = chosenChar;
        }

        return result.toString();
    }
}
