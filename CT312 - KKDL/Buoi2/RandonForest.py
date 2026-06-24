import os
import pandas as pd
import numpy as np
import warnings
import matplotlib.pyplot as plt
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import cross_val_score

warnings.filterwarnings("ignore", category=UserWarning)

nFold = 5
DATA_DIR = "data"
n_estimators = 100

def plot_feature_importance(importances, dataset_name, max_features=10):
    indices = np.argsort(importances)[::-1]
    top_indices = indices[:max_features]
    top_importances = importances[top_indices]
    
    plt.figure(figsize=(10, 5))
    plt.title(f"Top {max_features} thuoc tinh quan trong nhat - {dataset_name}")
    plt.bar(range(len(top_importances)), top_importances, color="skyblue", align="center")
    plt.xticks(range(len(top_importances)), [f"F_{i}" for i in top_indices], rotation=45)
    plt.xlim([-1, len(top_importances)])
    plt.ylabel("Muc do quan trong")
    plt.xlabel("Chi so thuoc tinh")
    plt.tight_layout()
    plt.show()

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
    model = RandomForestClassifier(n_estimators=n_estimators, random_state=42)
    scores = cross_val_score(model, X_cancer, y_cancer, cv=nFold)
    print("Do chinh xac cua mo hinh voi %d-fold: %.3f" % (nFold, np.mean(scores)))
    
    model.fit(X_cancer, y_cancer)
    plot_feature_importance(model.feature_importances_, "Breast Cancer Wisconsin")

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
    model = RandomForestClassifier(n_estimators=n_estimators, random_state=42)
    scores = cross_val_score(model, X_wine, y_wine, cv=nFold)
    print("Do chinh xac cua mo hinh voi %d-fold: %.3f" % (nFold, np.mean(scores)))
    
    model.fit(X_wine, y_wine)
    plot_feature_importance(model.feature_importances_, "Wine")

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
    model = RandomForestClassifier(n_estimators=n_estimators, random_state=42)
    scores = cross_val_score(model, X_digits, y_digits, cv=nFold)
    print("Do chinh xac cua mo hinh voi %d-fold: %.3f" % (nFold, np.mean(scores)))
    
    model.fit(X_digits, y_digits)
    plot_feature_importance(model.feature_importances_, "Handwritten Digits")