#include <stdio.h>

void swap(int* a, int* b) { int tmp = *a; *a = *b; *b = tmp; }

void printArray(int* t, int s) { for(int i=0; i<s; i++) printf("[%d]: %d, ", i, t[i]);}

int* median(int* i, int* j, int* k) {
	if(*j <= *i  && *i <= *k) return i;
	if(*k <= *j  && *j <= *i) return j;
	if(*i <= *k  && *k <= *j) return k;
}

void partition(int t[], int i, int j, int* k) {
	int l;

	swap(t+i, median(t+i, t+j, t+((i+j)/2)) );

	l = i + 1;
	*k = j;

	while( l <= *k ) {
		while( t[*k] > t[i] && l <= *k ) {
			*k = (*k)-1;
		}

		while( t[l] <= t[i] && l <= *k ) {
			l = l+1;
		}

		if( l<*k ) {
			swap( t+l, t+(*k) );
			l = l+1;
			*k = (*k)-1;
		}
	}
	swap(t+i, t+(*k) );
}

int main(){
	int tab[] = {6, 4, 7, 3, 0, 2, 8, 2};
	int k;
	partition(tab, 0, 5, &k);
	printf("%d\n", k);
	printArray(tab, 8);
    return 0;
}

