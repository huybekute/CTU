Tree getParent(int x, Tree T){
    if(T->Key == x) return NULL;
    else if(T->Left->Key == x || T->Right->Key == x) return T;
    else if(T->Left->Key < x) return getParent(x, T->Right);
    else return getParent(x, T->Left);
}