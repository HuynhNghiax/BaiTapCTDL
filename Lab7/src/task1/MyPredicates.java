package task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		List<T> list = new ArrayList<>();
		for (T t : coll) {
			if (p.test(t))
				list.add(t);
		}
		coll.clear();
		coll.addAll(list);
	}

	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		List<T> list = new ArrayList<>();
		for (T t : coll) {
			if (!p.test(t))
				list.add(t);
		}
		coll.clear();
		coll.addAll(list);
	}

	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> re = new HashSet<T>();
		for (T t : coll) {
			if (p.test(t))
				re.add(t);
		}
		return re;
	}

	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int index = 0;
		for (T t : coll) {
			if (p.test(t)) {
				return index;
			}
			index++;
		}
		return -1;
	}
}
