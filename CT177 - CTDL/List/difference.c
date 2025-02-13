void difference(List L1, List L2, List *pL){
    makenullList(&*pL);
    for(int i=0; i<L1.Last; i++){
        if(member(L1.Elements[i], L2) == 0){
            insertSet(L1.Elements[i], &*pL);
        }
    }
}