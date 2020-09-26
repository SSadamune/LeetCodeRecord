package solution.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * https://leetcode.com/problems/3sum/
 * 2020.09.24
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;

        for (int index1 = 0; index1 < n - 1; index1++) {
            if (index1 > 0 && nums[index1] == nums[index1 - 1]) continue;
            int target = -nums[index1], index2 = index1 + 1, index3 = n - 1;

            while (index2 < index3) {
                if (nums[index2] + nums[index3] < target || (index2 > index1 + 1 && nums[index2] == nums[index2 - 1])) {
                    index2++;
                    continue;
                }

                if (nums[index2] + nums[index3] > target || (index3 < n - 1 && nums[index3] == nums[index3 + 1])) {
                    index3--;
                    continue;
                }

                ans.add(List.of(-target, nums[index2], nums[index3]));
                index2++;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSumVer0(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        int index1 = 0;
        while (index1 < n - 1) {
            int index2 = index1 + 1;
            int index3 = n - 1;
            while (index2 < index3) {
                if (nums[index1] + nums[index2] + nums[index3] > 0) {
                    do index3--; while(nums[index3] == nums[index3 + 1] && index2 < index3);
                    continue;
                }
                if (nums[index1] + nums[index2] + nums[index3] < 0) {
                    do index2++; while(nums[index2] == nums[index2 - 1] && index2 < index3);
                    continue;
                }
                if (nums[index1] + nums[index2] + nums[index3] == 0) {
                    ans.add(List.of(nums[index1], nums[index2], nums[index3]));
                    do index2++; while(nums[index2] == nums[index2 - 1] && index2 < index3);
                    continue;
                }
            }
            do index1++; while(nums[index1] == nums[index1 - 1] && index1 < n - 1);
        }
        return ans;
    }



}
