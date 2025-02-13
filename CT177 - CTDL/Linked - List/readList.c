void append(int x, List *pL){
    Position p = (*pL);
    Position q = (struct Node*)malloc(sizeof(struct Node));
    while(p->Next != NULL){
        p = p->Next;
    }
    q->Element = x;
    q->Next = p->Next;
    p->Next = q;
}
void readList(List *pL){
    int n;
    makenullList(&*pL);
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        int x;
        scanf("%d", &x);
        append(x, &*pL);
    }
}