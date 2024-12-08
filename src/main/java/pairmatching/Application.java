package pairmatching;

import pairmatching.controller.PairController;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        AppConfig appConfig = new AppConfig();
        PairController controller = appConfig.controller();

        controller.start();
    }
}
