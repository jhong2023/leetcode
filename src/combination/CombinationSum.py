def solve(a, target):
    if target == 0:
        return [[]]
    if target < 0:
        return []
    res = []
    for i in range(0, len(a)):
        for tmp in solve(a[i + 1:], target - a[i]):
            tmp.append(a[i])
            res.append(tmp)
    return res

print solve([1,2,3], 3)
