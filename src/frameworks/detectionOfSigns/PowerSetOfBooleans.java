package frameworks.detectionOfSigns;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by PatrickKasting on 20/11/15.
 */
public class PowerSetOfBooleans {

    private final Set<Boolean> booleans;

    public PowerSetOfBooleans() {
        this.booleans = new HashSet<>();
    }

    public PowerSetOfBooleans(Set<Boolean> booleans) {
        this.booleans = booleans;
    }

    public PowerSetOfBooleans(boolean bool) {
        Set<Boolean> singleton = new HashSet<>();
        singleton.add(bool);
        this.booleans = singleton;
    }

    public Set<Boolean> getBooleans() {
        return Collections.unmodifiableSet(booleans);
    }

    @Override
    public String toString() {
        String result = "{";
        for (Boolean bool : this.booleans) {
            if (bool) {
                result += "tt ";
            } else {
                result += "ff ";
            }
        }
        if (result.charAt(result.length() - 1) == ' ') {
            result = result.substring(0, result.length() - 1);
        }
        return result + "}";
    }
}
