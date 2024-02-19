class BinaryTreeNode:
  def __init__(self, data):
    self.data = data
    self.leftChild = None
    self.rightChild = None
    
def insert(root, newValue):
    if root is None:
        root = BinaryTreeNode(newValue)
        return root
    
    if newValue < root.data:
        root.leftChild = insert(root.leftChild, newValue)
    else:
        root.rightChild = insert(root.rightChild, newValue)
    return root

def preorder(root):
        if root==None:
            return
        print(root.data)
        preorder(root.leftChild)
        preorder(root.rightChild)

def inorder(root):
        if root==None:
            return
        inorder(root.leftChild)
        print(root.data)
        inorder(root.rightChild)   

def postorder(root):
        if root==None:
            return
        postorder(root.leftChild)
        postorder(root.rightChild)
        print(root.data)
                
root= insert(None, 'J')
insert(root, 'E')
insert(root, 'R')
insert(root, 'A')
insert(root, 'N')
insert(root, 'I')
print("Pre-order :")
preorder(root)
print("In-order :")
inorder(root)
print("Post-order :")
postorder(root)