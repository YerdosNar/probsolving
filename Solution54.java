import java.util.*;
public class Solution54 {
	public static List<Integer> solution(int [][]matrix) {
		List<Integer> list = new ArrayList<>();
		int U = 1, R = 2, D = 3, L = 4;
		int topWall = 0, rightWall = matrix[0].length, bottomWall = matrix.length, leftWall = -1;
		int direction = R;
		int i = 0, j = 0;
		while(list.size() != matrix.length * matrix[0].length) {
			if(direction == R) {
				while(j < rightWall) {
					list.add(matrix[i][j]);
					j++;
				}
				j--;
				i++;
				rightWall--;
				direction = D;
			} else if(direction == D) {
				while(i < bottomWall) {
					list.add(matrix[i][j]);
					i++;
				}
				i--;
				j--;
				bottomWall--;
				direction = L;
			} else if(direction == L) {
				while(j > leftWall) {
					list.add(matrix[i][j]);
					j--;
				}
				j++;
				i--;
				leftWall++;
				direction = U;
			} else {
				while(i > topWall) {
					list.add(matrix[i][j]);
					i--;
				}
				i++;
				j++;
				topWall--;
				direction = R;
			}
		}
		return list;
	}
	static void printMatrix(int [][]matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String []args) {
		int [][]matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println("The matrix:");
		printMatrix(matrix);
		System.out.print("\nSpiral traversal: ");
		List<Integer> list = solution(matrix);
		for(int i = 0; i < list.size() - 1; i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.println(list.get(list.size() - 1) + ";");
	}
}
