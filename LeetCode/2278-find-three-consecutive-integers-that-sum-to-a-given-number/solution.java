class Solution {
    public long[] sumOfThree(long num) {
        // long ans = new long[2];
    //     if (num % 3 != 0) {
    //         return new long[0];
    //     }

    //     long term = (num % 3) ;
    //     return new long[] { term , term + 1, term + 2 };
    // }

        if(num % 3 == 0){
            long term = num / 3 - 1;
            return new long[] {term , term + 1, term + 2};
        }
        else{
            return new long[0];
        }
    }
}

