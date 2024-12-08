package pairmatching.model;

import pairmatching.Enum.Level;
import pairmatching.Enum.Mission;

import java.util.List;

public class Pair {
    // 레벨과 미션, 페어 크루 저장
    private final Level level;
    private final Mission mission;
    private List<List<Crew>> piarCrew;

    public Pair(Level level, Mission mission) {
        this.level = level;
        this.mission = mission;
    }

    public void setPiarCrew(List<List<Crew>> piarCrew) {
        this.piarCrew = piarCrew;
    }

    public Level getLevel() {
        return level;
    }

    public List<List<Crew>> getPiarCrew() {
        return piarCrew;
    }


    public boolean equals(String inputLevel, String inputMission) {
        if (level.name().equals(inputLevel) && mission.name().equals(inputMission)) {
            return true;
        }
        return false;
    }

    public boolean validatePair(List<String> pairName) {
        for (List<Crew> crews : piarCrew) {
            int count = 0;
            for (String name : pairName) {
                for (Crew crew : crews) {
                    if (crew.getName().equals(name)) {
                        count++;
                    }
                }
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}