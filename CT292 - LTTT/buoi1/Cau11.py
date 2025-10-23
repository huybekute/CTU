danhsachSNT11 = []
for i in range(1000, 10000):
    snt11 = True
    j = 2
    while j*j <= i:
        if i % j == 0:
            snt11 = False
            break
        j+=1
    if(snt11):
        danhsachSNT11.append(i)
print(f"Danh sach SNT co 4 chu so")
print(danhsachSNT11)