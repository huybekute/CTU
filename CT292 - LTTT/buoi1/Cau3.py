a3 = input("Nhap so a: ")
a3 = float(a3)
while True:
    b3 = input("Nhap so b khac 0: ")
    b3 = float(b3)
    if(b3 != 0):
        break
    else:
        print("b phai khac 0 vui long nhap lai")

print(f"{a3} + {b3} = {a3 + b3}")
print(f"{a3} - {b3} = {a3 - b3}")
print(f"{a3} * {b3} = {a3 * b3}")
print(f"{a3} / {b3} = {a3 / b3}")
print(f"{a3} % {b3} = {a3 % b3}")
print(f"{a3} ** {b3} = {a3 ** b3}")