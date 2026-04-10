class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> resultIntervals = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            
            if(i == intervals.length - 1) {
                resultIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
                break;
            }

            int[] interval1 = intervals[i];
            int[] interval2 = intervals[i + 1];

            if(interval1[1] >= interval2[0]) {
                int start = Math.min(interval1[0], interval2[0]);
                int end = Math.max(interval1[1], interval2[1]);

                intervals[i + 1] = new int[]{start, end};
            }
            else {
                resultIntervals.add(interval1);
            }
        }

        int[][] resultList = new int[resultIntervals.size()][2];

        for(int i = 0; i < resultIntervals.size(); i++) {
            resultList[i] = resultIntervals.get(i);
        }

        return resultList;
    }
}
