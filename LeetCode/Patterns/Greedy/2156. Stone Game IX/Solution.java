class Solution {

    public boolean can_win(int count0, int count1, int count2) {
        if (count1 == 0) return false;
        count1--;
        if (count0 % 2 == 0) {
            return count2 > count1;
        } else {
            return count1 > count2 + 2;
        }
    }

    public boolean stoneGameIX(int[] stones) {
        int[] countStones = new int[3];
        for (int s : stones) {
            countStones[s % 3]++;
        }
        return can_win(countStones[0], countStones[1], countStones[2]) ||
               can_win(countStones[0], countStones[2], countStones[1]);
    }
}
