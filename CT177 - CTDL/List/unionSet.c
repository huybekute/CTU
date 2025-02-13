void unionSet(List L1, List L2, List *pL){
    makenullList(&*pL);
    for(int i=0; i<L1.Last; i++){
        pL->Elements[i] = L1.Elements[i];
        pL->Last++;
    }
    for(int i=0; i<L2.Last; i++){
        if(member(L2.Elements[i], L1) == 0){
            insertSet(L2.Elements[i], &*pL);
        }
    }
}