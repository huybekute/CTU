# Cau 7
vl7 = []
while len(vl7) < 7:
  try:
    num7 = float(input(f"Nhap gia tri thu {len(vl7)+1}: "))
    vl7.append(num7)
  except ValueError:
    print("Gia tri ko hop le")

tuple7 = tuple(vl7)
even_tuple7 = tuple(x for x in tuple7 if x % 2 == 0)
print(even_tuple7)