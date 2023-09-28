public class CalModel {
    private Double calResult;

    public void add(double num1, double num2) {
        calResult = num1 + num2;
    }

    public void sub(double num1, double num2) {
        calResult = num1 - num2;
    }

    public void mul(double num1, double num2) {
        calResult = num1 * num2;
    }

    public void div(double num1, double num2) {
        calResult = num1 / num2;
    }

    public Double getCalResult() {
        return calResult;
    }
}