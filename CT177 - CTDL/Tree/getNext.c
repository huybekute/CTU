Tree min(Tree T){
    if(T->Left != NULL) return min(T->Left);
    return T;
}
Tree max(Tree T){
    if(T->Right != NULL) return max(T->Right);
    return T;
}
Tree getNext(int x, Tree T){
    if(T->Key == x){
        if(T->Right != NULL) return min(T->Right);
        else return NULL;
    }
    else if(T->Left->Key == x){
        if(T->Left->Right != NULL) return min(T->Left->Right);
        return T;
    }
    else if(T->Key < x) return getNext(x, T->Right);
    else return getNext(x, T->Left);
}