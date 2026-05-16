class Solution {
    public int fib(int n) {
        int sum=0,a=0,b=1;
        for(int i=0; i<n;i++){
            sum=a+b;
            b=a;
            a=sum;
        }
        return a;
    }
}
