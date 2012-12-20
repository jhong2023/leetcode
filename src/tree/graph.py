x = -1
graph = [[x,4,2,3,x,x,x,x,x,x],
         [x,x,x,x,10,9,x,x,x,x],
         [x,x,x,x,6,7,10,x,x,x],
         [x,x,x,x,x,3,8,x,x,x],
         [x,x,x,x,x,x,x,4,8,x],
         [x,x,x,x,x,x,x,9,6,x],
         [x,x,x,x,x,x,x,5,4,x],
         [x,x,x,x,x,x,x,x,x,8],
         [x,x,x,x,x,x,x,x,x,4],
         [x,x,x,x,x,x,x,x,x,x]];

nodes = range(10)
edges = {}
degrees = {}

for i in range(len(graph)):
    for j in range(len(graph[0])):
        if graph[i][j] != x:
            if edges.has_key(i):
                edges[i].append(j)
            else:
                edges[i] = [j]
            if degrees.has_key(j):
                degrees[j] = degrees[j] + 1
            else:
                degrees[j] = 1
            
res = []
queue = []
for n in nodes:
    if not degrees.has_key(n):
        res.append(n)
        queue.append(n)
     
while queue:
    n1 = queue.pop(0)
    if edges.has_key(n1):
        for n2 in edges[n1]:
            degrees[n2] = degrees[n2] - 1
            if degrees[n2] == 0:
                res.append(n2)
                queue.append(n2)
                del degrees[n2]

path = [0] * len(res)
for i in range(len(res)):
    n1 = res[i]
    if edges.has_key(n1):
        for n2 in edges[n1]:
            path[n2] = max(path[n2], path[n1] + graph[n1][n2])
print path
    


            
    
