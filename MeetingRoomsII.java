// Time Complexity: O(nlogn) where n is the number of intervals
// Space Complexity: O(n) where n is the number of intervals.

import java.util.Arrays;
import java.util.PriorityQueue;

class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int count = 0;

        if(intervals == null || intervals.length == 0){
            return count;
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1]-b[1]));

        pq.offer(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] prevInterval = pq.peek();
            int[] currInterval = intervals[i];

            if(prevInterval[1] > currInterval[0]){
                pq.offer(currInterval);
            }else{
                pq.poll();
                pq.offer(currInterval);
            }
        }

        return pq.size();


    }
}
