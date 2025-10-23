from collections import Counter
from math import log2
import numpy as np
def findEntropy(data):
    soLanXuatHien = Counter(data)
    tongPhanTu = len(data)
    entropy = 0.0

    for dem in soLanXuatHien.values():
        xs = dem / tongPhanTu
        if xs > 0:
            entropy -= xs * log2(xs)
    return entropy


# CC : cung chat
# KC : khac chat

# Rut 2 trong 8 => 8C2 = 28 cach

PX_CC = 4/28
PX_KC = 24/28
PX = np.array([PX_CC, PX_KC])

# PY khi X = CC
PY_CC = np.array([1/4, 1/2, 1/4, 0])
PY_KC = np.array([1/8, 3/8, 3/8, 1/8])

H_X = findEntropy(PX)
PY = PY_CC * PX_CC + PY_KC * PX_KC

H_X_Y = 0.0
for i in range(4):
    if(PY[i] > 0):
        P_CC_Yi = (PY_CC[i] * PX_CC) / PY[i]
        P_KC_Yi = (PY_KC[i] * PX_KC) / PY[i]

        PX_Yi = np.array([P_CC_Yi, P_KC_Yi])

        H_X_Yi = findEntropy(PX_Yi)
        H_X_Y += H_X_Yi * PY[i]

I_X_Y = H_X - H_X_Y

print(f"Luong tin: I(X, Y) la {round(I_X_Y, 4)}")