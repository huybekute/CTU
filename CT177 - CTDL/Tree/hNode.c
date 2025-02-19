int Height(Tree T){
    if(T == NULL) return -1;
    else{
        int l = Height(T->Left);
        int r = Height(T->Right);
        if(l>r) return l + 1;
        else return r+1;
    }
}
Tree searchNode(int x, Tree T){
    if(T==NULL) return NULL;
    else if(T->Key == x) return T;
    else if(T->Key < x) return searchNode(x, T->Right);
    else return searchNode(x, T->Left);
}
int hNode(int x, Tree T){
    if(T==NULL) return -1;
    else return Height(searchNode(x, T));
}