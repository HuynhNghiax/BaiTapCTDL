package task1_2;

import java.util.ArrayList;
import java.util.Collection;

public class Test {
public static <E> void main(String[] args) {
	BST<Integer> b1 = new BST<>();
		b1.add(2);
		b1.add(3);
		b1.add(1);
		b1.add(-2);
		b1.add(0);
		b1.add(4);
		b1.add(5);
	System.out.println(b1);
	Collection<Integer> numbers = new ArrayList<>();
    numbers.add(50);
    numbers.add(30);
    numbers.add(70);
    numbers.add(20);
    numbers.add(40);
    numbers.add(60);
    numbers.add(80);
    b1.add(numbers);
    System.out.println(b1);
    System.out.println(b1.depth(20));
    System.out.println(b1.height());
    System.out.println(b1.size());
    System.out.println(b1.contains(30));
    System.out.println(b1.findMin());
    System.out.println(b1.findMax());
    System.out.println(b1.remove(2));
    System.out.println(b1.descendants(40));
    System.out.println(b1.ancestors(0));
    b1.inorder();
    System.out.println();
    b1.preorder();
    System.out.println();
    b1.postorder();;
}
}
