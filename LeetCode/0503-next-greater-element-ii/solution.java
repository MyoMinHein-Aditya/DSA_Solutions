class Solution {
public int[] nextGreaterElements(int[] nums) {
int n = nums.length;
int[] res = new int[n];

    for (int i = 0; i < n; i++) {
        res[i] = -1;
    }
    
    java.util.Stack<Integer> stack = new java.util.Stack<>();
    
    for (int i = 0; i < 2 * n; i++) {
        int num = nums[i % n];
        while (!stack.isEmpty() && nums[stack.peek()] < num) {
            res[stack.pop()] = num;
        }
        if (i < n) {
            stack.push(i % n);
        }
    }
    return res;
}
}
