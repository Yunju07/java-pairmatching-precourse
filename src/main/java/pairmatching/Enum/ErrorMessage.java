package pairmatching.Enum;

import org.omg.PortableInterceptor.NON_EXISTENT;

public enum ErrorMessage {
    INVALID_INPUT("[ERROR] 잘못된 입력입니다."),
    MATCHING_IMPOSSIBLE("[ERROR] 매칭이 불가능 합니다."),
    NON_EXISTENT_PAIR_MATCHING("[ERROR] 매칭 이력이 없습니다.");

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
