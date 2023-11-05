package study_enum;

import java.util.EnumMap;
import java.util.Map.Entry;

public class EnumMapExample {

    private enum Rank {
        FIRST("1등"),
        SECOND("2등"),
        THIRD("3등");

        private final String message;

        Rank(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

    public static void main(String[] args) {
        EnumMap<Rank, Integer> enumMap = getRankIntegerEnumMap();
        enumMap.put(Rank.FIRST, enumMap.getOrDefault(Rank.FIRST, 0) + 1);
        enumMap.put(Rank.FIRST, enumMap.getOrDefault(Rank.FIRST, 0) + 1);
        enumMap.put(Rank.FIRST, enumMap.getOrDefault(Rank.FIRST, 0) + 1);

        for (Entry<Rank, Integer> entry : enumMap.entrySet()) {
            Rank key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key = " + key + ", value = " + value);
        }
    }

    private static EnumMap<Rank, Integer> getRankIntegerEnumMap() {
        EnumMap<Rank, Integer> enumMap = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            enumMap.put(rank, 0);
        }
        return enumMap;
    }

}
