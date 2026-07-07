class Solution {
    public long sumAndMultiply(int n) {
        long sum=0, x=0, rev=0;
        while(n!=0){
            long rem=n%10;
            if(rem!=0){
                x=x*10+rem;
                sum+=rem;
            }
            n/=10;
        }
        while(x!=0){
            long rem=x%10;
            rev=rev*10+rem;
            x/=10;
        }
        return sum*rev;
    }
}
