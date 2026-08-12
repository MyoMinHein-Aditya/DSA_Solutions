class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int origin = x;
        if(x < 0) return false;
        while(x != 0){
            int digit = x % 10;
            rev = rev * 10 + digit;
            x/=10;
        }
        if(rev == origin){
            return true;
        }
        else{
            return false;
        }
    }
}
