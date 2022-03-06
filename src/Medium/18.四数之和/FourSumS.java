import java.util.Arrays;
import java.util.List;

public class FourSumS {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = (List<List<Integer>>) new ArrayList<>();
        Arrays.sort(nums);

        for(int i =0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int k =i+ 1;k<nums.length;k++){
                if(k>i+1&&nums[k]==nums[k-1]){
                    continue;
                }
                int left = k+1;
                int right=nums.length-1;
                while(right>left){
                    int sum = nums[i]+nums[k]+nums[left]+nums[right];
                    if(sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }
                    else{
                        result.add(Arrays.asList(nums[i],nums[k],nums[left],nums[right]));
                        while(right>left&&nums[right]==nums[right-1]) right--;
                        while(right>left&&nums[left]==nums[left+1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
