package frameworks;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Util {
	public static <T> HashSet<T> Union(Set<T> a, Set<T> b) {
		HashSet<T> result = new HashSet<>();
		result.addAll(a);
		result.addAll(b);
		return result;
	}
	
	public static String join(Collection<?> col, String delim) {
	    StringBuilder sb = new StringBuilder();
	    Iterator<?> iter = col.iterator();
	    if (iter.hasNext())
	        sb.append(iter.next().toString());
	    while (iter.hasNext()) {
	        sb.append(delim);
	        sb.append(iter.next().toString());
	    }
	    return sb.toString();
	}
}
