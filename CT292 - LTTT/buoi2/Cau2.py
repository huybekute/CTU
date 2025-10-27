# Cau2
num = input("Nhap day so cach nhau boi dau ',' ")
list_num = num.split(",")
odd_num = [x for x in list_num if int(x.strip()) % 2 != 0]
print(','.join(odd_num))
