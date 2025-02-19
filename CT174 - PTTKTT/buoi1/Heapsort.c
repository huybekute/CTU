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

void pushDown(rec a[], int first, int last){
	int f = first;
	while(f <= (last-1)/2 ){
		int L = 2*f+1;
		int R = 2*f+2;
		if(last == L){
			if(a[f].key > a[L].key){
				swap(&a[f], &a[L]);
			}
			return;
		}
		if((a[f].key > a[L].key) && (a[L].key <= a[R].key)){
			swap(&a[f], &a[L]);
			f = L;
		}
		else if((a[f].key > a[R].key) && (a[R].key <= a[L].key)){
			swap(&a[f], &a[R]);
			f = R;
		}
		else return;
	}
}

void heapsort(rec a[], int n){
	for(int i=(n-2)/2; i>=0; i--){
		pushDown(a, i, n-1);
	}
	for(int i = n-1; i>=2; i--){
		swap(&a[0], &a[i]);
		pushDown(a, 0, i-1);
	}
	swap(&a[0], &a[1]);
}

void readFile(rec a[], int *n){
	FILE *f = fopen("data.txt", "r");
	if(f!=NULL){
		while(!feof(f)){
			fscanf(f,"%d%f", &a[*n].key, &a[*n].other);
			(*n)++;
		}
	}
	fclose(f);
}

void print(rec a[], int n){
	for(int i=0; i<n; i++){
		printf("%3d %5d %8.2f\n", i+1, a[i].key, a[i].other);
	}
}

int main(){
	int n=0;
	rec a[100];
	printf("Thuat toan HeapSort: \n");
	readFile(a, &n);
	printf("Du lieu truoc khi sap xep: \n");
	print(a, n);
	printf("Du lieu sau khi sap xep: \n");
	heapsort(a, n);
	print(a, n);
	return 0;
}