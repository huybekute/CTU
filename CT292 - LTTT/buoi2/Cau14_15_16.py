# Cau14
list14_1 = ["ab", "cbs", "abd"]
list14_2 = ["abx", "cbsllzz", "pre", "abhuydz"]


def getsuffix(a, b):
  suf = set()
  for s1 in a:
    for s2 in b:
      if s2.startswith(s1) and s1 != s2:
        suffix = s2[len(s1):]
        if suffix:
          suf.add(suffix)
      elif s1.startswith(s2) and s1 != s2:
        suffix = s1[len(s2):]
        if suffix:
          suf.add(suffix)
  return suf

print(getsuffix(list14_1, list14_2))

# Cau 15
def kiemtrabangma(a):
  s15_0 = set(a)
  s15_1 = getsuffix(s15_0, s15_0)
  vt = set(s15_1)


  if s15_1.intersection(s15_0):
    print("bảng mã ko tách được")
    return

  sn_15 = None
  while s15_1:
    s15_2 = getsuffix(s15_0, s15_1) | getsuffix(s15_1, s15_0)
    s15_temp = s15_2.intersection(s15_0)
    if not s15_2:
      print("bang ma tach duoc")
      return
    elif s15_temp:
      print("bang ma ko tach duoc")
      return
    elif s15_2 == sn_15:
      print("bag ma ko tach duoc")
      return

    s15_2 -= vt
    if not s15_2:
      print("bang ma ko tach duoc")
      return
    vt |= s15_2
    sn_15 = s15_2
    s15_1 = s15_2
  print("bang ma tach duoc")

a1 = ["0", "10", "110", "111"]
a2 = ["0", "01", "011"]
kiemtrabangma(a2)

# Cau 16
a = ["abc","a","ab","b","bcad"]
b = ["a", "ad","bbcde", "c", "deb","ebd"]
c = ["a", "ad","bbcde", "c", "deb","ebad"]
kiemtrabangma(a)
kiemtrabangma(b)
kiemtrabangma(c)