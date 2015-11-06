package frameworks;

import java.util.HashSet;
import java.util.Set;

public class Util {
	public static <T> HashSet<T> Union(Set<T> a, Set<T> b) {
		HashSet<T> result = new HashSet<>();
		result.addAll(a);
		result.addAll(b);
		return result;
	}
}
