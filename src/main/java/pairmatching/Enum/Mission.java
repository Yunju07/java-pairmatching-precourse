package pairmatching.Enum;

public enum Mission {
    RACINGCAR("자동차경주"),
    LOTTO("로또"),
    NUMBERBASEBALL("숫자야구게임"),
    BASKET("장바구니"),
    PAYMENT("결제"),
    PERFORMANCEIMPROVEMENT("성능개선"),
    DEPLOYMENT("배포");

    private String name;

    Mission(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static Mission getMission(String missionName) {
        for (Mission mission : Mission.values()) {
            if (mission.name.equals(missionName)) {
                return mission;
            }
        }
        throw new IllegalArgumentException("Invalid level name: " + missionName);
    }

}


