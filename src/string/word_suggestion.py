class Trie:
    def __init__(self):
        self.children = {}
        self.isWord = False
        
    def insert(self, suffix):
        if not suffix:
            self.isWord = True
            return
        key = suffix[0]
        child = None
        if self.children.has_key(key):
            child = self.children[key]
        else:
            child = Trie()
            self.children[key] = child
        child.insert(suffix[1:])
    
    def getSuggestions(self, prefix, pos):
        if pos < len(prefix):
            key = prefix[pos]
            if self.children.has_key(key):
                return self.children[key].getSuggestions(prefix, pos+1)
            return []
        res = []
        if self.isWord:
            res.append(prefix)
        for key in self.children.keys():
            res.extend(self.children[key].getSuggestions(prefix + str(key), pos+1))
        return res


t = Trie()
t.insert("abc")
t.insert("abd")
t.insert("ade")
t.insert("bade")
t.insert("bdfwsdfsd")


print t
for w in t.getSuggestions("bd", 0):
    print w