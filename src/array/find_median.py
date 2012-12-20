def find_median(a):
    return find_kth_element(a, 0, len(a) - 1, len(a)/2 + 1)

def find_kth_element(a, b, e, k):
    pivot = partition(a, b, e)
    if pivot - b == (k-1):
        return a[pivot]
    elif pivot - b > (k-1):
        return find_kth_element(a, b, pivot - 1, k)
    else:
        return find_kth_element(a, pivot + 1, e, k - (pivot +1 - b))
    
def partition(a, b, e):
    swap(a,(b+e)/2, e)
    print a, b, e
    pivot = a[e]
    end = e
    e = e - 1
    while(b <= e):
        while a[b] < pivot:
            b = b+1
        while a[e] > pivot:
            e = e-1
        if b <= e:
            swap(a, b, e)
            b = b+1; e = e-1
    swap(a, b, end)
    return b

def swap(a, i, j):
    tmp = a[i]
    a[i] = a[j]
    a[j] = tmp

a = [3,4,5,2,7,6,1,8]
print find_median(a)

    