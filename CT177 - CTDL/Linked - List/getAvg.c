float getAvg(List L){
    Position p = L;
    float tong = 0;
    int dem = 0;
    if(p->Next == NULL) return -10000.0f;
    while(p->Next != NULL){
        tong += p->Next->Element;
        p = p->Next;
        dem++;
    }
    return tong/dem;
}