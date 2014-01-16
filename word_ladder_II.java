/*
 *
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters. *
 * */



public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> solution = new ArrayList<ArrayList<String>>();
        
        if(dict == null || dict.size() == 0)
            return result;
        
        ArrayList<String> first = new ArrayList<String>();
        first.add(start);
        solution.add(first);
        dict.remove(start);
        
        while(! solution.isEmpty()){
            ArrayList<ArrayList<String>> next_level = new  ArrayList<ArrayList<String>>();
            HashSet<String> to_remove = new HashSet<String>();
             
            for(int i = 0; i< solution.size(); i++){
                ArrayList<String> path = solution.get(i);
                String current = path.get(path.size()-1);
 
                for(char c = 'a'; c <= 'z'; c++){
                    for(int j=0; j < current.length(); j++){
                        if(c == current.charAt(j))
                            continue;
                        String tmp = replace(current, j, c);
                        if( tmp.equals(end)){
                            path.add(end);
                            result.add(new ArrayList<String>(path));
                            path.remove(path.size() - 1);
                        }
                        if(dict.contains(tmp)){
                            path.add(tmp);
                            next_level.add(new ArrayList<String>(path));
                            path.remove(path.size()-1);
                            to_remove.add(tmp);
                        }
                    }
                }
            }
            if(!result.isEmpty()) {
                return result;
            }
            dict.removeAll(to_remove);
            solution = next_level;
        }
        return result;
    }
    
    private String replace(String s, int index, char c){
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
