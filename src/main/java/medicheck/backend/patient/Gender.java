package medicheck.backend.patient;

import java.util.HashMap;
import java.util.Map;

public enum Gender {
    Male,
    Female;

    private int value;

    private static Map map = new HashMap<>();

    static {
        for ( Gender gender : Gender.values()) {
            map.put(gender.value, gender);
        }
    }

    public static Gender valueOf(int gender) {
        return (Gender) map.get(gender);
    }
}
