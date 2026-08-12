class Solution:
    def getSecondLargest(self, arr):
        # code here
        largest = -1
        second_large = -1
        for num in arr:
            if num > largest:
                second_large = largest
                largest = num
            elif num > second_large and num != largest:
                second_large = num
        return second_large