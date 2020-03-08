def fizz_buzz(max):
    return [fun(x) for x in range(1, max)]

def fun(x):
    res = []
    if x % 3 == 0:
        res.append('fizz')
    if x % 5 == 0:
        res.append('buzz')
    if not res:
        res.append('%d' % x)
    return ' '.join(res)

print(fizz_buzz(25))