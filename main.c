#include <stdio.h>
#include <assert.h>
#include "axiome.h"


void swap(Element* a, Element* b);

void printArray(Element t[], int s);

int* median(Element* i, Element* j, Element* k);

void partition(Element t[], int i, int j, int* k) {
	int l;

	swap(t+i, median(t+i, t+j, t+((i+j)/2)) );
	l = i + 1; *k = j;
    assert( t[i] >= t[j] && t[i] <= t[(i+j)/2] ); /// Axiome 1

	while( l <= *k ) {
		while( t[*k] > t[i] && l <= *k ) {
            assert( axiome2(t, i, j, *k, l) ); /// Axiome 2
			*k = (*k)-1;
            printf("k: %d\n", *k);
		}

		while( t[l] <= t[i] && l <= *k ) {
            assert( axiome3(t, i, j, *k, l) ); /// Axiome 3
			l = l+1;
            printf("l: %d\n", l);
		}

		if( l<*k ) {
            printf("k: %d - l: %d\n", *k, l);
			swap( t+l, t+(*k) );
			l = l+1;
			*k = (*k)-1;
		}
        axiome4(t, i, j, *k, l); /// Axiome 4
	}
    assert( t[i] >= t[*k] ); /// Axiome 5

            printf("k: %d - l: %d\n", *k, l);
	swap(t+i, t+(*k) );
    assert( t[i] <= t[*k] ); /// Axiome 6
}

int main(){
	Element tab[] = {6, 4, 7, 3, 0, 2, 8, 2};
	int k;
	printArray(tab, 8);
	partition(tab, 0, 7, &k);
	printArray(tab, 8);
    return 0;
}

void swap(Element* a, Element* b) {
    Element tmp = *a;
    *a = *b;
    *b = tmp;
}

void printArray(Element* t, int s) {
    for(int i=0; i<s; i++)
        printf("[%d] ", t[i]);
    puts("");
}

int* median(Element* i, Element* j, Element* k) {
	if     (*j <= *i  && *i <= *k) return i;
	else if(*k <= *j  && *j <= *i) return j;
	else if(*i <= *k  && *k <= *j) return k;
	else if(*k <= *i  && *j <= *k) return k;
    else return NULL;
}

