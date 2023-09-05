package Refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio {

    private static final int MAX_NUMBER = 60;

    private static final int TOTAL_RANDOM_NUMBERS = 6;

    private List<Integer> numbers;
    public Sorteio() {
        this.numbers = randomIntListNoRepeat();
    }

    public Sorteio(List<Integer> numbers) {
        this.numbers = numbers;
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

    public List<Integer> getNumbers() {
        return numbers;
    }



}
