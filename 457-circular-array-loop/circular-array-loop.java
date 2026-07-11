class Solution {
    public int calcNextIdx(int [] nums,int curr ){
        int next = curr;

        int seq = nums[curr];

        if (seq > 0) {
            next = (next + seq) % nums.length;
        } else {
            int mod = seq % nums.length;
            int forward = nums.length + mod;
            next = (curr + forward) % nums.length;
        }
        return next;
    }
    public boolean circularArrayLoop(int[] nums) {
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            }

            boolean isPos = nums[i] > 0;
            int slow = i;
            int fast = i;
            
            do {
                slow = calcNextIdx(nums, slow);


                fast = calcNextIdx(nums, fast);
                
                if (isPos) {
                    if (nums[fast] < 0) {
                        break;
                    }
                } else {
                    if (nums[fast] > 0) {
                        break;
                    }    
                }

                fast = calcNextIdx(nums, fast);
                if (isPos) {
                    if (nums[fast] < 0) {
                        break;
                    }
                } else {
                    if (nums[fast] > 0) {
                        break;
                    }    
                }

                if (slow == fast) {
                    if (slow != calcNextIdx(nums, slow)){
                        return true;
                    }
                    break;
                }
            } while (slow != fast);

            int curr = i;

            if (isPos) {
                while (nums[curr] > 0) {
                    int next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }
            } else {
                while(nums[curr] < 0) {
                    int next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }
            }
        }
        return false;
    }
}