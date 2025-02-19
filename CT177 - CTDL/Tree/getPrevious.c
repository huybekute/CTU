Tree min(Tree T){
    if(T->Left != NULL) return min(T->Left);
    return T;
}
Tree max(Tree T){
    if(T->Right != NULL) return max(T->Right);
    return T;
}
Tree getPrevious(int x, Tree T){
    if(min(T->Left)->Key == x) return NULL;
    else if(T->Key == x) return max(T->Left);
    else if(T->Key < x){
        if(min(T->Right)->Key == x) return T;
        return getPrevious(x, T->Right);
    }
    else return getPrevious(x, T->Left);
}