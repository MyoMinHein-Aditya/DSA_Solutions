class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        // long sum = finalSum;
        // ArrayList<Long> list = new ArrayList<>();
        // long current = 2;
        // while(sum > 0){
        //     if(sum <= current * 2){
        //         list.add(sum);
        //         break;
        //     }
        //     list.add(current);
        //     sum-=current;
        //     current+=2;
        // }
        // return list;

        // ArrayList<Long> list = new ArrayList<>();
        // if (finalSum % 2 != 0) {
        //     return list;
        // }
        // long sum = finalSum;
        // long current = 2;
        // while (sum > 0) {
        //     if (sum <= current * 2) {
        //         list.add(sum);
        //         break;
        //     }
        //     list.add(current);
        //     sum -= current;
        //     current += 2;
        // }
        // return list;

        List<Long> list = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return list;
        }
        long sum = finalSum;
        long current = 2;
        while (sum > 0) {
            if (sum <= current * 2) {
                list.add(sum);
                break;
            }
            list.add(current);
            sum -= current;
            current += 2;
        }
        return list;
    }
}
