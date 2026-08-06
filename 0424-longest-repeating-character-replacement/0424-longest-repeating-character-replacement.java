class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;

        int i =0;
        int j = 0;
        
        int maxChar = 0;

        int [] count = new int[26];

        while(j <s.length()){
            char c = s.charAt(j);

            count[c - 'A'] = count[c - 'A'] + 1;

            maxChar = Math.max(maxChar, count[c - 'A']);

            while((j-i+1) - maxChar > k){
                char d = s.charAt(i);
                count[d-'A'] = count[d-'A'] - 1;
                i = i+1;
            }
            max = Math.max(max, j-i+1);
            j = j +1;
        }
        return max;

    }

}