package pairmatching.controller;

import pairmatching.Enum.ErrorMessage;
import pairmatching.model.Crew;
import pairmatching.model.Pair;
import pairmatching.service.CrewService;
import pairmatching.service.InputService;
import pairmatching.service.PairService;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PairController {
    private final InputService inputService;
    private final OutputView outputView;
    private final PairService pairService;
    private final CrewService crewService;

    public PairController(InputService inputService,
                          OutputView outputview,
                          PairService pairService,
                          CrewService crewService) {
        this.inputService = inputService;
        this.outputView = outputview;
        this.pairService = pairService;
        this.crewService = crewService;
    }

    public void start() {
        List<Pair> pairs = new ArrayList<>();
        while (true) {
            String service = inputService.getService();
            if (service.equals("Q")) {
                break;
            }

            if(service.equals("1")){
                pairMatching(pairs);
            }

            if(service.equals("2")){
                getMatching(pairs);
            }

            if(service.equals("3")){
                pairs = new ArrayList<>();
            }
        }
    }

    private void pairMatching(List<Pair> pairs) {
        while (true) {
            List<String> process = inputService.getProcess();
            List<Crew> crews = crewService.getCrew(process.get(0));

            // 매칭이 이미 존재
            Pair existedPair = pairService.checkMatchingExist(pairs, process);
            if (existedPair != null) {
                String rematchYn = inputService.getRematchingYn();

                if (rematchYn.equals("아니오")) {
                    continue;
                }
                pairs.remove(existedPair);
            }

            try {
                Pair newPair = pairService.processPairMatching(pairs, process, crews);
                pairs.add(newPair);
                outputView.printMatchingPair(newPair);

            } catch (Exception e) {
                outputView.printErrorMessage(ErrorMessage.MATCHING_IMPOSSIBLE.getMessage());
            }
            break;
        }
    }

    private void getMatching(List<Pair> pairs) {
        List<String> process = inputService.getProcess();

        Pair existedPair = pairService.checkMatchingExist(pairs, process);
        if (existedPair == null) {
            outputView.printErrorMessage(ErrorMessage.NON_EXISTENT_PAIR_MATCHING.getMessage());
        }

        // 매칭 출력
        outputView.printMatchingPair(existedPair);
    }
}
