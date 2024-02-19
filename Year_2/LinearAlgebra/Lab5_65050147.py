def gaussian_elimination(A, b):
    n = len(A)
    augmented_matrix = [row + [bi] for row, bi in zip(A, b)]

    # forward page
    for pivot_row in range(n):
        pivot = augmented_matrix[pivot_row][pivot_row]

        for j in range(pivot_row, n + 1):
            augmented_matrix[pivot_row][j] /= pivot

        for i in range(pivot_row + 1, n):
            factor = augmented_matrix[i][pivot_row]
            for j in range(pivot_row, n + 1):
                augmented_matrix[i][j] -= factor * augmented_matrix[pivot_row][j]

    # Backward phase
    x = [0] * n
    for i in range(n - 1, -1, -1):
        x[i] = augmented_matrix[i][n]
        for j in range(i + 1, n):
            x[i] -= augmented_matrix[i][j] * x[j]
    return x

# Example usage:
A = [[1, -1, 1],
     [1, 3, 2],
     [3, 2, 4]]

b = [4, 7, 8]

print(gaussian_elimination(A, b))
#65050147 Jeeranai Chawsarn