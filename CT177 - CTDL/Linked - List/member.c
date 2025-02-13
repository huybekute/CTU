int member(int x, List L){
    Position p = L;
    while(p->Next != NULL){
        if(p->Next->Element == x) return 1;
        p=p->Next;
    }
    return 0;
}