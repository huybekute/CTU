void makenull(Queue *pQ) {
    pQ->rear = (struct Node *)malloc(sizeof(struct Node));
    pQ->rear->next = NULL;
    pQ->front = pQ->rear;
    pQ->size = 0; 
}