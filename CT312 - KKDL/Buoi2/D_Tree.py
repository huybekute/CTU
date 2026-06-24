import os
import pandas as pd
import numpy as np
import warnings
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import cross_val_score

warnings.filterwarnings("ignore", category=UserWarning)

nFold = 5
DATA_DIR = "data"

criteria = ['gini', 'entropy']
min_samples_splits = [2, 5, 10]

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
    for criterion in criteria:
        for min_split in min_samples_splits:
            model = DecisionTreeClassifier(criterion=criterion, min_samples_split=min_split, random_state=42)
            scores = cross_val_score(model, X_cancer, y_cancer, cv=nFold)
            print("Ham phan hoach: %s | Min split: %d | Do chinh xac: %.3f" % (criterion, min_split, np.mean(scores)))

print("\n2. Wine")
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
    for criterion in criteria:
        for min_split in min_samples_splits:
            model = DecisionTreeClassifier(criterion=criterion, min_samples_split=min_split, random_state=42)
            scores = cross_val_score(model, X_wine, y_wine, cv=nFold)
            print("Ham phan hoach: %s | Min split: %d | Do chinh xac: %.3f" % (criterion, min_split, np.mean(scores)))

print("\n3. Optical recognition of handwritten digits")
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
    for criterion in criteria:
        for min_split in min_samples_splits:
            model = DecisionTreeClassifier(criterion=criterion, min_samples_split=min_split, random_state=42)
            scores = cross_val_score(model, X_digits, y_digits, cv=nFold)
            print("Ham phan hoach: %s | Min split: %d | Do chinh xac: %.3f" % (criterion, min_split, np.mean(scores)))