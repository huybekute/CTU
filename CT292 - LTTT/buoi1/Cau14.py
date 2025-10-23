while True:
    n14 = input("Nhap so nguyen duong n: ")
    n14 = int(n14)
    if(n14 >= 0):
        break
    else:
        print("So phai lon hon 0, vui long nhap lai")

tong = 0.0
for i in range(1, n14+1):
    phanSo = i / (i+1)
    tong += phanSo

print(f"Tong 1/2 + 2/3 + 3/4 + 4/5 + ... + n/(n+1) cua {n14} la: ")
print(tong)