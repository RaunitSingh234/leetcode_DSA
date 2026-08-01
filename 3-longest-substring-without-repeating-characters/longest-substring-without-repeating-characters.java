class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i = 0; i<s.length(); i++){
            Set<Character> set = new HashSet<>();
            int len = 0;

            for(int j = i; j<s.length(); j++){
                char curr = s.charAt(j);

                if(set.contains(curr)){
                    break;
                }
                set.add(curr);
                max = Math.max(max, j-i+1);
            }
        }
        return max;
    }
}