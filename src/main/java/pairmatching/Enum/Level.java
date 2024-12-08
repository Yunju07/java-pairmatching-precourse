package pairmatching.Enum;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static Level getLevel(String levelName) {
        for (Level level : Level.values()) {
            if (level.name.equals(levelName)) {
                return level;
            }
        }
        throw new IllegalArgumentException("Invalid level name: " + levelName);
    }

}

