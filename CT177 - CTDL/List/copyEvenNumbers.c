void copyEvenNumbers(List L, List *pL){
    makenullList(&*pL);
    for(int i=0; i<L.Last; i++){
        if(L.Elements[i] % 2 == 0){
            insertList(L.Elements[i], pL->Last + 1, &*pL);
        }
    }
}