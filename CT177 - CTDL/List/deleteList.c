void deleteList(int p, List *pL){
    if(p > pL->Last){
        printf("Vi tri khong hop le\n");
    }
    else{
        p = p-1;
        for(int i = p; i<pL->Last - 1; i++){
            pL->Elements[i] = pL->Elements[i+1];
        }
        pL->Last--;
    }
}