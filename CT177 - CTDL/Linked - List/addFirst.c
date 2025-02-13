void addFirst(int x, List *pL){
    Position p = (*pL);
    Position q = (struct Node*)malloc(sizeof(struct Node));
    q->Element = x;
    q->Next = p->Next;
    p->Next = q;
}