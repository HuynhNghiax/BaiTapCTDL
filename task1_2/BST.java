package task1_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public void add(E e) {
		root = addRecursive(root, e);
	}

	// Helper method to recursively add an element to the BST
	private BNode<E> addRecursive(BNode<E> node, E e) {
		if (node == null) {
			return new BNode<>(e);
		}

		int comp = e.compareTo(node.getData());

		if (comp == 0) {
			node.setData(e);
		} else if (comp < 0) {
			node.setLeft(addRecursive(node.getLeft(), e));
		} else {
			node.setRight(addRecursive(node.getRight(), e));
		}

		return node;
	}

	// Getter for the root
	public BNode<E> getRoot() {
		return root;
	}

	// Add a collection of elements col into BST

	public void add(Collection<E> col) {
		for (E element : col) {
			add(element);
		}
	}

	// compute the depth of a node in BST
	public int depth(E value) {
		return depthRecursive(root, value, 0);
	}
	private int depthRecursive(BNode<E> node, E value, int currentDepth) {
		if (node == null) {
			System.out.println("không tìm thấy");;
		}

		int compare = value.compareTo(node.getData());

		if (compare == 0) {
			return currentDepth + 1; 
		} else if (compare < 0) {
			return depthRecursive(node.getLeft(), value, currentDepth + 1);
		} else {
			return depthRecursive(node.getRight(), value, currentDepth + 1);
		}
	}

	// compute the height of BST
	public int height() {
		return heightRecursive(root);
	}
	private int heightRecursive(BNode<E> node) {
		if (node == null) {
			return -1; 
		}
		int leftHeight = heightRecursive(node.getLeft());
		int rightHeight = heightRecursive(node.getRight());
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// Compute total nodes in BST
	public int size() {
		return sizeRecursive(root);
	}
	private int sizeRecursive(BNode<E> node) {
		if (node == null) {
			return 0;
		}

		int leftSize = sizeRecursive(node.getLeft());
		int rightSize = sizeRecursive(node.getRight());
		return leftSize + rightSize + 1;
	}

	// Check whether element e is in BST
	public boolean contains(E value) {
		return containsRecursive(root, value);
	}
	private boolean containsRecursive(BNode<E> node, E value) {
		if (node == null) {
			return false;
		}
		int compare = value.compareTo(node.getData());

		if (compare == 0) {
			return true;
		} else if (compare < 0) {
			return containsRecursive(node.getLeft(), value); 
		} else {
			return containsRecursive(node.getRight(), value);
		}
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null) {
			return null; 
		}

		BNode<E> current = root;
		while (current.getLeft() != null) {
			current = current.getLeft();
		}

		return current.getData();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null) {
			return null;
		}

		BNode<E> current = root;
		while (current.getRight() != null) {
			current = current.getRight();
		}

		return current.getData();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		// TODO
		return false;
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
        List<E> descendantsList = new ArrayList<>();
        BNode<E> node = findNode(root, data);

        if (node != null) {
            collectDescendants(node, descendantsList);
        }

        return descendantsList;
    }


    private BNode<E> findNode(BNode<E> node, E value) {
        if (node == null) {
            return null;
        }

        int compare = value.compareTo(node.getData());

        if (compare == 0) {
            return node;
        } else if (compare < 0) {
            return findNode(node.getLeft(), value);
        } else {
            return findNode(node.getRight(), value);
        }
    }
    private void collectDescendants(BNode<E> node, List<E> descendantsList) {
        if (node != null) {
            descendantsList.add(node.getData());
            collectDescendants(node.getLeft(), descendantsList);
            collectDescendants(node.getRight(), descendantsList);
        }
    }
	// get the ancestors of a node
    public List<E> ancestors(E data) {
        List<E> ancestorsList = new ArrayList<>();
        findAncestors(root, data, ancestorsList);
        return ancestorsList;
    }

    // Phương thức hỗ trợ để đệ quy tìm các tổ tiên của nút
    private boolean findAncestors(BNode<E> node, E value, List<E> ancestorsList) {
        if (node == null) {
            return false;
        }

        int compare = value.compareTo(node.getData());

        if (compare == 0) {
            return true; // Nút cần tìm tiền đề xuất đã được tìm thấy
        }

        boolean foundInLeft = findAncestors(node.getLeft(), value, ancestorsList);
        boolean foundInRight = findAncestors(node.getRight(), value, ancestorsList);

        if (foundInLeft || foundInRight) {
            ancestorsList.add(node.getData()); // Thêm giá trị của nút hiện tại nếu nó là một tổ tiên
            return true;
        }

        return false;
    }
    public void inorder() {
        inorderTraversal(root);
    }

    // Phương thức hỗ trợ để đệ quy thực hiện duyệt inorder
    private void inorderTraversal(BNode<E> node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inorderTraversal(node.getRight());
        }
    }
    public void preorder() {
        preorderTraversal(root);
    }

    // Phương thức hỗ trợ để đệ quy thực hiện duyệt preorder
    private void preorderTraversal(BNode<E> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderTraversal(node.getLeft());
            preorderTraversal(node.getRight());
        }
    }
    public void postorder() {
        postorderTraversal(root);
    }

    // Phương thức hỗ trợ để đệ quy thực hiện duyệt postorder
    private void postorderTraversal(BNode<E> node) {
        if (node != null) {
            postorderTraversal(node.getLeft());
            postorderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }


	public String toString() {
		return "root=" + root + "]";
	}

}
