Tree searchNode(int x, Tree T){
    if(T == NULL) return NULL;
    else if(T->Key == x) return T;
    else if(T->Key < x) return searchNode(x, T->Right);
    else return searchNode(x, T->Left);
    
}   