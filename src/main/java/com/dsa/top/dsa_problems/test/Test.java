package com.dsa.top.dsa_problems.test;


/*
Find index of numbers whose sum is 9.
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1] (because nums[0] + nums[1] = 2 + 7 = 9)

[[0,1]]


Map={
2:0

}

[[1, 0]]
 */

/*

Given an array of intervals where intervals[i] = [start, end], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example Input: intervals = [[1,3],[8,10],[2,6],[15,18]]
Output: [[1,6],[8,10],[15,18]]
{
[1,3], [2,6], [8,10],[15,18]
}

[1,3], [2,6], [8,10],[15,18]
[1,6]
[8,10]
[15, 18]

[1,5]

//1 2 3  6 8 10 15 18
 */
import java.net.Inet4Address;
import java.util.*;

public class Test {

    public static List<List<Integer>> mergeIntervals(List<List<Integer>> input) {
        if (input == null || input.isEmpty()) return new ArrayList<>();

        // Step 1: Sort by start
        Collections.sort(input, (o1, o2) -> Integer.compare(o1.get(0), o2.get(0)));

        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>(input.get(0))); // copy first interval

        // Step 2: Iterate through intervals
        for (int i = 1; i < input.size(); i++) {
            List<Integer> curr = input.get(i);                  // e.g. [2,6]
            List<Integer> prev = output.get(output.size() - 1); // last added, e.g. [1,3]

            if (curr.get(0) <= prev.get(1)) {
                // Overlap → merge by updating the end
                prev.set(1, Math.max(prev.get(1), curr.get(1)));
            } else {
                // No overlap → add new interval
                output.add(new ArrayList<>(curr));
            }
        }

        return output;
    }

    public static List<List<Integer>> findComSum(int[] arr, int target){

        int n=arr.length;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(arr[0], 0);
        List<List<Integer>>result=new ArrayList<>();
        for(int i=1; i<n; i++){
            if(map.containsKey(target-arr[i])){
                List<Integer>newList=new ArrayList<>();
                newList.add(i);
                newList.add(map.get(target-arr[i]));
                result.add(newList);
            }else{
                map.put(arr[i], i);
            }

        }
        return result;


    }

    public static void main(String[] args) {
        //[1,3], [2,6], [8,10],[15,18]
       List<List<Integer>>merge=new ArrayList<>();
       merge.add(Arrays.asList(1,3));
        merge.add(Arrays.asList(2,6));
        merge.add(Arrays.asList(8,10));
        merge.add(Arrays.asList(15,18));
        System.out.println(mergeIntervals(merge));



    }
}
