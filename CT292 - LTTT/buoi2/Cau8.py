# Cau 8
input8 = input("Nhap chuoi: ")
dem8 = {}
for i in input8:
  if i in dem8:
    dem8[i] += 1
  else:
    dem8[i] = 1
print(dem8)