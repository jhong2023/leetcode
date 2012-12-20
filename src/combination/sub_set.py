def sub_set(S):
    if not S: return []
    res = [[]]
    for e in S:
        tmp_res = []
        for r in res:
            copy_r = list(r)
            copy_r.append(e)
            tmp_res.append(copy_r)
        res.extend(tmp_res)
    return res

def sub_set_with_duplication(S):
    if not S: return []
    S.sort()
    res = [[]]
    pre = None
    for e in S:
        tmp_res = []
        dup_e = []           
        if pre and pre == e:
            dup = dup + 1
            if dup > 0:
                dup_e = [e] * (dup + 1)
        else:
            pre = e; dup = 0    
        for r in res:
            copy_r = list(r)
            if dup_e:
                if not copy_r or copy_r[-1] != e:
                    copy_r.extend(dup_e)
                    tmp_res.append(copy_r)
            else:
                copy_r.append(e)
                tmp_res.append(copy_r)
        res.extend(tmp_res)
    return res

print sub_set_with_duplication([1,2, 2])