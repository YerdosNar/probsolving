#include <stdio.h>
#include <limits.h>
#include <stdbool.h>
#include <math.h>

void printprimes(unsigned int limit) {
	bool primes[limit];
	for(unsigned int i = 0; i < limit; i++){
		primes[i] = true;
	}
	unsigned int p = 2;
	while(p * p < limit) {
		if(primes[p] == true) {
			for(unsigned int i = p * p; i < limit; i += p) {
				primes[i] = false;
			}
		}
		p++;
	}
	int count = 0;
	unsigned int i;
	printf("[");
	for(i = 2; i < limit; i++) {
		if(primes[i]) {
			printf("%d, ", i);
			count++;
		}
	}
	printf("\nThere are %d prime numbers.", count);
} 

int main() {
	unsigned int limit;
	scanf("%d", &limit);
	unsigned int num = INT_MAX;
	printprimes(limit);

	return 0;
}
