public class minSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int slow=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum >=target){
                result=Math.min(result,i-slow+1);
                sum-=nums[slow++];
            }
        }
        return result==Integer.MAX_VALUE ?0:result;
    }
}
