void normalize(List *pL){
    Position p = (*pL);
    while(p->Next != NULL){
        Position q = p->Next;
        while(q->Next != NULL){
            if(p->Next->Element == q->Next->Element){
                deleteList(p, &*pL);
            }
            else q = q->Next;
        }
        p = p->Next;
    }
}