class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0; 
        for(int i = 0; i < nums.length; i ++){
            rightSum = rightSum + nums[i];
        }

        int leftSum = 0;
        for(int i = 0; i<nums.length; i++){
            if(leftSum == rightSum - nums[i]){
                return i;
            }

            leftSum = leftSum + nums[i];
        rightSum = rightSum - nums[i];

        }
        return -1;
    }
}