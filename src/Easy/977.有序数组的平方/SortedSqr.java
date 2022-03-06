public class SortedSqr {
    public int[] sortedSquares(int[] nums) {
        int left =0;
        int right=nums.length-1;

        int[] nub=new int [right+1];
        int k=nub.length-1;
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                nub[k--]=nums[left] * nums[left];
                ++left;
            }
            else{
                nub[k--]=nums[right]*nums[right];
                --right;
            }
        }
        return nub;
    }
}
