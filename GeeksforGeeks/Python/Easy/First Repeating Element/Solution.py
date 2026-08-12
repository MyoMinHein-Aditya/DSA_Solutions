class Solution:
    def firstRepeated(self, arr):
        frequency = {}
        for num in arr:
            frequency[num] = frequency.get(num, 0) + 1
        for i, num in enumerate(arr):
            if frequency[num] > 1:
                return i + 1
        return -1
