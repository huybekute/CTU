import pandas as pd
import numpy as np
from numpy import log2 as log
import pprint
eps = np.finfo(float).eps

def find_entropy(df):
    target = df.keys()[-1]
    entropy = 0
    values = df[target].unique()
    for value in values:
        fraction = df[target].value_counts()[value]/len(df[target])
        entropy += -fraction*np.log2(fraction)
    return entropy

def average_information(df, attribute):
    target = df.keys()[-1]
    target_variables = df[target].unique()
    variables = df[attribute].unique()
    entropy2 = 0
    for variable in variables:
        entropy = 0
        for target_variable in target_variables:
            num = len(df[attribute][df[attribute] == variable][df[target] == target_variable])
            den = len(df[attribute][df[attribute] == variable])
            fraction = num/(den+eps)
            entropy += -fraction*log(fraction+eps)
        fraction2 = den/len(df)
        entropy2 += -fraction2 * entropy
    return abs(entropy2)

def find_winner(df):
    IG = []
    for key in df.keys()[:-1]:
        IG.append(find_entropy(df)-average_information(df, key))
    return df.keys()[:-1][np.argmax(IG)]

def get_subtable(df, node, value):
    return df[df[node] == value].reset_index(drop = True)

def build_tree(df, tree = None):
    target = df.keys()[-1]
    node = find_winner(df)
    attValue = np.unique(df[node])
    if tree is None:
        tree = {}
        tree[node] = {}
    for value in attValue:
        subtable = get_subtable(df, node, value)
        clValue, count = np.unique(subtable[target], return_counts=True)

        if len(count) == 1:
            tree[node][value] = clValue[0]
        else:
            tree[node][value] = build_tree(subtable)

    return tree

def print_information_gain(df):
    root_entropy = find_entropy(df)    
    for key in df.keys()[:-1]:
        gain = root_entropy - average_information(df, key)
        print(f"information gain cua {key}: {gain:.4f}")


file_test = pd.read_csv(r'https://raw.githubusercontent.com/ltdaovn/dataset/refs/heads/master/play_tennis.csv')
file_test = file_test.drop('day', axis=1)
print(file_test)

print(file_test.columns)
file_test.describe()
tree = build_tree(file_test)
pprint.pprint(tree)

a = find_entropy(file_test)
print(f"entropy: {a:.4f}")
print_information_gain(file_test)