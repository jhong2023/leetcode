
def getPath(s1, s2):
    visited = []
    rpath = {}
    q = []
    q.append(s1)
    while q:
        s3 = q.pop(0)
        visited.append(s3)
        if s2 == s3:
            return getReversePath(s1, s2, rpath)
        for s4 in getOneEditWords(s3):
            if s4 in visited:
                continue
            rpath[s4] = s3
            q.append(s4)

chars = ('a', 'b', 'c', 'd', 'e') 
       
def getOneEditWords(s):       
    res = []
    for i in range(0, len(s)):
        tmp = s[i]
        for c in chars:
            if (tmp != c):
                s[i] = c
                if (isWord(s)):
                    res.append(s)
        s[i] = tmp
    return res

def getReversePath(s1, s2, rpath):
    s3 = rpath[s2]
    res = [s3]
    if s3 == s1:
        return res
    res.extend(getReversPath(s1, rpath[s2], rpath))
    return res