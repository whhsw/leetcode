Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1){
            return intervals;
        }
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());  // remember how to write a collector
        
        Interval a = intervals.get(0);
        for(int i=1; i<intervals.size(); i++) {
            Interval b = intervals.get(i);
            if( b.start <= a.end ){
                a.end = Math.max(a.end, b.end);
            }else{
                result.add(a);
                a = b;
            }
        }
        result.add(a);
        return result;
            
    }
    
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
