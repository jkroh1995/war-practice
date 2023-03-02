package calculator.operator;

import calculator.domain.PositiveNumber;

public class DivisionOperator implements NewArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return operator.equals("/");
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        //이미 PositiveNumber에서 0보다 큰지를 검사함.
//        if(operand2.toInt() ==0){
//            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
//        }
        return operand1.toInt() / operand2.toInt();
    }
}
