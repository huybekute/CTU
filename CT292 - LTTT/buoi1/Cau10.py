n10 = input("Nhap so n: ")
n10 = int(n10)
danhSachSNT = []
for i in range(2, n10):
    snt = True
    j = 2
    while j*j <= i:
        if i % j == 0:
            snt = False
            break
        j+=1
    if(snt):
        danhSachSNT.append(i)
print(f"Danh sach SNT nho hon {n10}")
print(danhSachSNT)