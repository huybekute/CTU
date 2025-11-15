# NGUYEN VAN HOANG HUY - B2308362
import re
import math
from collections import Counter

# Lam sach du lieui
def cleanText(text):
    text = text.lower()
    text = text.replace('\n', ' ').replace('\t', ' ')
    text = re.sub(r"[^a-z0-9.,!?;:'\"()\-\s]", "", text)
    text = re.sub(r"\s+", " ", text).strip()
    return text

# Tinh entropy cu8a cac ky tu don
def unigram(text):
    unigrams = [text[i:i+1] for i in range(len(text))]
    return Counter(unigrams)

def unigramEntropy(text):
    count = Counter(text)
    tong = sum(count.values())
    entropy = 0
    for c, f in count.items():
        p = f / tong
        entropy -= p*math.log2(p)
    return entropy

#bigram
def bigram(text):
    birams = [text[i:i+2] for i in range(len(text)-1)]
    return Counter(birams)

#trigram
def trigram(text):
    trigrams = [text[j:j+3] for j in range(len(text)-2)]
    return Counter(trigrams)

# tinh entropy cho bigram va trigram
def findEntropy(counter):
    total = sum(counter.values())
    entropy = 0
    for seq, freq in counter.items():
        p = freq / total
        entropy -= p * math.log2(p)
    return entropy

# XD ma Huffman
class Nodes:
  def __init__ (self, probability, symbol, left=None, right=None):
    self.probability = probability
    self.symbol = symbol
    self.left = left
    self.right = right
    self.code = ""

def CalculateProbability(data):
  dictRs = {}
  for i in data:
    if i in dictRs:
      dictRs[i] += 1
    else:
      dictRs[i] = 1
  return dictRs

def CalculateCodes(node, value = ''):
  global the_codes
  newValue = value + str(node.code)
  if(node.left):
    CalculateCodes(node.left, newValue)
  if(node.right):
    CalculateCodes(node.right, newValue)
  if(not node.left and not node.right):
    the_codes[node.symbol] = newValue
  return the_codes

def OutputEncoded(the_data, coding):
  encodingOutput = []
  for element in the_data:
    encodingOutput.append(coding[element])

  the_string = ''.join([str(item) for item in encodingOutput])
  return the_string

def TotalGain(the_data, coding):
  beforeCompression = len(the_data) * 8
  afterCompression = 0
  the_symbols = coding.keys()
  for symbol in the_symbols:
    the_count = the_data.count(symbol)
    afterCompression += the_count * len(coding[symbol])
  print(f"spcae uasge before compresstion {beforeCompression}")
  print(f"spcae uasge after compresstion {afterCompression}")

def HuffmanEncoding(the_data):
  global the_codes       
  the_codes = {}
  symbolWithProbs = CalculateProbability(the_data)
  the_symbols = symbolWithProbs.keys()
  the_probabilities = symbolWithProbs.values()
  print(f"symbols: {the_symbols}")
  print(f"probabilities: {the_probabilities}")

  the_nodes =  []

  for symbol in the_symbols:
    the_nodes.append(Nodes(symbolWithProbs.get(symbol), symbol))
  while len(the_nodes) > 1:
    the_nodes = sorted(the_nodes, key=lambda x: x.probability)
    right = the_nodes[0]
    left = the_nodes[1]
    left.code = 0
    right.code = 1

    newNode = Nodes(left.probability + right.probability, left.symbol + right.symbol, left, right)
    the_nodes.remove(left)
    the_nodes.remove(right)
    the_nodes.append(newNode)

  huffmanEncoding = CalculateCodes(the_nodes[0])
  print(f"the symbol wit codes {huffmanEncoding}")
  TotalGain(the_data, huffmanEncoding)
  encodedOutput = OutputEncoded(the_data, huffmanEncoding)
  return encodedOutput, the_nodes[0]

def HuffmanDecoding(encodedData, huffmanTree):
  treeHad = huffmanTree
  decodedOutput = []
  for x in encodedData:
    if x=='1':
      huffmanTree = huffmanTree.right
    elif x=='0':
      huffmanTree = huffmanTree.left
    try:
      if huffmanTree.left.symbol == None and huffmanTree.right.symbol == None:
        pass
    except AttributeError:
      decodedOutput.append(huffmanTree.symbol)
      huffmanTree = treeHad
  string = ''.join([str(item) for item in decodedOutput])
  return string


# tinh do dai tb cua ma Huffman
def averageLength(coding, prob):
    lengthAVG = 0
    for i in coding:
      lengthAVG += prob[i] * len(coding[i])
    return lengthAVG

#nen va giai nen van ban
filePath = "data.txt"
with open(filePath, "r", encoding="utf-8") as f:
    dataFile = f.read()

data = cleanText(dataFile)
#nen van ban
encoded, tree = HuffmanEncoding(data)
print(f"Du lieu sau khi nen: \n{encoded}")

#giai nen
print(f"\nDu lieu sau khi giai nen: \n{HuffmanDecoding(encoded, tree)}")

#so sanh ket qua true or false
print(f"So sanh ket qua: {data == HuffmanDecoding(encoded, tree)}")

#do dai ma tb
probabilities = CalculateProbability(data)
total_chars = sum(probabilities.values())
for k in probabilities:
    probabilities[k] /= total_chars

avgLen = averageLength(the_codes, probabilities)

#bao cao ket qua
print("-----------------------------------------------------------------------")
print("BAO CAO KET QUA")
H_1 = unigramEntropy(data)
print(f"Entro py ky tu doc lap : {round(H_1, 3)}")
H_2 = bigram(data)
print(f"Entropy ky tu co phu thuoc 1 ky tu : {round(findEntropy(H_2)/2, 3)} bits")
H_3 = trigram(data)
print(f"Entropy ky tu co phu thuoc 2 ky tu: {round(findEntropy(H_3)/3, 3)} bits")
print(f"Do dai ma Huffman trubng binh: {round(avgLen, 3)}")
print(f"Hieu suat nen: {round((H_1 / avgLen ) * 100, 2)}%")
print("-----------------------------------------------------------------------")