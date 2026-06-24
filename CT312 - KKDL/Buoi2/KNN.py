import os
import pandas as pd
import numpy as np
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import cross_val_score

nFold = 5
k_values = [1, 2, 3, 4, 5]

DATA_DIR = "data"

#Breast Cancer Wisconsin

print("1. Breast Cancer Wisconsin")

BCW_file_path = os.path.join(DATA_DIR, "breast_cancer", "wdbc.data")

if os.path.exists(BCW_file_path):
    df_cancer = pd.read_csv(BCW_file_path, header=None)
    y_cancer = df_cancer[1].map({'M': 1, 'B': 0}) 
    X_cancer = df_cancer.iloc[:, 2:] 
    
    print("thong ke mo ta du lieu")
    print(X_cancer.describe())
    print("\nKiem tra xem du lieu co bi thieu (NULL) khong?")
    print(X_cancer.isnull().sum().sum())
    
    print("\nDanh gia mo hinh")
    for k in k_values:
        model = KNeighborsClassifier(n_neighbors=k)
        scores = cross_val_score(model, X_cancer, y_cancer, cv=nFold)
        print("Do chinh xac cua mo hinh voi k = %d va %d-fold: %.3f" % (k, nFold, np.mean(scores)))


#Wine
print("2. Wine")

wine_file_path = os.path.join(DATA_DIR, "wine", "wine.data")

if os.path.exists(wine_file_path):
    df_wine = pd.read_csv(wine_file_path, header=None)
    y_wine = df_wine[0]
    X_wine = df_wine.iloc[:, 1:]
    
    print("thong ke mo ta du lieu")
    print(X_wine.describe())
    print("\nKiem tra xem du lieu co bi thieu (NULL) khong?")
    print(X_wine.isnull().sum().sum())
    
    print("\nDanh gia mo hinh")
    for k in k_values:
        model = KNeighborsClassifier(n_neighbors=k)
        scores = cross_val_score(model, X_wine, y_wine, cv=nFold)
        print("Do chinh xac cua mo hinh voi k = %d va %d-fold: %.3f" % (k, nFold, np.mean(scores)))


#Optical recognition of handwritten digits
print("3. Optical recognition of handwritten digits")

digits_file_path = os.path.join(DATA_DIR, "handwritten", "optdigits.tra") 
if os.path.exists(digits_file_path):
    df_digits = pd.read_csv(digits_file_path, header=None)
    
    X_digits = df_digits.iloc[:, :-1] 
    y_digits = df_digits.iloc[:, -1]  
    print("thong ke mo ta du lieu")
    print(X_digits.describe())
    print("\nKiem tra xem du lieu co bi thieu (NULL) khong?")
    print(X_digits.isnull().sum().sum())
    
    print("\nDanh gia mo hinh")
    for k in k_values:
        model = KNeighborsClassifier(n_neighbors=k)
        scores = cross_val_score(model, X_digits, y_digits, cv=nFold)
        print("Do chinh xac cua mo hinh voi k = %d va %d-fold: %.3f" % (k, nFold, np.mean(scores)))