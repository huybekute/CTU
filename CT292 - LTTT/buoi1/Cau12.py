while True:
    n12 = input("Nhap so nguyen n: ")
    n12 = int(n12)
    if(n12 > 0 ):
        break
    else:
        print("So phai lon hon 0, vui long nhap lai")

tong12 = 0
temp12 = n12
while temp12 > 0:
    chuSo = temp12  % 10
    tong12 += chuSo
    temp12 = temp12 // 10

print(f"Tong cac chu so cua {n12} la {tong12}")