#include <stdio.h>

int collect(int* trees, int height, int length) {
	int amount = 0;
	for(int i = 0; i < length; i++) {
		if(trees[i] > height) {
			amount += trees[i] - height;
		}
	}
	return amount;
}
int bestHeight(int* trees, int need, int length) {
	int low = 0, high = trees[0];
	for(int i = 1; i < length; i++) {
		if(high < trees[i]) {
			high = trees[i];
		}
	}

	int bestH = 0;
	while(low <= high) {
		int mid = (low + high) / 2;
		int wood = collect(trees, mid, length);
		if(wood >= need) {
			bestH = mid;
			low = mid + 1;
		} else {
			high = mid - 1;
		}
	}
	return bestH;
}

int main() {
	int num;
	scanf("%d", &num);
	int needed;
	scanf("%d", &needed);
	int trees[num];
	for(int i = 0; i < num; i++) {
		scanf("%d", &trees[i]);
	}
	printf("%d", bestHeight(trees, needed, num));

	return 0;
}
