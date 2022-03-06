public class RemoveE {
    public int removeElement(int[] nums, int val) {
        int fastIndex = 0;
        int slowIndex = 0;
        for(slowIndex = 0;fastIndex < nums.length; fastIndex++){
            if(nums[fastIndex]!=val){
                nums[slowIndex]=nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
