def min_path(tria):
    if not tria: return None
    res = []
    res = tria[0]
    for i in range(1, len(tria)):
        tmp_res = []
        tmp_res.append(res[0] + tria[i][0])
        for j in range(1, i):
            tmp_res.append(min(res[j-1], res[j]) + tria[i][j])
        tmp_res.append(res[-1] + tria[i][-1])
        res = tmp_res[:]
    
    m = None
    for i in res:
        if not m:
            m = i
        else:
            m = min(i, m)
    return m

t = [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

print t
print min_path(t)      