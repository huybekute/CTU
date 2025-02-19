int getHeight(Tree T){
    if(T == NULL) return -1;
    else{
        int l = getHeight(T->Left);
        int r = getHeight(T->Right);
        if(l > r) return l+1;
        else return r+1;
    }
}