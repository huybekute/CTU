# Cau1
kq = []
for i in range(100, 301):
  s = str(i)
  if all(int(j) % 2 == 0 for j in s):
    kq.append(s)
print(','.join(kq))