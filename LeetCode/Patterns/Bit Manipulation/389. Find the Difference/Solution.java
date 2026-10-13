class Solution {
    public char findTheDifference(String s, String t) {
        StringBuilder sbS = new StringBuilder(s);
        StringBuilder sbT = new StringBuilder(t);
        
        char[] sArr = sbS.toString().toCharArray();
        char[] tArr = sbT.toString().toCharArray();
        
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) {
                return tArr[i];
            }
        }
        
        return tArr[tArr.length - 1];
    }
}