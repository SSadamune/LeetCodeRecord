'''
Created on 2020年9月25日

@author: zwieb
'''
from questions.three_sum.Solution import Solution

s = Solution()

input_list = [
    [-1, 0, 1, 2, -1, -4],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [-1, -1, -1, -1, 0, 1, 1, 1, 1],
    [1, 1, 1],
]

for input in input_list:
    print(s.threeSum(input))

