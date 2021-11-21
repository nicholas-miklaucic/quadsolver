public class App {
    public static void main(String[] args) throws Exception {
        Rational num1 = new Rational(12, 6);
        Rational num2 = new Rational(4, 6);
        Rational num3 = new Rational(1, 2);
        System.out.println(num1.toString());
        System.out.println(num2.toString());
        System.out.println(num3.toString());
        System.out.println(num2.add(num3).toString());
        System.out.println(num1.mult(num2).toString());
        System.out.println(num1.inv().toString());
    }
}
