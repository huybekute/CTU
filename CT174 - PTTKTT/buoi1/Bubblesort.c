#include<stdio.h>

typedef struct {
	int key;
	float other;
}rec;

void swap(rec *a, rec *b){
	rec temp;
	temp = *a;
	*a = *b;
	*b = temp;
}

void bubbleSort(rec a[], int n){
	for(int i = 0; i < n - 1; i++){
		for(int j = n - 1; j>=i; j--){
			if(a[j].key < a[i].key){
				swap(&a[i], &a[j]);
			}
		}
	}
}

void readFile (rec a[], int *n){    
	FILE *f = fopen("data.txt","r");
	if(f!=NULL)
        while (!feof(f)){
            fscanf(f,"%d%f",&a[*n].key , &a[*n].other);
            (*n)++;
        }
	fclose(f);
}

void print(rec a[], int n){
    for(int i = 0; i < n; i++){
        printf("%3d %5d %8.2f\n", i+1, a[i].key, a[i].other);
	}		
}

int main (){
	rec a[100];
	int n = 0;
	printf("Thuat toan BubbleSort\n");
	readFile(a, &n);
	printf("Du lieu truoc khi sap xep:\n");
	print(a, n);
	bubbleSort(a, n);
	printf("Du lieu sau khi sap xep:\n");
	print(a, n);
	return 0;
}