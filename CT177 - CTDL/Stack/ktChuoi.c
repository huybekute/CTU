int ktChuoi(){
    Stack S;
    makenullStack(&S);
    char x[50];
    scanf(" %[^\n]", x);
    for(int i=0; i<50; i++){
        if(x[i] == '('){
            push(x[i], &S);
        }
        if(x[i] == ')' && !emptyStack(S)){
            pop(&S);
        }
    }
    if(emptyStack(S)) return 1;
    return 0;
}