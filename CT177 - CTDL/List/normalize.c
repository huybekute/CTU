void normalize(List *pL){
    int p = 0;
    while(p != pL->Last){
        int q = p+1;
        while(q!=pL->Last){
            if(pL->Elements[p] == pL->Elements[q]){
                for(int i=q; i<pL->Last - 1; i++){
                    pL->Elements[i] = pL->Elements[i+1];
                }
                pL->Last--;
            }
            else{
                q++;
            }
        }
        p++;
    }
}