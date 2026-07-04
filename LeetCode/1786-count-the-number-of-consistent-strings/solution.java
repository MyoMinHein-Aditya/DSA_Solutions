class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        int consistentWordCount = 0;

        for (String word : words) {
            boolean isConsistent = true;

            for (int position = 0; position < word.length(); position++) {
                if (!set.contains(word.charAt(position))) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                consistentWordCount++;
            }
        }

        return consistentWordCount;
    }
}

