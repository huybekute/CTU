float getAvg(List L){
    int tong = 0;
    int dem  = 0;
    if(L.Last == 0) return -10000.0000;
    for(int i=0; i<L.Last; i++){
        tong += L.Elements[i];
        dem++;
    }
    return tong/dem;
}