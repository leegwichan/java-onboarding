package onboarding.problem1;

import java.util.Arrays;
import java.util.List;

public class BookScoreCalculator {

    public static int score(List<Integer> book){
        return Math.max(pageScore(book.get(0)), pageScore(book.get(1)));
    }

    private static int pageScore(Integer pageNumber){
        int[] digitArray = makeDigitArray(pageNumber);
        return Math.max(addArrayElementsIntoSum(digitArray), multiplyArrayElementsIntoProduct(digitArray));
    }

    private static int[] makeDigitArray (Integer number){
        int totalDigitNumber = (int) ( Math.log10(number)+1 );
        int[] digitArray = new int[totalDigitNumber];

        for (int i=0; i<totalDigitNumber; i++){
            digitArray[i] = number / (int) Math.pow(10, totalDigitNumber - (i+1)) % 10;
        }
        return digitArray;
    }

    private static int addArrayElementsIntoSum(int[] array){
        return Arrays.stream(array).sum();
    }

    private static int multiplyArrayElementsIntoProduct(int[] array){
        return Arrays.stream(array).reduce(1, (a,b) -> a*b);
    }
}
