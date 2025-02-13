ElementType front(Queue Q){
    struct Node *a = Q.front->next;
    return a->data;
}