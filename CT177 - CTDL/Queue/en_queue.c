void en_queue(ElementType x, Queue *pQ) {
    struct Node *T = (struct Node*) malloc(sizeof(struct Node));
    if (pQ->rear == NULL) {
        pQ->front = pQ->rear = T;
    } else {
        pQ->rear->next = T;
        pQ->rear = T;
    }
    pQ->size++;
}
