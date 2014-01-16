Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.


public class Solution {

    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> rst = new ArrayList<String>();
        
        if(strs == null || strs.length == 0) {
            return rst;
        }
        
        HashMap<String, ArrayList<String>> hs = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++) {
            String sorted = sort(strs[i]);
            if( ! hs.containsKey(sorted)){
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(strs[i]);
                hs.put(sorted, tmp);
            }else{ 
                hs.get(sorted).add(strs[i]);
            }
        }
        
        for(String key: hs.keySet()){
            if(hs.get(key).size() > 1){
                rst.addAll(hs.get(key));
            }
        }
        
        return rst;
    }
    
    private String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);  // string can take a char sequence as init ??
    }
}
