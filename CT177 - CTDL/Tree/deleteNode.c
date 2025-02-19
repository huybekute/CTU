int deleteMin(Tree *pT){
    int k;
    if((*pT)->Left == NULL){
        k = (*pT)->Key;
        (*pT) = (*pT)->Right;
        return k;
    }
    return deleteMin(&(*pT)->Left);
}
void deleteNode(int x, Tree *pT){
    if((*pT) != NULL){
        if((*pT)->Key > x) deleteNode(x, &(*pT)->Left);
        else if((*pT)->Key < x) deleteNode(x, &(*pT)->Right);
        else{
            if((*pT)->Left == NULL || (*pT)->Right == NULL){
                (*pT) = NULL;
            }
            else if((*pT)->Left == NULL) (*pT) = (*pT)->Right;
            else if((*pT)->Right == NULL) (*pT) = (*pT)->Left;
            else (*pT)->Key = deleteMin(&(*pT)->Right);
        }
    }
}