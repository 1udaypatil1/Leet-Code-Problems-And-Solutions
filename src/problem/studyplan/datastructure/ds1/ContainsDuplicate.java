package problem.studyplan.datastructure.ds1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {

    /**
     * Approach 1 using set data structure
     * @param nums input array
     * @return boolean
     */
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.size() != nums.length;
    }

    /** Approach 2 using Hash Map
     * @param nums input array
     * @return boolean
     */
    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        for(int key : nums){
            if(occurrence.containsKey(key)){
                occurrence.put(key, occurrence.get(key)+1);
                if(occurrence.get(key)>1){
                    return true;
                }
            }
            else{
                occurrence.put(key, 1);
            }
        }
        return false;
    }
}
