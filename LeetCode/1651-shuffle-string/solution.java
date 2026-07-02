class Solution {
    public String restoreString(String s, int[] indices) {
        char []chars = s.toCharArray();
        for(int i = 0 ; i < s.length(); i++){
            chars[indices[i]] = s.charAt(i);
        }
        String str = new String(chars);
        return str;
    }
}
