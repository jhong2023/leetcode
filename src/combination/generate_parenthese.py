def gen_par(n, m, output):
    if n == 0 and m == 0:
        print output
    if n > 0:
        gen_par(n - 1, m + 1, output + '(')
    if m > 0:
        gen_par(n, m - 1, output + ')')

gen_par(3, 0, '')