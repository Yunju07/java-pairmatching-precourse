package pairmatching.Enum;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static Course getCourse(String courseName) {
        for (Course course : Course.values()) {
            if (course.name.equals(courseName)) {
                return course;
            }
        }
        throw new IllegalArgumentException("Invalid course name: " + courseName);
    }
}

