def inorder(start):
  if start!=None:
    inorder(node[start][0])
    print(chr(start+ord('A')),end='')
    inorder(node[start][1])

def preorder(start):
  if start!=None:
    print(chr(start+ord('A')),end='')
    preorder(node[start][0])
    preorder(node[start][1])

def postorder(start):
  if start!=None:
    postorder(node[start][0])
    postorder(node[start][1])
    print(chr(start+ord('A')), end='')

n = int(input())
node = [[]for _ in range(n)]
#각 원소 (leftnode,right node)
for _ in range(n):
  l = list(map(str,input().split()))
  l = [ord(j)-ord('A') if j!='.' else None for j in l]
  node[l[0]].append(l[1])
  node[l[0]].append(l[2])

preorder(0)
print()
inorder(0)
print()
postorder(0)