class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int maxTh = k * threshold;

        for(int i = 0; i < k; i++){
            sum = sum + arr[i];
        }

        int count = 0;
        if (sum >= maxTh){
            count ++;
        }

        for(int i = k; i<arr.length; i++){

            sum = sum + arr[i];
            sum = sum - arr[i-k];

            if (sum >= maxTh){
                count++;
            }
        }

        return count;
    }
}