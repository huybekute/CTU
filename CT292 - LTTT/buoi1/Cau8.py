a8 = input("Nhap so thap phan: ")
a8 = int(a8)

if(a8 == 0):
    print(f"So nhi phan cua {a8} la 0")

chuoiNhiPhan = ""
temp = a8
while(temp > 0):
    du = temp % 2
    chuoiNhiPhan = str(du) + chuoiNhiPhan
    temp = temp // 2

print(f"So nhi phan cua {a8} la {chuoiNhiPhan}")