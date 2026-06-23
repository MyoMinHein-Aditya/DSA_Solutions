class Solution {

    public void reverseee(int start, int end, char[] s){
        while(start <= end){

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        char[] str = s;
        reverseee(start,end,s);
    }
}
