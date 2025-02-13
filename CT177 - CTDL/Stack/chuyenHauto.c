void chuyenHauto(char trungto[], char hauto[]) {
    Stack s;
    makenullStack(&s);
    int j = 0;

    for (int i = 0; trungto[i] != '\0'; i++) {
        char c = trungto[i];
        if (c == ' ')
            continue;
        if (isalnum(c)) {
            hauto[j++] = c; 
        }
        else if (c == '(') {
            push(c, &s);
        }
        else if (c == ')') {
            while (!emptyStack(s) && top(s) != '(') {
                hauto[j++] = top(s);
                pop(&s);
            }
            pop(&s);
        }
        else if (c == '+' || c == '-' || c == '*' || c == '/') {
            while (!emptyStack(s) && top(s) != '(' && mucUutien(top(s)) >= mucUutien(c)) {
                hauto[j++] = top(s);
                pop(&s);
            }
            push(c, &s);
        }
    }
    while (!emptyStack(s)) {
        hauto[j++] = top(s);
        pop(&s);
    }

    hauto[j] = '\0';
}