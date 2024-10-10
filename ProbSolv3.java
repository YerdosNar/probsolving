import java.util.*;

public class ProbSolv3 {
	public static void main(String... args) {
		var sc = new Scanner(System.in);
		int num = sc.nextInt();
		int need = sc.nextInt();
		var trees = new int[num];
		for(int i = 0; i < num; i++) {
			trees[i] = sc.nextInt();
		}
		System.out.println(bestHeight(trees, need));
		sc.close();
	}
	private static int bestHeight(int[] trees, int need) {
		int low = 0, high = trees[0];
		for(int i = 0; i < trees.length; i++) {
			if(high < trees[i]) {
				high = trees[i];
			}
		}
	
		int bestH = 0;
		while(low <= high) {
			int mid = (low + high) / 2;
			int wood = collected(trees, mid);
			if(wood < need) {
				high = mid - 1;
			} else {
				bestH = mid;
				low = mid + 1;
			}
		}
		return bestH;
	}
	private static int collected(int[] trees, int height) {
		int amount = 0;
		for(int i:trees) {
			if(i > height) {
				amount += i - height;
			}
		}
		return amount;
	}
}
