# Cau 7
class Nodes:
  def __init__ (self, probability, symbol, left=None, right=None):
    self.probability = probability
    self.symbol = symbol
    self.left = left
    self.right = right
    self.code = ""

# CAU8
def CalculateProbability(data):
  dictRs = {}
  for i in data:
    if i in dictRs:
      dictRs[i] += 1
    else:
      dictRs[i] = 1
  return dictRs

# Cau 9
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

# Cau 10
def HuffmanEncoding(the_data):
  global the_codes       # Cho phép dùng biến toàn cục
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

# Cau 11
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

#Cau 12
the_data = "AAAAAAABBCCCCCCDDDEEEEEEEEE"
HuffmanEncoding(the_data)

#Cau 13
the_data1 = "DDDMMMMKKKKKZLAAAAXYTTTTT"
HuffmanEncoding(the_data1)