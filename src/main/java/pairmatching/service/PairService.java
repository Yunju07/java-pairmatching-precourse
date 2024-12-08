package pairmatching.service;


import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.Enum.Course;
import pairmatching.Enum.Level;
import pairmatching.Enum.Mission;
import pairmatching.model.Crew;
import pairmatching.model.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PairService {
    public Pair processPairMatching(List<Pair> pairs, List<String> process, List<Crew> crews) throws Exception {
        Course course = Course.getCourse(process.get(0));
        Level level = Level.getLevel(process.get(1));
        Mission mission = Mission.getMission(process.get(2));

        // 크루들 이름
        List<String> crewNames = new ArrayList<>();
        for (Crew crew : crews) {
            crewNames.add(crew.getName());
        }

        // 페어 매칭 시도 (최대 3회)
        for (int count = 0; count < 3; count++) {
            List<List<String>> pairNames = new ArrayList<>();
            List<String> shuffledCrew = Randoms.shuffle(crewNames);

            boolean isValid = true;
            while (!shuffledCrew.isEmpty()) {
                List<String> pairName = new ArrayList<>();
                pairName.add(shuffledCrew.get(0));
                pairName.add(shuffledCrew.get(1));
                shuffledCrew.remove(0);
                shuffledCrew.remove(0);

                // 마지막 남은 크루 -> 마지막 페어에 저장
                if (shuffledCrew.size() == 1) {
                    pairName.add(shuffledCrew.get(0));
                    shuffledCrew.remove(0);
                }

                // 해당 페어가 가능한지 검사
                if (!validatePair(pairName, pairs, level)) {
                    isValid = false;
                    break;
                }
                pairNames.add(pairName);
            }
            if (isValid == true) {
                // 페어 생성 후 반환
                List<List<Crew>> newCrews = new ArrayList<>();
                for (List<String> pairname : pairNames) {
                    List<Crew> pairCrew = new ArrayList<>();
                    for (String name : pairname) {
                        pairCrew.add(new Crew(course, name));
                    }
                }
                Pair newPair = new Pair(level, mission);
                newPair.setPiarCrew(newCrews);
                System.out.println(newCrews.size());

                return newPair;
            }
        }
        // 페어 매칭 실패 -> 에러 메세지 출력
        throw new Exception();
    }

    public void getPairMatching() {

    }

    public void resetPairMatching() {

    }

    public Pair checkMatchingExist(List<Pair> pairs, List<String> process) {
        for (Pair pair: pairs) {
            String level = process.get(1);
            String mission = process.get(2);

            if (pair.equals(level, mission)) {
                return pair;
            }

        }
        return null;
    }

    private boolean validatePair(List<String> pairNames, List<Pair> pairs, Level level) {
        // 같은 레벨의 모든 페어
        List<Pair> sameLevelPairs = new ArrayList<>();
        for (Pair pair : pairs) {
            if (pair.getLevel().equals(level)) {
                sameLevelPairs.add(pair);
            }
        }

        for (Pair pair : sameLevelPairs) {
            if(!pair.validatePair(pairNames)) {
                return false;
            }
        }
        return true;
    }

}
