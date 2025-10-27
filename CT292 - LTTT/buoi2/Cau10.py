# Cau10
while True:
  input10 = input("Nhap chuoi: ")
  if(len(input10) >= 2):
    break
  print("Chuoi khong hop le")


chuoi10_1 = input10[:2]
chuoi10_2 = input10[-2:]
chuoi10_kq = chuoi10_1+chuoi10_2
print(chuoi10_kq)