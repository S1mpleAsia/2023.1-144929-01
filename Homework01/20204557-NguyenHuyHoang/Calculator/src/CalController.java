import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalController {
    private final CalView calView;
    private final CalModel calModel;

    private Double num1, num2 = (double) 0;
    private char operator;

    public CalController(CalView calView, CalModel calModel) {
        this.calView = calView;
        this.calModel = calModel;
        this.calView.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) throws NumberFormatException {
            JTextField tfInput = calView.getTfInput();

            for (int i = 0; i < 10; i++) {
                if (e.getSource() == calView.getNumButtons()[i]) {
                    tfInput.setText(tfInput.getText() + String.valueOf(i));
                }
            }

            if (e.getSource() == calView.getDecimalButton()) {
                tfInput.setText(tfInput.getText() + ".");
            }

            if (e.getSource() == calView.getAddButton()) {
                try {
                    num1 = Double.parseDouble(tfInput.getText());
                } catch (NumberFormatException exception) {
                    calView.displayErrorMessage("Please enter a valid number");
                }

                operator = '+';
                tfInput.setText("");
            }

            if (e.getSource() == calView.getSubtractButton()) {
                try {
                    num1 = Double.parseDouble(tfInput.getText());
                } catch (NumberFormatException exception) {
                    calView.displayErrorMessage("Please enter a valid number");
                }

                operator = '-';
                tfInput.setText("");
            }

            if (e.getSource() == calView.getMultiplyButton()) {
                try {
                    num1 = Double.parseDouble(tfInput.getText());
                } catch (NumberFormatException exception) {
                    calView.displayErrorMessage("Please enter a valid number");
                }

                operator = '*';
                tfInput.setText("");
            }

            if (e.getSource() == calView.getDivideButton()) {
                try {
                    num1 = Double.parseDouble(tfInput.getText());
                } catch (NumberFormatException exception) {
                    calView.displayErrorMessage("Please enter a valid number");
                }

                operator = '/';
                tfInput.setText("");
            }

            if (e.getSource() == calView.getEqualButton()) {
                try {
                    num2 = Double.parseDouble(tfInput.getText());
                } catch (NumberFormatException exception) {
                    calView.displayErrorMessage("Please enter a valid number");
                }

                switch (operator) {
                    case '+':
                        calModel.add(num1, num2);
                        break;
                    case '-':
                        calModel.sub(num1, num2);
                        break;
                    case '*':
                        calModel.mul(num1, num2);
                        break;
                    case '/':
                        calModel.div(num1, num2);
                        break;
                }

                tfInput.setText(calModel.getCalResult().toString());
                num1 = null;
                num2 = null;
            }

            if (e.getSource() == calView.getClearButton()) {
                tfInput.setText("");
                num1 = null;
                num2 = null;
            }

            if (e.getSource() == calView.getDeleteButton()) {
                String newVal = tfInput.getText().substring(0, tfInput.getText().length() - 1);

                tfInput.setText(newVal);
            }
        }
    }
}
