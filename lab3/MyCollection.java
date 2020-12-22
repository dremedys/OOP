package lab3;

public interface MyCollection {
	boolean add(Object o);
	boolean remove(Object o);
	void clear();
	boolean hasIntersection(MyCollection mc);
	boolean isEmpty();
	int size();
	MyCollection difference(MyCollection mc);
	boolean exists(Object o);
	void swap(Object o,Object g);
	void print();
	
	
	
}
