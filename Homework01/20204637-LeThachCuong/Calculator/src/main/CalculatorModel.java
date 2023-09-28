package main;

public class CalculatorModel {
    private Double calculationValue;

    public void addTwoNumbers(double firstNumber, double secondNumber){
        calculationValue = firstNumber + secondNumber;

    }
    public void subTwoNumbers(double firstNumber, double secondNumber) {
        calculationValue = firstNumber - secondNumber;
    }

    public void multiplyTwoNumber(double firstNumber, double secondNumber) {
        calculationValue = firstNumber * secondNumber;
    }

    public void dividedTwoNumber(double firstNumber, double secondNumber) {
        calculationValue = firstNumber / secondNumber;
    }

    public Double getCalculationValue() {
        return calculationValue;
    }
}
