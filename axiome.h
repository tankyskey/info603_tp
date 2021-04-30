#ifndef AXIOME_H
#define AXIOME_H

typedef int Element;

/// l <= k && t[i] < t[k..j]
int axiome2(Element t[], int i, int j, int k, int l) {
    // l <= k
    if( !(l<=k) ) return 0;

    // t[i] < t[k..j]
    for ( int m=k; m<=j; m++) // m: k..j
        if ( !(t[i] < t[m]) ) return 0;

    return 1;
}

/// l <= k && t[i] >= t[i..l-1]
int axiome3(Element t[], int i, int j, int k, int l) {
    // l <= k
    if( !(l<=k) ) return 0;

    // t[i] >= t[i..l-1]
    for ( int m=i; m<=l-1; m++) // m: i..l-1
        if ( !(t[i] >= t[m]) ) return 0;

    return 1;
}

/// l > k || (t[k] <= t[i]    &&    t[l] > t[i])
int axiome4(Element t[], int i, int j, int k, int l) {
    // l > k
    int operande1 = l > k;

    // t[k] <= t[i]    &&    t[l] > t[i]
    int operande2 = t[k] <= t[i] && t[l] > t[i];

    if ( operande1 || operande2 ) return 1;

    return 0;
}


#endif
