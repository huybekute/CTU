# 1. Viết hàm hoán đổi 2 ký tự đầu tiên của 2 chuỗi đơn và sinh ra chuỗi mới từ 2 chuỗi kết quả (cách nhau bằng khoảng trắng).

a1 = input("Nhap chuoi thu nhat: ")
b1 = input("Nhap chuoi thu hai: ")

def swap2(a, b):
    a_new = a[:2] + b[2:] 
    b_new = b[:2] + a[2:]

    print(f"{a_new} {b_new}")

swap2(a1, b1)

# 2. Viết hàm loại bỏ các ký tự tại vị trí index chẵn của một chuỗi cho trước
a2 = input("Nhap chuoi: ")
def eliminate_index(a):
    print(a[1::2])
eliminate_index(a2)

#3. Viết hàm đếm số lần xuất hiện của các từ trong câu
a3 = input("Nhap cau: ")
def count_word(a):
    L = []
    k = ""
    for i in  a:
        if i!= " ":
            k = k+i
        else:
            L.append(k)
            k = ""
    if(k!= ""):
        L.append(k)
    
    d = {}
    for w in L:
        if w in d:
            d[w] += 1
        else: 
            d[w] = 1
    print(d)

count_word(a3)

#4. Viết hàm mã hóa một chuỗi bằng cách dịch chuyển các ký tự sang trái 3 bước. Ví dụ: d->a, e->b, f->c
a4 = input("Nhap chuoi: ")
def dich_chuyen_ky_tu(a):
    a_new_4 = ""
    for i in a:
        i = chr(ord(i) - 3)
        a_new_4 += i
    print(a_new_4)

dich_chuyen_ky_tu(a4)

#5. Viết hàm kiểm tra một chuỗi hợp lệ hay không? (có được sinh từ bộ chữ cái nhập) Vídụ: bộ chữ cái nhập S = {0,1,2}
S5 = input("Nhap bo chu cai: ")
a5 = input("Nhap chuoi: ")

def kiem_tra_chuoi(st, S):
    for c in st:
        if c not in S:
            return False
    return True

if kiem_tra_chuoi(a5, S5):
    print("Chuoi hop le")
else:
    print("Chuoi khong hop le")

# 6. Viết hàm chuyển một chuỗi thành danh sách
a6 = input("Nhap chuoi: ")
def chuyen_chuoi_thanh_danh_sach(a):
    L = []
    k = ""
    for i in a:
        if i != " ":
            k=k+i
        else: 
            L.append(k)
            k = ""
    if(k!= ""):
        L.append(k)

    print(L)
chuyen_chuoi_thanh_danh_sach(a6)

# 7. Viết hàm in ra ký tự không lặp lại đầu tiên trong chuỗi Ví dụ:
a7 = input("Nhap chuoi: ")
def kiemtrakhonglaplai(a):
    for c in a:
        if a.count(c) == 1:
            print("ky tu khong lap dau tien:", c)
            break
kiemtrakhonglaplai(a7)

# 8. Viết hàm loại bỏ khoảng trắng trong chuỗi cho trước:
a8 = input("Nhap chuoi: ")
def loai_bo_khoang_trang(a):
    return a.replace(" ", "")
print(loai_bo_khoang_trang(a8))

# 9. Viết hàm in ra từ được lặp lại đầu tiên trong chuỗi
a9 = input("Nhap chuoi: ")
def tu_lap_dau_tien(s):
    d = set()
    for w in s.split():
        if w in d:
            return w
        d.add(w)
    return False

print(tu_lap_dau_tien(a9))

# 10.Viết hàm tìm độ dài tối đa của chuỗi con gồm các số 0 liên tiếp trong chuỗi nhị phân cho trước.
a10 = input("Nhap chuoi nhi phan: ")
def do_dai_toi_da(a):
    max = 0
    dem = 0
    for i in a:
        if(i == '0'):
            dem = dem+1
        else:
            if(max < dem):
                max = dem
            dem = 0
    if max < dem:
        max = dem
    return max

print(do_dai_toi_da(a10))

