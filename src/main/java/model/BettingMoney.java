package model;

import exception.IllegalBettingMoneyFormatException;

public class BettingMoney {
    private final int bettingMoney;

    public BettingMoney(String input) {
        validate(input);
        this.bettingMoney=Integer.parseInt(input);
    }

    private void validate(String input){
        validateFormat(input);
        validateRange(Integer.parseInt(input));
    }
    private void validateFormat(String input) {
        try{
            Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalBettingMoneyFormatException("배팅 금액은 100이상의 숫자만 입력 가능합니다.");
        }
    }

    private void validateRange(int input) {
        if (input < 100) {
            throw new IllegalBettingMoneyFormatException("배팅 금액은 100이상의 숫자만 입력 가능합니다.");
        }
    }

    public int getBettingMoney() {
        return bettingMoney;
    }
}
