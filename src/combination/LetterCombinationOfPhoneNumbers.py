pt = ('abc', 'def', 'ghi')

class Trie:
    def __init__(self):
        self.children = {}
        self.isWord = False
        
    def insert(self, str):
        if not str:
            self.isWord = True
            return
        key = str[0]
        child = None
        if self.children.has_key(key):
            child = self.children[key]
        else:
            child = Trie()
            self.children[key] = child
        child.insert(str[1:])
    
    def getSuggestions(self, str, prefix):
        if str:
            key = str[0]
            if self.children.has_key(key):
                return self.children[key].getSuggestions(str[1:], prefix + key)
            return []
        results = []
        for w in self.getWords(prefix):
            results.append(str + w)
        return results

    def getWords(self, prefix):
        words = []
        if (self.isWord):
            words.append(prefix)
        if self.children:
            for k in self.children.keys():
                words.extend(self.children[k].getWords(prefix + k))
        return words

t = Trie()
t.insert("abc")
t.insert("abd")
t.insert("ade")

for w in t.getSuggestions("ab", ""):
    print w
                

def getLetterCombinations(array):
    results = [""]
    for a in array:
        tmp = []
        for s in results:
            for c in pt[a-1]:
                tmp.append(s + c)
        results = tmp
    return results

def printLetterCombinations():
    count = 0
    for r in getLetterCombinations([1, 2, 3]):
        count = count + 1
        print r
    print count
                        