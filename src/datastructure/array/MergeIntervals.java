package datastructure.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/merge-intervals/
 *Similar Activity Selection Problem
 */
public class MergeIntervals {
	
	public static List<Interval> merge(List<Interval> intervals) {
		if(intervals.isEmpty()) {
			return null;
		}
		Comparator<Interval> intervalComparator = (Interval o1, Interval o2)->o1.start - o2.start;
		Collections.sort(intervals, intervalComparator);
		List<Interval> result = new ArrayList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) 
	            end = Math.max(end, interval.end);
	        else {                   
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
    }
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		int[][] intervalArr = {{1,3},{2,6},{8,10},{15,18}};
		for(int i=0; i<intervalArr.length;i++) {
			Interval interval = new Interval();
			interval.start = intervalArr[i][0];
			interval.end = intervalArr[i][1];
			intervals.add(interval);
		}
		merge(intervals).stream().forEach(o->{System.out.println("Start: "+o.start+" End: "+o.end);});
	}

}
