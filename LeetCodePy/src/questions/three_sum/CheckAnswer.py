'''
Created on 2020年9月25日

@author: zwieb
'''
from questions.three_sum.Solution import Solution

s = Solution()

inputlist = [
    [-1, 0, 1, 2, -1, -4],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [-1, -1, -1, -1, 0, 1, 1, 1, 1],
    [1, 1, 1],
]

for input in inputlist:
    print(s.threeSum(input))

