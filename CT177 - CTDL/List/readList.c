void readList(List *pL){
    makenullList(&*pL);
    int n, x;
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d", &x);
        insertList(x, i + 1, &*pL);
    }
}