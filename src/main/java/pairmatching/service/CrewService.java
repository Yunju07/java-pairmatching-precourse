package pairmatching.service;

import pairmatching.Enum.Course;
import pairmatching.model.Crew;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewService {
    private final static String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    private final static String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";
    public List<Crew> getCrew(String course) {
        List<Crew> crews = new ArrayList<>();

        if(course.equals("백엔드")) {
            crews = loadCrew(Course.BACKEND, BACKEND_CREW_FILE_PATH);
        }
        if(course.equals("프론트엔드")) {
            crews = loadCrew(Course.FRONTEND, FRONTEND_CREW_FILE_PATH);
        }

        return crews;
    }

    private List<Crew> loadCrew(Course course, String filepath) {
        List<Crew> crews = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(filepath));
            while(scanner.hasNext()) {
                String name = scanner.nextLine().trim();
                crews.add(new Crew(course, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return crews;
    }
}
