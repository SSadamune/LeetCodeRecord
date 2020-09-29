'''
https://leetcode.com/problems/generate-parentheses/
Created on 2020.09.29
@author: zwieb
'''
class Solution:
    def generate_parenthesis(self, n):
        ans = []
        if n == 0: return ans
        self.dfs("", n, n, ans)
        return ans

    def dfs(self, current_str, left, right, ans):
        if left == 0 and right == 0: ans.append(current_str)
        if left > right: return
        if left > 0: self.dfs(current_str + '(', left - 1, right, ans)
        if right > 0: self.dfs(current_str + ')', left, right - 1, ans)
