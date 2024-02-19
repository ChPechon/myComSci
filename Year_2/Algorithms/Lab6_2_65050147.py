from collections import deque

def graphDFS(start, adjacency_list, visited):
    visited[start] = True
    print(chr(start + ord('A')), end=' ')
    for neighbor in adjacency_list[start]:
        if not visited[ord(neighbor) - ord('A')]:
            graphDFS(ord(neighbor) - ord('A'), adjacency_list, visited)

def graphBFS(start, adjacency_list):
    visited = [False] * len(adjacency_list)
    queue = deque([start])
    visited[start] = True
    while queue:
        current = queue.popleft()
        print(chr(current + ord('A')), end=' ')
        for neighbor in adjacency_list[current]:
            if not visited[ord(neighbor) - ord('A')]:
                queue.append(ord(neighbor) - ord('A'))
                visited[ord(neighbor) - ord('A')] = True

def printAdjLists(n, adjacency_list):
    for i in range(n):
        print(f"{chr(i + ord('A'))}: ", end='')
        for j in adjacency_list[i]:
            print(j, end=' ')
        print()

def getUserInput():
    n = int(input("Enter the number of vertices in the graph: "))
    adjacency_list = []
    for i in range(n):
        # Input format example for node A: "Enter neighbors for A: G F D B"
        neighbors = input(f"Enter neighbors for {chr(i + ord('A'))}: ").split()
        adjacency_list.append(neighbors)
    return n, adjacency_list

def main():
    n, adjacency_list = getUserInput()

    print("Adjacent Lists:")
    printAdjLists(n, adjacency_list)

    visited = [False] * n
    start_node = 0  # Assuming we always start with the first node (A)
    print("DFS: ", end='')
    graphDFS(start_node, adjacency_list, visited)

    print("\nBFS WITH Queue: ", end='')
    graphBFS(start_node, adjacency_list)

main()