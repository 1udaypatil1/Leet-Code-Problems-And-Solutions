package problem.studyplan.datastructure.ds1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {

    /**
     * In a first for loop we are creating hash map of element to indexes and in the next for loop we are getting other element in O(1) time.
     *
     * @param nums input array
     * @param target target element
     * @return solution containing two indexes
     */
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }
            else{
                List<Integer> sameElementIndexes = new ArrayList<>();
                sameElementIndexes.add(i);
                map.put(nums[i], sameElementIndexes);
            }
        }
        for(int key : map.keySet()){
            solution[0] = map.get(key).get(0);
            int otherNumber = target - key;
            if(key==otherNumber && map.get(key).size()>1){
                solution[1] = map.get(key).get(1);
                return solution;
            }
            if(map.containsKey(otherNumber)){
                solution[1] = map.get(otherNumber).get(0);
                return solution;
            }
        }
        return solution;
    }

}
