class Solution {

    public int fiboo(int n){
        if(n==1 || n==0) return n;
        return fiboo(n-1)+fiboo(n-2);
    }

    public int fib(int n) {
        return fiboo(n);
    }
}