import java.util.LinkedList;

/**
 * Class counts value of input expression and print it
 * Uses Reversed Polish Notation
 * Can't count negative negative numbers and exp view of numbers
 */
public class ReversedPolishNotation {

    private LinkedList<Double> stack = new LinkedList<>(); // List for numbers
    private LinkedList<Character> operators = new LinkedList<>(); // List for operators
    private String expression; //String for expression

    /**
     * Constructor for class
     * Print counted value
     * @param string
     */
    public ReversedPolishNotation(String string) {
        if (string == "") {
          System.out.println("Wrong expression");
        }
        this.expression = string;
        System.out.println(parseAndCalculate());
    }

    /**
     * @param c
     * @return true if there is space-symbol
     *         false if no space-symbol
     */
    private boolean isSpace(char c) {
        return c == ' ';
    }

    /**
     * @param c
     * @return true if there is one of symbols: + - * /
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    /**
     * @param operator
     * @return priority of operation: + or - : 1
     *                                * or / : 2
     *                                 other :-1
     */
    private int priority(char operator) {
        switch (operator) {
          case '+':
          case '-':
            return 1;
          case '*':
          case '/':
            return 2;
          default:
            return -1;
        }
    }

    /**
     * method counts value of present pair of numbers
     * depends on operator
     * @param operator
     */
    private void processOperator(char operator) {
        double right = stack.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
        double left = stack.removeLast(); // также
        switch (operator) { // выполняем действие между l и r в зависимости от оператора в кейсе и результат валим в st
            case '+':
              stack.add(left + right);
              break;
            case '-':
              stack.add(left - right);
              break;
            case '*':
              stack.add(left * right);
              break;
            case '/':
              stack.add(left / right);
              break;
        }
    }

    /**
     * This method parsings and calculates value of whole expression
     * and prints it on screen
     */
    private Double parseAndCalculate() {
        for (int i = 0; i < expression.length(); i++) { // парсим строку с выражением и вычисляем
            char c = expression.charAt(i);
            if (isSpace(c)) {
              continue;
            }
            if (c == '(') {
              operators.add('(');
            } else {
              if (c == ')') {
                while (operators.getLast() != '(') {
                  processOperator(operators.removeLast());
                }
                operators.removeLast();
                } else {
                if (isOperator(c)) {
                  while (!operators.isEmpty() && priority(operators.getLast()) >= priority(c)) {
                    processOperator(operators.removeLast());
                  }
                  operators.add(c);
                } else {
                  String operand = "";
                  while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    operand += expression.charAt(i++);
                  }
                  --i;
                  stack.add(Double.parseDouble(operand));
                }
              }
            }
        }
        while (!operators.isEmpty()) {
          processOperator(operators.removeLast());
        }
        return stack.get(0);
    }
}


