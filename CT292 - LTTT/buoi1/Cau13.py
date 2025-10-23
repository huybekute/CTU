dsSoLe13 = []
for i in range(1000, 2001):
    soLe = True
    for j in str(i):
        if int(j) % 2 == 0:
            soLe = False
            break
    if soLe:
        dsSoLe13.append(i)
print("DS so co cac chu so le lon hon 1000 va nho hon 2000 la: ")
print(dsSoLe13)