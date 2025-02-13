Position locate(int x, List L){
    Position p = L;
    while(p->Next != NULL){
        if(p->Next->Element == x) return p;
        p = p->Next;
    }
    return p;
}