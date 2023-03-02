package calculator.operator;

import calculator.domain.PositiveNumber;

public interface NewArithmeticOperator {
    boolean supports(String operator); //해당 연산을 지원하는지
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
