import java.util.*;

public class ProbSolv2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] words = new int[size];
		for(int i = 0; i < size; i++) {
			words[i] = sc.nextInt();
		}
		int winSize = sc.nextInt();
		avgSlidWin(words, winSize);
		sc.close();
	}
	private static void avgSlidWin(int[] nums, int winsize) {
		int[] avgs = new int[nums.length - winsize + 1];
		int count = 0;
		for(int i = 0; i <= nums.length - winsize; i++) {
			int avg = 0;
			for(int j = i; j < i + winsize; j++) {
				avg += nums[j];
			}
			if(avg % winsize != 0) {
				count++;
			}
			avgs[i] = (avg / winsize);
		}
		if(count != avgs.length) {
			for(int i : avgs) {
				System.out.println(i);
			}
		} else {
			System.out.println(-1);
		}
	}
}
