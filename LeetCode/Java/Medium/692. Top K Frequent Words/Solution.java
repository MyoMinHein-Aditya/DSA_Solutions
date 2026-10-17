import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String topWord = null;
            int maxFreq = -1;
            for (String word : frequencyMap.keySet()) {
                int freq = frequencyMap.get(word);
                if (freq > maxFreq || (freq == maxFreq && word.compareTo(topWord) < 0)) {
                    maxFreq = freq;
                    topWord = word;
                }
            }
            result.add(topWord);
            frequencyMap.remove(topWord);
        }

        return result;
    }
}
