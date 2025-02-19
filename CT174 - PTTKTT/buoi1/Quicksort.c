#include <stdio.h>

typedef struct{
	int key;
	float other;
} rec;

void swap(rec *a, rec *b){
	rec temp = *a;
	*a = *b;
	*b = temp;
}

int findPivot(rec a[], int i, int j){
	int firstkey = a[i].key;
	for(int k = i+1; k<=j; k++){
		if(a[k].key != firstkey){
			if(a[k].key > firstkey){
				return k;
			}
			else{
				return i;
			}
		}
	}
	return -1;
}

int Partition(rec a[], int L, int R, int pivot){
	while( L <= R){
		while(a[L].key < pivot) L++;
		while(a[R].key >= pivot) R--;
		if(L < R){
			swap(&a[L], &a[R]);
		}
	}
	return L;
}

void Quicksort(rec a[], int i, int j){
	int pivotidx = findPivot(a, i, j);
	if(pivotidx != -1 ){
		int k = Partition(a, i, j, a[pivotidx].key);
		Quicksort(a, i, k-1);
		Quicksort(a, k, j);
	}
}


void readFile(rec a[], int *n){
	FILE *f = fopen("data.txt", "r");
	if( f!= NULL){
		while(!feof(f)){
			fscanf(f, "%d%f", &a[*n].key, &a[*n].other);
			(*n)++;
		}
	}
	fclose(f);
}


void print(rec a[], int n){
	for(int i=0; i<n; i++){
		printf("%3d %3d %8.2f\n", i+1, a[i].key, a[i].other);
	}
}

int main(){
	int n=0;
	rec a[100];
	printf("Thuat toan QuickSort: \n");
	readFile(a, &n);
	printf("Du lieu truoc khi sap xep: \n");
	print(a, n);
	printf("Du lieu sau khi sap xep: \n");
	Quicksort(a, 0, n-1);
	print(a, n);
	return 0;
}