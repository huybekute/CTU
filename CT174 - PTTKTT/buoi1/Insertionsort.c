#include <stdio.h>

typedef struct{
	int key;
	float other;
} rec;

void swap(rec *a , rec*b){
	rec temp = *a;
	*a = *b;
	*b = temp;
}

void insertionsort(rec a[], int n){
	for(int i=1; i<n; i++){
		int j = i;
		while((j>0) && (a[j].key < a[j-1].key)){
			swap(&a[j], &a[j-1]);
			j--;
		}
	}
}

void readFile(rec a[], int *n){
	FILE *f = fopen("data.txt", "r");
	if(f != NULL){
		while(!feof(f)){
			fscanf(f, "%d%f", &a[*n].key, &a[*n].other);
			(*n)++;
		}
	}
	fclose(f);
}

void print(rec a[], int n){
	for(int i = 0; i<n ; i++){
		printf("%3d %5d %8.2f\n", i+1, a[i].key, a[i].other);
	}
}

int main(){
	int n = 0;
	rec a[100];
	printf("Thuan toan InsertionSort: \n");
	readFile(a, &n);
	printf("Du lieu truoc khi sap xep: \n");
	print(a, n);
	printf("Du lieu sau khi sap xep: \n");
	insertionsort(a, n);
	print(a, n);
	return 0;
}