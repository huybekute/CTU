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