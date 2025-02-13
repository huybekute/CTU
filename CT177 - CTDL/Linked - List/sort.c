void sort(List *pL){
    int temp;
    Position p = (*pL);
    while(p->Next != NULL){
        Position q = p->Next;
        while(q->Next!=NULL){
            if(p->Next->Element > q->Next->Element){
                temp = p->Next->Element;
                p->Next->Element = q->Next->Element;
                q->Next->Element = temp;
            }
            q = q->Next;
        }
        p = p->Next;
    }
}