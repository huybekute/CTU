while True:
    n5 = input("Nhap so nguyen n: ")
    n5 = int(n5)
    if(n5 >= 0):
        break
    else:
        print("n phai lon hon 0, vui long nhap lai")

kq5 = 1
for i in range(1, n5+1):
    kq5 *= i

print(kq5)