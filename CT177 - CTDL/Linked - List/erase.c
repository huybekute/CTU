void erase(int x, List *pL){
    Position p = locate(x, *pL);
    if(p->Next != NULL) deleteList(p, &*pL);
    else printf("Not found %d\n", x);
}