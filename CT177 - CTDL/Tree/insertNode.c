void insertNode(int x, Tree *pT){
    if((*pT) == NULL){
        (*pT) = (struct Node*)malloc(sizeof(struct Node));
        (*pT)->Left = NULL;
        (*pT)->Right = NULL;
        (*pT)->Key = x;
    }
    else{
        if((*pT)->Key < x) insertNode(x, &(*pT)->Right);
        else if((*pT)->Key > x) insertNode(x, &(*pT)->Left);
    }
}