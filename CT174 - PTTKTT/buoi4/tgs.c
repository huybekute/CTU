#include <stdio.h>

void readFile(int a[100][100], int *n){
    FILE *f =fopen("tgs.txt", "r");
    int i = 0;
    while(!feof(f)){
        for(int j=0; j<=i; j++){
            fscanf(f, "%d", &a[i][j]);
        }
        i++;
    }
    (*n) = i;
    fclose(f);
}

void print(int a[100][100], int n){
    for(int i=0; i<n; i++){
        for(int j=0; j<=i; j++){
            printf("%d ", a[i][j]);
        }
        printf("\n");
    }
}

int truyhoi(int F[100][100], int i, int j){
    if(j==0) return (F[i-1][0] > F[i-1][1]) ? 0 : 1;
    if(j==i) return i-1;
    if(j==i-1) return (F[i-1][i-2] > F[i-1][i-1]) ? i-2 : i-1;
    if(F[i-1][j] > F[i-1][j+1] && F[i-1][j] > F[i-1][j-1]) return j;
    if(F[i-1][j-1] > F[i-1][j+1] && F[i-1][j-1] > F[i-1][j]) return j-1;
    return j+1;
}

void taoBang(int a[100][100], int n, int F[100][100]){
    F[0][0] = a[0][0];
    F[1][0] = F[0][0] + a[1][0];
    F[1][1] = F[0][0] + a[1][1];
    for(int i=2; i<n; i++){
        for(int j=0; j<n; j++){
            int k = truyhoi(F, i, j);
            F[i][j] = F[i-1][k] + a[i][j];
        }
    }
 }

 void inBang(int F[100][100], int n){
    for(int i=0; i<n; i++){
        for(int j=0; j<=i; j++){
            printf("%d ", F[i][j]);
        }
        printf("\n");
    }
 }

void traBang(int a[100][100], int F[100][100], int n, int kq[]){
    int max = F[n-1][0];
    int k = 0;
    for(int i=0; i<n; i++){
        if(F[n-1][i] > max){
            max = F[n-1][i];
            k = i;
        }
    }
    for(int j=n-1; j>0; j--){
        kq[j] = a[j][k];
        int k = truyhoi(F, j, k);
    }
}

void printkq(int kq[], int n ){
    for(int i=0; i<n; i++){
        printf("%d ", kq[i]);
    }
}

int main(){
    int a[100][100];
    int n = 0;
    readFile(a, &n);
    print(a, n);
    int F[100][100];
    taoBang(a, n, F);
    inBang(F, n);
    int kq[100];
    traBang(a, F, n, kq);
    printkq(kq, n);
}
