void hienthi(NganXep *pS){
    while(!ktRong(*pS)){
        printf("%d ", pS->DuLieu[pS->Dinh]);
        pS->Dinh++;
    }
}