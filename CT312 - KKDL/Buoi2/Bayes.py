import os
import pandas as pd
import numpy as np
import warnings
from sklearn.naive_bayes import GaussianNB
from sklearn.model_selection import cross_val_predict
from sklearn.metrics import confusion_matrix, accuracy_score

warnings.filterwarnings("ignore", category=UserWarning)

nFold = 5
DATA_DIR = "data"

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
    model = GaussianNB()
    y_pred = cross_val_predict(model, X_cancer, y_cancer, cv=nFold)
    
    acc = accuracy_score(y_cancer, y_pred)
    cm = confusion_matrix(y_cancer, y_pred)
    
    print("Do chinh xac (Accuracy): %.3f" % acc)
    print("Ma tran nham lan (Confusion Matrix):")
    print(cm)

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
    model = GaussianNB()
    y_pred = cross_val_predict(model, X_wine, y_wine, cv=nFold)
    
    acc = accuracy_score(y_wine, y_pred)
    cm = confusion_matrix(y_wine, y_pred)
    
    print("Do chinh xac (Accuracy): %.3f" % acc)
    print("Ma tran nham lan (Confusion Matrix):")
    print(cm)

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
    model = GaussianNB()
    y_pred = cross_val_predict(model, X_digits, y_digits, cv=nFold)
    
    acc = accuracy_score(y_digits, y_pred)
    cm = confusion_matrix(y_digits, y_pred)
    
    print("Do chinh xac (Accuracy): %.3f" % acc)
    print("Ma tran nham lan (Confusion Matrix):")
    print(cm)