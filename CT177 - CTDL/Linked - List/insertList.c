void insertList(int x, Position p, List *pL){
    Position q = (struct Node*)malloc(sizeof(struct Node));
    q->Element = x;
    q->Next = p->Next;
    p->Next = q;
}