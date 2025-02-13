int member(int x, List L){
    for(int i=0; i<L.Last; i++){
        if(L.Elements[i] == x) return 1;
    }
    return 0;
}