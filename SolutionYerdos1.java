import java.util.*;

public class SolutionYerdos1 {
	public static int maxGcd(List<Integer> list) {
		int max = 0;
		for(int i = 0; i < list.size() - 1; i++) {
			for(int j = i+1; j < list.size(); j++) {
				int gcdNum = gcd(list.get(i), list.get(j));
				if(max < gcdNum) {
					max = gcdNum;
				}
			}
		}
		System.out.println(Arrays.toString(list.toArray()));
		return max;
	}
	private static int gcd(int first, int second) {
		if(first == 0) {
			return second;
		}
		return gcd(second % first, first);
	}
	private static boolean isSumPrime(int num) {
		int sum = 0;
		while(num > 0) {
			sum += num % 10;
			num /= 10;
		}
		if(sum == 1 || sum == 2) {
			return true;
		}
		for(int i = 2; i <= Math.sqrt(sum); i++) {
			if(sum % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		List<Integer> nums = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			int num = sc.nextInt();
			if(isSumPrime(num)) {
				nums.add(num);
			}
		}
		System.out.println(maxGcd(nums));
	}
}
