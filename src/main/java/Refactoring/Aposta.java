package Refactoring;

import java.util.ArrayList;
import java.util.List;

public class Aposta {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 60;
    private static final int MIN_BET_SIZE = 6;

    private static final int MAX_BET_SIZE = 15;
    private List<Integer> numbers;

    public Aposta(List<Integer> numbers) {

        this.numbers =verifySelectedNumbers(numbers);
    }

    public Aposta() {
    }

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

        if (filteredNums.size() < MIN_BET_SIZE || filteredNums.size() > MAX_BET_SIZE) {
            throw new IllegalArgumentException("lista de números deve ter entre 6 e 15 elementos");
        }

        return filteredNums;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
