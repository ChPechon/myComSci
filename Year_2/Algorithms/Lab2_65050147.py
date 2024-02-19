class QuickSort :
    def swap(self, A, i, j) :
        tmp = A[i]
        A[i] = A[j]
        A[j] = tmp

    def sort(self, A) :
        if len(A) == 0 : # recursion null case
            return []
        if len(A) == 1 : # recursion base case
            return [A[0]]
        
        t = 0 # first index
        i = 1 # second index
        p = len(A) - 1 # last index

        while p >= i :
            while i < len(A) and A[t] > A[i] : # i right shifted
                i += 1
            while A[t] < A[p] : # p left shifted
                p -= 1

            if p >= i : # p more than i condition
                self.swap(A, p, i)
        # p less than i will break the loop
        self.swap(A, t, p)

        Left = self.sort(A[t:p])
        Center = [A[p]]
        Right = self.sort(A[p + 1:len(A)])

        return Left + Center + Right
    
class Node:
    def __init__(self, data) :
        self.left = None
        self.right = None
        self.data = data

    def printTree(self) :
        if self.left :
            self.left.printTree()
        if self.right :
            self.right.printTree()

    def insert(self, data) :
        if self.data :
            if data < self.data:
                if self.left is None :
                    self.left = Node(data)
                else :
                    self.left.insert(data)
            elif data > self.data :
                if self.right is None :
                    self.right = Node(data)
                else :
                    self.right.insert(data)
            else :
                self.data = data
        self.printTree()

    def getMax(self, node) :
        if node is None :
            return None
        if node.right is None :
            return node.data
        return self.getMax(node.right)
    
    def getMin(self, node) :
        if node is None :
            return None
        if node.left is None :
            return node.data
        return self.getMin(node.left)
                    
#main
root = Node(12)
root.insert(17)
root.insert(32)
root.insert(75)
root.insert(16)
root.insert(45)
root.insert(39)
root.insert(86)
root.insert(23)
root.insert(14)

print("max value in the binary tree is :", root.getMax(root))
print("min value in the binary tree is :", root.getMin(root))
print()


#main
A = [12, 17, 32, 75, 16, 45, 39, 86, 23, 14]
print("Before sorted :", A)
QS = QuickSort()
Sorted = QS.sort(A)
print("After sorted :", Sorted)