void copyEvenNumbers(List L, List *pL){
    makenullList(&*pL);
    Position p = L;
    while(p->Next != NULL){
        if(p->Next->Element % 2 == 0){
            append(p->Next->Element, &*pL);
        }
        p = p->Next;
    }
}