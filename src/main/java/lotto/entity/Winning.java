package lotto.entity;

import lotto.property.LottoProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.property.LottoProperty.*;
import static lotto.property.ValidationProperty.*;
import static lotto.validation.ValidationForm.*;

public class Winning {
    private final List<Integer> winningNumbers;

    public Winning (String winningNumbersString,String winningBonusNumber){
        this.winningNumbers = winningNumbersConvertToList(winningNumbersString, winningBonusNumber);
    }

    private List<Integer> winningNumbersConvertToList(String winningNumbersString,String winningBonusNumber){
        List<String> winningNumberList = Arrays.asList(winningNumbersString.split(DELIMITER));
        validate(winningNumbersString,winningBonusNumber,winningNumberList);
        List<Integer> winningNumbers = new ArrayList<>(winningNumberList.stream().map(Integer::parseInt).toList());
        winningNumbers.add(Integer.parseInt(winningBonusNumber));
        return winningNumbers;
    }
    static void validate(String winningNumbers,String winningBonusNumber,List<String> winningNumberList){
        verifyFormatForInputValue(WINNINGS,winningNumbers);
        winningNumberList.forEach(number->verifyFormatForInputValue(WINNING,number));
        verifyFormatForInputValue(WINNING,winningBonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}