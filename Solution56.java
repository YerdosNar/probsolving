import java.util.*;

public class Solution56 {
	public static int[][] solution(int [][]intervals) {
		if(intervals.length == 1) {
			return intervals;
		}
		Arrays.sort(intervals, (i, j) -> Integer.compare(i[0], j[0]));
		List<int []> merged = new ArrayList<>();
		int []temp = intervals[0];
		merged.add(temp);
		for(int []interval:intervals) {
			if(temp[1] >= interval[0]) {
				temp[1] = interval[1] < temp[1] ? temp[1] : interval[1];
			} else {
				temp = interval;
				merged.add(temp);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
	static void print(int [][]intervals) {
		System.out.println(Arrays.deepToString(intervals));
	}
	public static void main(String []args) {
		int [][]intervals = {{20,21}, {1,3}, {2,6}, {8,10}, {15,18}, {16,17}};
		System.out.print("Given intervals : ");
		print(intervals);
		System.out.print("After merging   : ");
		int [][]merged = solution(intervals);
		print(merged);
	}
}
