import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, -b);
        int d = calc.pow.apply(5);
        int e = calc.abs.apply(-5);
        System.out.println(calc.isPositive.test(5));
        calc.println.accept(c);


    }
}

class Calculator {
    public static BinaryOperator<Integer> plus = (x, y) -> x + y;

    public static BinaryOperator<Integer> minus = (x, y) -> x - y;

    public static BinaryOperator<Integer> multiply = (x, y) -> x * y;

    public static BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : 0;// на ноль делить нельзя, если y равен 0, то я возвращаю ноль. Можно было сделать исключение и выбросить ошибку, но джава сама выкидывает уведомление, что идет деление на ноль.;
    public static UnaryOperator<Integer> pow = x -> x * x;

    public static UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    public static Predicate<Integer> isPositive = x -> x > 0;

    public static Consumer<Integer> println = System.out::println;


    static Supplier<Calculator> instance = Calculator::new;

}