void deleteList(Position p, List *pL){
    p->Next = p->Next->Next;
}