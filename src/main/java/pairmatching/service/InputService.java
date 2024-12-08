package pairmatching.service;

import pairmatching.Enum.ErrorMessage;
import pairmatching.Enum.Level;
import pairmatching.view.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InputService {

    private final InputView inputView;
    private final OutputView outputView;

    public InputService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getService() {
        while(true) {
            try {
                String input = inputView.getService();
                input = input.replaceAll(" ", "");
                List<String> services = Arrays.asList("1", "2", "3", "Q");

                if (services.contains(input)) {
                    return input;
                }

                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_INPUT.getMessage());
            }
        }
    }
    public List<String> getProcess() {
        while(true) {
            try {
                String input = inputView.getProcess();
                input = input.replaceAll(" ", "");
                List<String> inputs = validateProcessInput(input);

                return inputs;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            } catch (Exception e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_INPUT.getMessage());
            }
        }
    }

    public String getRematchingYn() {
        while(true) {
            try {
                String input = inputView.getRematchingYn();
                input = input.replaceAll(" ", "");
                List<String> Yn = Arrays.asList("네", "아니오");

                if (Yn.contains(input)) {
                    return input;
                }

                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(ErrorMessage.INVALID_INPUT.getMessage());
            }
        }
    }

    private List<String> validateProcessInput(String input) {
        String[] inputs = input.split(",");
        List<String> results = new ArrayList<>();

        if (inputs.length != 3) {
            throw new IllegalArgumentException();
        }

        // TODO: 메서드 분리
        // 과정 검사
        List<String> course = Arrays.asList("백엔드", "프론트엔드");
        if (!course.contains(inputs[0])) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        results.add(inputs[0]);

        // 레벨 검사
        List<String> level = Arrays.asList("레벨1", "레벨2", "레벨3", "레벨4", "레벨5");
        if (!level.contains(inputs[1])) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        if (inputs[1].equals("레벨3") || inputs[1].equals("레벨5")) {
            // 미션이 없습니다.
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        results.add(inputs[1]);

        // 미션 검사 - 레벨별
        List<String> mission = new ArrayList<>();
        if (inputs[1].equals("레벨1")) {
            mission = Arrays.asList("자동차경주", "로또", "숫자야구게임");
        }
        if (inputs[1].equals("레벨2")) {
            mission = Arrays.asList("장바구니", "결제", "지하철노선도");
        }
        if (inputs[1].equals("레벨4")) {
            mission = Arrays.asList("성능개선", "배포");
        }

        if (!mission.contains(inputs[2])) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        results.add(inputs[2]);

        return results;
    }
}