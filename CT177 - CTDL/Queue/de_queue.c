ElementType de_queue(Queue *pQ){
    struct Node *a = pQ->front->next;
    int data = a->data;
    pQ->front = pQ->front->next;
    pQ->size--;
    return data;
}
