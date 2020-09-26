'''
https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
Created on 2020年4月8日
@author: zwieb
'''
class Solution:
    def movingCount(self, m: int, n: int, k: int) -> int:
        count = 0
        for i in range(min(m, max(0, (k - 8)) * 10 + 10)):
            for j in range(min(n, max(0,(k - 8 - i//10)) * 10 + 10)):
                if i // 10 + i % 10 + j // 10 + j % 10 <= k : count += 1
        return count

