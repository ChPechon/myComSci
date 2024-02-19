import sys # for INT_MAX
 
class Graph():
    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[0 for column in range(vertices)]
                      for row in range(vertices)]
 
    def printMST(self, parent):
        print("Edge \tWeight")
        for i in range(1, self.V):
            print(parent[i], "-", i, "\t", self.graph[i][parent[i]])
 
    def minKey(self, key, mstSet):
        # Initialize min value
        min = sys.maxsize
 
        for v in range(self.V):
            if key[v] < min and mstSet[v] == False:
                min = key[v]
                min_index = v
        return min_index
 
    def primMST(self):
        key = [sys.maxsize] * self.V
        parent = [None] * self.V  # Array to store constructed MST
        # Make key 0 so that this vertex is picked as first vertex
        key[0] = 0
        mstSet = [False] * self.V

        parent[0] = -1  # First node is always the root of
 
        for cout in range(self.V):
 
            u = self.minKey(key, mstSet)
            mstSet[u] = True
 
            for v in range(self.V):
                if self.graph[u][v] > 0 and mstSet[v] == False \
                and key[v] > self.graph[u][v]:
                    key[v] = self.graph[u][v]
                    parent[v] = u
 
        self.printMST(parent)
 
# Driver's code
if __name__ == '__main__':
    g = Graph(6)
    g.graph = [[0, 6, 0, 0, 3, 7],
               [6, 0, 5, 2, 4, 0],
               [0, 5, 0, 2, 0, 0],
               [0, 2, 2, 0, 3, 0],
               [3, 4, 0, 3, 1, 8],
               [7, 0, 0, 0, 8, 0]]
    
    g.primMST()