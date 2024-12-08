package pairmatching;

import pairmatching.controller.PairController;
import pairmatching.service.CrewService;
import pairmatching.service.InputService;
import pairmatching.service.PairService;
import pairmatching.view.*;

public class AppConfig {
    public PairController controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputService inputService = new InputService(inputView, outputView);

        PairService pairService = new PairService();
        CrewService crewService = new CrewService();

        return new PairController(inputService,
                outputView,
                pairService,
                crewService);
    }
}