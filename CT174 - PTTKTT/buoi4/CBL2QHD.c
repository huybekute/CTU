#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int TL, GT, SL, PA;
    float DG;
    char Ten[50];
} item;


void readFile(item **a, int *n, int *m){
    FILE *f = fopen("CBL2QHD.txt", "r");
    if(f!=NULL){
        fscanf(f, "%d", m);
        int i = 0;
        *a = (item*)malloc(sizeof(item));
        while(!feof(f)){
            (*a) = (item*)realloc(*a, sizeof(item)*(i+1));
            fscanf(f, "%d%d%d%[^\n]", &(*a)[i].TL, &(*a)[i].GT, &(*a)[i].SL, (*a)[i].Ten);
            (*a)[i].DG = (float)(*a)[i].GT / (*a)[i].TL;
            (*a)[i].PA = 0;
            i++;
        }
        (*n) = i;
    }
    fclose(f);
}

void print(item *a, int n){
    int TTL = 0, TGT = 0;
    for(int i=0; i<n; i++){
        printf("| %20s | %8d | %8d | %8.2f | %8d |\n", a[i].Ten, a[i].TL, a[i].GT, a[i].DG, a[i].PA);
        TGT += a[i].GT * a[i].PA;
        TTL += a[i].TL * a[i].PA;
    }
    printf("TTL = %d\n", TTL);
    printf("TGT = %d\n", TGT);
}

typedef int table[50][100];

int min(int a, int b){
    return a < b ? a : b;
}

void taoBang(item *a, int n, int m, table F, table X){
    for(int i=0; i<=m; i++){
        X[0][i] = min(i/a[0].TL, a[0].SL);
        F[0][i] = X[0][i] * a[i].GT;
    }
    for(int i=0; i<n; i++){
        for(int j=0; j<=m ; j++){
            F[i][j] = F[i-1][j];
            X[i][j] = 0;
            for(int k=0; k<=min(j/a[i].TL, a[i].SL); k++){
                if(k*a[i].GT + F[i-1][j-k*a[i].TL] > F[i][j]){
                    F[i][j] = k *a[i].GT + F[i-1][j-k*a[i].TL];
                    X[i][j] = k;
                }
            }
        }
    }
}

void inBang(item *a, int n, int m, table F, table X){
    for(int i=0; i<n; i++){
        for(int j=0; j<=m; j++){
            printf("| %2d %2d ", F[i][j], X[i][j]);
        }
        printf("\n");
    }
}

void traBang(item *a, int n, int m, table X){
    for(int i=n-1; i>=0; i--){
        a[i].PA = X[i][m];
        m-=a[i].TL * X[i][m];
    }
}

int main(){
    item *a;
    int n=0, m=0;
    readFile(&a, &n, &m);
    table F, X;
    taoBang(a, n, m, F, X);
    inBang(a, n, m, F, X);
    traBang(a, n, m , X);
    print(a, n);
}