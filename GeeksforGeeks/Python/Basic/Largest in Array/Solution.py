class Solution:
    def largest(self, arr):
        # code here
        biggest = 0
        for i in range(len(arr)):
            if(arr[i] > biggest):
                biggest = arr[i]
        return biggest
