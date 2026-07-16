class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int duplicate = 0;

        for(int i = 0; i<k; i++){
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }

            map.put(nums[i], map.get(nums[i]) + 1);

            sum = sum + nums[i];

            if(map.get(nums[i]) > 1) {
                duplicate = duplicate + 1;
            }
        }

        if(duplicate == 0) {
            max = Math.max(max, sum);
        }

        for(int i = k; i<nums.length; i=i+1) {
            int numToAdd = nums[i];
            int numToRemove = nums[i-k];

            if(!map.containsKey(numToAdd)) {
                map.put(numToAdd, 0);
            }

            map.put(numToAdd, map.get(numToAdd) + 1);

            if(map.get(numToAdd) > 1) {
                duplicate = duplicate + 1;
            }

            sum = sum + numToAdd;

            if(map.get(numToRemove) > 1) {
                duplicate = duplicate - 1;
            }

            map.put(numToRemove, map.get(numToRemove) - 1);

            sum = sum - numToRemove;

            if(duplicate == 0){
                max = Math.max(sum, max);
            }
        }

        return max;
    }
}