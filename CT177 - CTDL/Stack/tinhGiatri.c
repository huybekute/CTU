float tinhGiatri(char st[]) {
    Stack s;
    makenullStack(&s);
    for (int i = 0; st[i] != '\0'; i++) {
        char c = st[i];
        if (isdigit(c)) {
            push((float)(c - '0'), &s); 
        }
        else if (c == '+' || c == '-' || c == '*' || c == '/') {
            float op2 = top(s); 
            pop(&s); 
            float op1 = top(s); 
            pop(&s);
            float kq;
            switch (c) {
                case '+': kq = op1 + op2; break;
                case '-': kq = op1 - op2; break;
                case '*': kq = op1 * op2; break;
                case '/': kq = op1 / op2; break;
            }
            
            push(kq, &s);
        }
    }
    return top(s);
}

