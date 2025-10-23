while True:
    try:
        a2 = input("Nhap so lon hon 0 va nho hon 10: ")
        a2 = float(a2)
        if 0 < a2 < 10:
            temp = str(int(a2))
            a2_1 = int(temp)
            a2_2 = int(temp * 2)
            a2_3 = int(temp * 3)
            a2_4 = int(temp * 4)
            print(f"{a2_1} + {a2_2} + {a2_3} + {a2_4} = {a2_1 + a2_2 + a2_3 + a2_4}")
            break
        else:
            print("Nam ngoai khoan quy dinh, vui long nhap lai: ")
    except:
        print("Nhap so hop le")