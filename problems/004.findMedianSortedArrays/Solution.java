class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        char[] array = s.toCharArray();
        Map<Character,Integer> map = new HashMap();
        Set set = new HashSet();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                j=i;
                break;
            }
            map.put(array[i],i);
        }
        for(;j<array.length;j++){
            set.add(array[j]);
        }
        return set.size();
    }
