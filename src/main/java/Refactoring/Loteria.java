package Refactoring;

import java.util.List;

public class Loteria {

    //todo: separar em classes diferentes
    private static final int FIRST_PRIZE_MATCH_NUMBER = 6;
    private static final int SECOND_PRIZE_MATCH_NUMBER = 5;
    private static final int THIRD_PRIZE_MATCH_NUMBER = 4;

    private static final double SECOND_PLACE_PRIZE_FRACTION = 0.2;
    private static final double THIRD_PLACE_PRIZE_FRACTION = 0.05;

    private static final int MIN_BET_SIZE = 6;

    private static final int MAX_BET_SIZE = 15;

    private static final int MIN_NUMBER = 1;

    private static final int MAX_NUMBER = 60;

    private static final int TOTAL_RANDOM_NUMBERS = 6;



    public int countMatches(Aposta aposta, Sorteio sorteio){
        if(aposta == null || sorteio == null){
            throw new IllegalArgumentException("Objetos passados como parâmetro não podem ser nulos");
        }

        int totalMatches =0;
        for (Integer i: aposta.getNumbers()){
            if (sorteio.getNumbers().contains(i)){
                totalMatches++;
            }
        }
        return totalMatches;
    }


    public double calculateFinalPrize(double prizeBaseValue, int totalMatches){
        double prizeValue = 0.0;

        if (totalMatches == FIRST_PRIZE_MATCH_NUMBER){
            prizeValue = prizeBaseValue;
        } else if (totalMatches == SECOND_PRIZE_MATCH_NUMBER){
            prizeValue = prizeBaseValue * SECOND_PLACE_PRIZE_FRACTION;
        } else if (totalMatches == THIRD_PRIZE_MATCH_NUMBER){
            prizeValue = prizeBaseValue * THIRD_PLACE_PRIZE_FRACTION;
        }

        return prizeValue;
    }

    public double verifyLoteryResult(Aposta aposta, Sorteio sorteio, double prizeBaseValue) {
        if(aposta == null || sorteio == null){
            throw new IllegalArgumentException("Objetos passados como parâmetro não podem ser nulos");
        }

        double prizeValue = 0.0;
        int totalMatches = countMatches(aposta, sorteio);
        prizeValue = calculateFinalPrize(prizeBaseValue, totalMatches);


        return prizeValue;
    }
}
