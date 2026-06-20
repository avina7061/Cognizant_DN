public class OperatorPrecedence {
    public static void main(String[] args) {

        int res1 = 10 + 5 * 2;
        int res2 = (10 + 5) * 2;
        int res3 = 20 / 5 + 3 * 4;
        int res4 = 10 - 2 * 3 + 4;

        System.out.println("10 + 5 * 2 = " + res1);
        System.out.println("(10 + 5) * 2 = " + res2);
        System.out.println("20 / 5 + 3 * 4 = " + res3);
        System.out.println("10 - 2 * 3 + 4 = " + res4);
    }
}