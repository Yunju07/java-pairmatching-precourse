package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Enum.ViewMessage;

public class InputView {
    public String getService() {
        System.out.println(ViewMessage.GET_SERVICE.getMessage());
        String input = Console.readLine();

        return input;
    }

    public String getProcess() {
        System.out.println(ViewMessage.PRINT_PROCESS_INFORMATION.getMessage());
        String input = Console.readLine();

        return input;
    }

    public String getRematchingYn() {
        System.out.println(ViewMessage.GET_REMATCHING_YN.getMessage());
        String input = Console.readLine();

        return input;
    }
}