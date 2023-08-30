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

    public List<Integer> filterNumbers(List<Integer> selectedNums){
        List<Integer> filteredNums = new ArrayList<>();
        for (Integer n: selectedNums){
            if (n >= 1 && n <= 60 && !filteredNums.contains(n)){
                filteredNums.add(n);
            }
        }
        return filteredNums;
    }

    public int countMatches(List<Integer> listA, List<Integer> listB){
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

        while (randomNums.size() < 6) {
            randomInt = new Random().nextInt(59) + 1;
            if (!randomNums.contains(randomInt)) {
                randomNums.add(randomInt);
            }
        }
        return randomNums;
    }

    public double makeBet(List<Integer> selectedNums, double prizeBaseValue) {
        List<Integer> filteredNums = filterNumbers(selectedNums);
        double prizeValue = 0.0;

        if (filteredNums.size() >= MIN_BET_SIZE && filteredNums.size() <= MAX_BET_SIZE) {
            List<Integer> randomNums = randomIntListNoRepeat();
            int totalMatches = countMatches(randomNums, filteredNums);

            if (totalMatches == FIRST_PRIZE_MATCH_NUMBER){
                prizeValue = prizeBaseValue;
            } else if (totalMatches == SECOND_PRIZE_MATCH_NUMBER){
                prizeValue = prizeBaseValue * SECOND_PLACE_PRIZE_FRACTION;
            } else if (totalMatches == THIRD_PRIZE_MATCH_NUMBER){
                prizeValue = prizeBaseValue * THIRD_PLACE_PRIZE_FRACTION;
            }
        }

        return prizeValue;
    }
}
