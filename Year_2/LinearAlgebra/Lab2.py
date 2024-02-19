X = [[2, 3, 4],
    [3 , 1, 5],
    [1 , 3, 4]]

Y = [[3, 4, 1],
    [7, 2, 4],
    [3, 8, 6]]

ans = [[0, 0, 0],
       [0, 0, 0],
       [0, 0, 0]]

def matrixMultiply(X, Y) :
    for i in range(len(X)):
        for j in range(len(Y[0])):
            for k in range(len(Y)):
                ans[i][j] += X[i][k] * Y[k][j]

def matrixTranspose(M) :
    ans = [[0, 0, 0],
           [0, 0, 0],
           [0, 0, 0]]
    
    for i in range(len(M)) :
        for j in range(len(M[0])) :
            ans[j][i] = M[i][j]
    return (ans)

def matrixMinor(m,i,j):
    return ([row[:j] + row[j + 1:] for row in (m[:i] + m[i + 1:])])

def matrixDeternminant(m):
    if len(m) == 2:
        return (m[0][0] * m[1][1] - m[0][1] * m[1][0])

    det = 0
    for c in range(len(m)):
        det += ((-1) ** c) * m[0][c] * matrixDeternminant(matrixMinor(m, 0, c))
    return (det)

matrixMultiply(X, Y)
ans = matrixTranspose(ans)

for r in ans :
    print(r)

print(matrixDeternminant(ans))
