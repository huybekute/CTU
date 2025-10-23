from collections import Counter
from math import log2
def findEntropy(data):
    soLanXuatHien = Counter(data)
    tongPhanTu = len(data)
    entropy = 0.0

    for dem in soLanXuatHien.values():
        xs = dem / tongPhanTu
        if xs > 0:
            entropy -= xs * log2(xs)
    return entropy
data1 = ['A', 'A', 'A', 'B']
data2 = ['A', 'C', 'F', 'Z']
print(f"Entropy cua data1 la: {round(findEntropy(data1), 3)} bits")
print(f"Entropy cua data2 la: {round(findEntropy(data2), 3)} bits")
