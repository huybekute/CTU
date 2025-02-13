void removeAll(int x, List *pL){
    Position p = (*pL);
    while(p->Next != NULL){
        if(locate(x, *pL) == p) deleteList(p, &*pL);
        else p = p->Next;
    }
}