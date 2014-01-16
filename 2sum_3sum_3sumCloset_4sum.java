Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Discuss



public class Solution {
    
    // can't use pointer method here becuase it ask for indexs. Arrays.sort has randomized the index
    public int[] twoSum_pointer(int[] numbers, int target) {
        Arrays.sort(numbers);
        int l = 0;
        int r = numbers.length - 1;
        int[] rst = new int[2];
        
        while( l < r){
            int sum = numbers[l] +  numbers[r];
            if( sum == target){
                rst[0] = l + 1;
                rst[1] = r + 1;
                break;
            }else if( sum < target){
                l++;
            }else{
                r--;
            }
        }
        return rst;
    }
    
    //Space O(n), time O(n)
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            hs.put(numbers[i], i+1);
        }       
        
        int[] a = new int[2];
        
        for(int i=0; i<numbers.length ; i++){
            if ( hs.containsKey( target - numbers[i] )){
                int index1 = i+1;
                int index2 = hs.get(target - numbers[i]);
                if (index1 == index2){
                    continue;
                }
                a[0] = index1;
                a[1] = index2;
                return a;
            }
        }
        return a;
    }
}


Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)


public class Solution {
    
    // Need to remember all situtations where there are duplicates
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i< num.length - 2; i++){
            if(i!= 0 && num[i] == num[i-1]){
                continue;  // to skip duplicate numbers; e.g [0,0,0,0]
            }
            
            int l = i + 1;
            int r = num.length - 1;
            while(l < r){
                int sum = num[l] + num[r] + num[i];
                if(sum == 0){
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[l]);
                    tmp.add(num[r]);
                    rst.add(tmp);
                    l++;
                    r--; 
                    while( l < r && num[l] == num[l-1]) {  // to skip duplicates
                        l++; 
                    }
                    while (l < r && num[r] ==num[r+1]) {  // to skip duplicates
                        r--;
                    }
                }else if (sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return rst;
    }
}

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

public class Solution {
    
    // O(n^(k-1))
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
         ArrayList<ArrayList<Integer>> rst = new  ArrayList<ArrayList<Integer>>();
         Arrays.sort(num);
         
         for(int i = 0; i < num.length -3; i++){
             if( i != 0 && num[i] == num[i-1]) {
                 continue;
             }
             
             for(int j = i+1; j < num.length -2; j++){
                 if(j!= i+1 && num[j] == num[j-1])
                    continue;
                 
                 int l = j+1;
                 int r = num.length -1;
                 while(l < r){
                     int sum = num[i] + num[j] + num[l] + num[r];
                     if(sum < target){
                         l++;
                     }else if(sum > target){
                         r--;
                     }else{
                         ArrayList<Integer> tmp = new  ArrayList<Integer>();
                         tmp.add(num[i]);
                         tmp.add(num[j]);
                         tmp.add(num[l]);
                         tmp.add(num[r]);
                         rst.add(tmp);
                         l++;
                         r--;
                         while(l<r && num[l] == num[l-1]) l++;
                         while(l<r && num[r] == num[r+1]) r--;
                     }
                 }
             }
         }
         
         return rst;
    }
}

iven an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num); // don't forget this!
        
        int closet = Integer.MAX_VALUE / 2;  // otherwise it will overflow for opeartion (closet-target)'
        for(int i = 0; i < num.length - 2; i++){
            int l = i+1;
            int r = num.length-1;
            while(l < r){
                int sum = num[i] + num[l] + num[r];
                if(sum == target)
                    return sum;
                else if(sum < target){
                    l++;
                }else{
                    r--;
                }
                closet = Math.abs(sum - target) < Math.abs(closet-target) ? sum : closet;
            }
        }
        return closet;
    }
}

