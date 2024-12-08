package pairmatching.view;

import pairmatching.Enum.Level;
import pairmatching.Enum.ViewMessage;
import pairmatching.model.Crew;
import pairmatching.model.Pair;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printErrorMessage(String message) {
        System.out.println(message+"\n");
    }

    public void printMatchingPair(Pair pair){
        List<List<Crew>> pairCrews = pair.getPiarCrew();
        System.out.println(ViewMessage.PRINT_PAIRMATCHING_RESULT.getMessage());
        for (List<Crew> pairCrew : pairCrews) {
            String output = "";
            for (int i = 0; i < pairCrew.size(); i++) {
                if (i == pairCrew.size()-1) {
                    output += pairCrew.get(i).getName();
                } else {
                    output += pairCrew.get(i).getName() + " :";
                }
            }
            System.out.println(output);
        }
    }

}