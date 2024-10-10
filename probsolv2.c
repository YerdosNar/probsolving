#include <stdio.h>

void slidAvgWindow(int* arr, int size, int window) {
	int avgs[size - window + 1];
	int count = 0;
	for(int i = 0; i < size - window + 1; i++) {
		int avg = 0;
		for(int j = i; j < i + window; j++) {
			avg += arr[j];
		}
		if(avg % window != 0) {
			count++;
		}
		avgs[i] = avg / window;
	}
	if(count == size - window + 1) {
		printf("%d\n", -1);
	} else {
		for(int i = 0; i < size - window + 1; i++) {
			printf("%d\n", avgs[i]);
		}
	}
}
int main() {
	int size, window;
	scanf("%d", &size);
	int arr[size];
	for(int i = 0; i < size; i++) {
		scanf("%d", &arr[i]);
	}
	scanf("%d", &window);

	slidAvgWindow(arr, size, window);

	return 0;
}
