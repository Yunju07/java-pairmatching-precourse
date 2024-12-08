package pairmatching.Enum;

public enum ViewMessage {
    GET_SERVICE("기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료"),
    PRINT_PROCESS_INFORMATION("#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3:\n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5:\n" +
            "############################################\n" +
            "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주\n"),
    PRINT_PAIRMATCHING_RESULT("페어 매칭 결과입니다."),
    GET_REMATCHING_YN("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
            "네 | 아니오\n"),
    PRINT_RESET("초기화 되었습니다.");


    private final String message;

    private ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}