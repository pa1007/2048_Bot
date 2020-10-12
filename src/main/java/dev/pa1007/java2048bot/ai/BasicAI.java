package dev.pa1007.java2048bot.ai;

import dev.pa1007.java2048bot.Case;
import dev.pa1007.java2048bot.Game;
import java.util.ArrayList;
import java.util.List;

public class BasicAI implements AI {

    @Override
    public Response resolve(Game game) {
        List<Case> casesSortedAndTyped = game.getCasesSortedAndTyped();

    }


    public List<Case> getNearCases(Case from, List<Case> cases) {
        List<Case> res = new ArrayList<>();
        List<Case> nearest = from.getNearCasesPos();


        cases.forEach((i) -> {

        });


    }
}
