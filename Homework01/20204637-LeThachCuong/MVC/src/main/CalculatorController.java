package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView calculatorView;
    private CalculatorModel calculatorModel;

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel) {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;

        this.calculatorView.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int firstNumber, secondNumber = 0;

            try {
                firstNumber = calculatorView.getFirstNumber();
                secondNumber = calculatorView.getSecondNumber();

                calculatorModel.addTwoNumbers(firstNumber, secondNumber);

                calculatorView.setCalcSolution(calculatorModel.getCalculationValue());
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                calculatorView.displayErrorMessage("You need to Enter 2 intergers");
            }
        }
    }

}