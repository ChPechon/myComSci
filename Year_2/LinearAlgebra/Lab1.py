X = [[1, 2, 3],
    [2 , 2, 3],
    [3 , 2, 3]]

Y = [[3, 2, 1],
    [3, 2, 2],
    [3, 2, 3]]

ans = [[0, 0, 0],
       [0, 0, 0],
       [0, 0, 0]]

for i in range(len(X)):
    for j in range(len(Y[0])):
        for k in range(len(Y)):
            ans[i][j] += X[i][k] * Y[k][j]

for r in ans:
    print(r)