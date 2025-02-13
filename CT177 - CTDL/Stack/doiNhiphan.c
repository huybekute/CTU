void doiNhiPhan(int n, NganXep *pS){
    khoitao(&*pS);
    while(n != 0){
        int temp = n % 2;
        n = n / 2;
        them(temp, &*pS);
    }
}
void hienthi(NganXep *pS){
    while(!ktRong(*pS)){
        printf("%d ", pS->DuLieu[pS->Dinh]);
        xoa(&*pS);
    }
}