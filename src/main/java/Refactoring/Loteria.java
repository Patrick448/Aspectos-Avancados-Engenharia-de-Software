package Refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loteria {

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

    public List<Integer> verifySelectedNumbers(List<Integer> selectedNums){
        List<Integer> filteredNums = new ArrayList<>();
        for (Integer n: selectedNums){
            if (n < MIN_NUMBER || n > MAX_NUMBER){
                throw new IllegalArgumentException("a lista deve conter números entre 1 e 60");
            }
            if (filteredNums.contains(n)){
                throw new IllegalArgumentException("a lista não pode conter números repetidos");
            }else{
                filteredNums.add(n);
            }

        }
        return filteredNums;
    }

    public int countMatches(List<Integer> listA, List<Integer> listB){
        if(listA == null || listB == null){
            throw new IllegalArgumentException("lista não pode ser nula");
        }

        int totalMatches =0;
        for (Integer i: listA){
            if (listB.contains(i)){
                totalMatches++;
            }
        }
        return totalMatches;
    }

    public List<Integer> randomIntListNoRepeat(){
        List<Integer> randomNums = new ArrayList<>();
        int randomInt;

        while (randomNums.size() < TOTAL_RANDOM_NUMBERS) {
            randomInt = new Random().nextInt(MAX_NUMBER-1) + 1;
            if (!randomNums.contains(randomInt)) {
                randomNums.add(randomInt);
            }
        }
        return randomNums;
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

    public double makeBet(List<Integer> selectedNums, List<Integer> randomNums,  double prizeBaseValue) {
        if(selectedNums == null || randomNums == null){
            throw new IllegalArgumentException("lista não pode ser nula");
        }

        double prizeValue = 0.0;
        List<Integer> filteredNums = verifySelectedNumbers(selectedNums);

        if (filteredNums.size() >= MIN_BET_SIZE && filteredNums.size() <= MAX_BET_SIZE) {
            int totalMatches = countMatches(randomNums, filteredNums);
            prizeValue = calculateFinalPrize(prizeBaseValue, totalMatches);
        }else{
            throw new IllegalArgumentException("lista de números deve ter entre 6 e 15 elementos");
        }

        return prizeValue;
    }
}
