void preOrder(Tree T){
    if(T != NULL){
        printf("%d ", T->Key);
        preOrder(T->Left);
        preOrder(T->Right);
    }
}