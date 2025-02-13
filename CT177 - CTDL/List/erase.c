void erase(int x, List *pL){
    int p = locate(x, *pL);
    deleteList(p, &*pL);
}