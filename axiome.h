#ifndef AXIOME_H
#define AXIOME_H

typedef int Element;

int axiome2(Element t[], int i, int j, int k, int l) {
    if( !(l<=k) ) return 0;
    // TODO: m<j ou m<=j ?
    for ( int m=k; m<j; m++) 
        if ( (t[i] < t[m]) ) return 0;

    return 1;
}


#endif
