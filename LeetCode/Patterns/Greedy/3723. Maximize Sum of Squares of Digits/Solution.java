class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num || sum < 0) {
            return "";
        }
        
        char[] result = new char[num];
        int remainingSum = sum;
        
        for (int i = 0; i < num; i++) {
            int maxDigit = Math.min(9, remainingSum - (num - 1 - i) * 0);
            int minDigit = Math.max(0, remainingSum - (num - 1 - i) * 9);
            
            int bestDigit = -1;
            long maxScore = -1;
            
            for (int d = 9; d >= 0; d--) {
                if (d >= minDigit && d <= maxDigit) {
                    long currentScore = (long) d * d;
                    if (currentScore > maxScore) {
                        maxScore = currentScore;
                        bestDigit = d;
                    } else if (currentScore == maxScore) {
                        if (d > bestDigit) {
                            bestDigit = d;
                        }
                    }
                }
            }
            
            result[i] = (char) (bestDigit + '0');
            remainingSum -= bestDigit;
        }
        
        return new String(result);
    }
}
