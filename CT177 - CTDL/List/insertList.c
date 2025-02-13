void insertList(int x, int p, List *pL){
    p = p - 1;
    for(int i = p; i<pL->Last; i++){
        pL->Elements[i] = pL->Elements[i+1];
    }
    pL->Last++;
    pL->Elements[p] = x;
}