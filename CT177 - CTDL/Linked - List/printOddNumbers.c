void printOddNumbers(List L){
    Position p = L;
    while(p->Next != NULL){
        if(p->Next->Element % 2 != 0 ){
            printf("%d ", p->Next->Element);
        }
        p = p->Next;
        
    }
}