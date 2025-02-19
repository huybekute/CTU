Tree rightSibling(int x, Tree T){
    if(T->Left == NULL || T->Right == NULL) return NULL;
    else if(T->Left->Key == x){
        if(T->Right != NULL){
            return T->Right;
        }
        else{
            T=NULL;
            return T;
        }
    }
    else if(T->Key < x) return rightSibling(x, T->Right);
    else return rightSibling(x, T->Left);
}