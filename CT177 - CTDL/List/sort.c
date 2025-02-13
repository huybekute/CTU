void sort(List *pL){
    int p = 0;
    while(p != pL->Last){
        int q = p+1;
        while(q != pL->Last){
            if(pL->Elements[p] > pL->Elements[q]){
                int temp = pL->Elements[q];
                pL->Elements[q] = pL->Elements[p];
                pL->Elements[p] = temp;
            }
            q++;
        }
        p++;
    }
}