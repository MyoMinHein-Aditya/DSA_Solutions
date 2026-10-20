class Solution {

    private Map<Integer, Integer> mapping;
    private Random random;
    private int validRange;

    public Solution(int n, int[] blacklist) {
        this.mapping = new HashMap<>();
        this.random = new Random();
        this.validRange = n - blacklist.length;

        Set<Integer> blacklistSet = new HashSet<>();
        for (int b : blacklist) {
            blacklistSet.add(b);
        }

        int last = n - 1;
        for (int b : blacklist) {
            if (b < validRange) {
                while (blacklistSet.contains(last)) {
                    last--;
                }
                mapping.put(b, last);
                last--;
            }
        }
    }

    public int pick() {
        int picked = random.nextInt(validRange);
        return mapping.getOrDefault(picked, picked);
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */