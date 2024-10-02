#include <stdio.h>
#include <stdbool.h>
#include <math.h>

bool isprime(unsigned int limit) {
	for(int i = 2; i < sqrt(limit); i++) {
		if(limit % i == 0) {
			return false;
		}
	}
	return true;
}

int main() {
	int num;
	scanf("%d", &num);
	if(isprime(num)) {
		printf("%d is prime", num);
	} else {
		printf("%d is NOT prime", num);
	}

	return 0;
}
