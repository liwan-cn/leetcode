/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for (Interval inter : intervals) {
            if (newInterval == null || inter.end < newInterval.start)
                result.add(inter);
            else if (inter.start > newInterval.end){
                result.add(newInterval);
                result.add(inter);
                newInterval = null;
            }else {
                newInterval.start = Math.min(newInterval.start, inter.start);
                newInterval.end = Math.max(newInterval.end, inter.end);
            }
        }
        if(newInterval != null) result.add(newInterval);
        return result;
    }
}