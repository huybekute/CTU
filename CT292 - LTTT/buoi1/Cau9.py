def timUCLN(a9, b9):
    a_9 = a9
    b_9 = b9
    while b_9:
        temp = a_9       
        a_9 = b_9          
        b_9 = temp % b_9
    return a_9

def timBCNN(a9, b9, ucln):
    if(ucln == 0):
        return 0
    return (a9*b9) // ucln

while True:
    a9 = input("Nhap so nguyen duong a: ")
    b9 = input("Nhap so nguyen duong b: ")
    a9 = int(a9)
    b9 = int(b9)
    if(a9 > 0 and b9 > 0):
        break
    else:
        print("Nhap sai vui long nhap lai")

kqUCLN9 = timUCLN(a9, b9)
kqBCNN9 = timBCNN(a9, b9, kqUCLN9)
print(f"UCLN cua {a9} va {b9} la {kqUCLN9}")
print(f"BCNN cua {a9} va {b9} la {kqBCNN9}")