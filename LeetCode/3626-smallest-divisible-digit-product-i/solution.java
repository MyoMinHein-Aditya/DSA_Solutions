class Solution {
    
    public boolean is_divisible(int num, int t){
        int product = 1, temp = num;
        while(temp > 0){
            product *= (temp % 10);
            temp/=10;
        }
        return product % t == 0;
    }
    
    public int smallestNumber(int n, int t) {
        int curr = n;
        while(true){
            if(is_divisible(curr,t)){
                return curr;
            }
            curr++;
        }
    }

}
