import math
def ptBac2():
    a6 = input("Nhap tham so a: ")
    b6 = input("Nhap tham so b: ")
    c6 = input("Nhap tham so c: ")
    a6 = float(a6)
    b6 = float(b6)
    c6 = float(c6)

    delta = (b6*b6) - (4*a6*c6)
    if(delta < 0):
        print("Phuong trinh vo nghiem")
    elif(delta == 0):
        print(f"Phuong tirnh co nghiem kep {-b6/(2*a6)}")
    else:
        print(f"Phuong trinh co nghiep x1 = {(-b6 + sqrt(delta)) / (2*a6)} va x2 = {(-b6 - sqrt(delta)) / (2*a6)}")

ptBac2()