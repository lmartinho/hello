#  b - d
# /    |
#a     e
# \  /
#  c 

# The graph spec
graph = {
    'a': ['b', 'c'],
    'b': ['d'],
    'c': [],
    'd': ['e'],
    'e': []
}

# Compute the shortest path recursively
def shortest_path(node1, node2):
    if (node1 == node2):
        return [node2]
    
    min_len = None
    shortest = []
    for node in graph[node1]:
        path = shortest_path(node, node2)
        if not path: continue

        path_length = len(path)
        # Initialize min_length
        if not min_len:
            min_len = path_length
            shortest = path
        # New minimum
        elif path_length < min_len:
            min_len = path_length
            shortest = path

    # If there's a valid path, return the current node concatenated with the shortest path
    if shortest:
        return [node1] + shortest

print(shortest_path('a', 'e'))
