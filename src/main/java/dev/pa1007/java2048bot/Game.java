package dev.pa1007.java2048bot;

import dev.pa1007.java2048bot.ai.AI;
import dev.pa1007.java2048bot.ai.BasicAI;
import java.util.List;

public class Game {

    private final List<Case> casesSortedAndTyped;

    private final AI ai;

    public Game(List<Case> casesSortedAndTyped) {
        this.casesSortedAndTyped = casesSortedAndTyped;
        ai = new BasicAI();
    }

    public List<Case> getCasesSortedAndTyped() {
        return casesSortedAndTyped;
    }

    public AI.Response nextMove() {
        return ai.resolve(this);
    }

    private String format(int val) {
        if (val > -1) {
            if (val > 1000) {
                return String.valueOf(val);
            }
            else if (val > 100) {
                return " " + val;
            }
            else if (val > 10) {
                return " " + val + " ";
            }
            else {
                return " 0" + val + " ";
            }
        }
        else {
            return " " + val + " ";
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int           i             = 0;
        for (Case aCase : casesSortedAndTyped) {
            stringBuilder.append("| ").append(format(aCase.getType().getVal())).append(" ");
            i++;
            if (i == 4) {
                stringBuilder.append("|\n");
                i = 0;
            }
        }
        return stringBuilder.toString();
    }
}
