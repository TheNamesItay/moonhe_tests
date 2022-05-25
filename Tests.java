//import Scalar.*;
import main.*;
import main.Integer;


public class Tests22 {
    int total_tests;
    int total_passed;

    private Scalar i;

    public void run_tests(){
        Runnable[] testies = {
                () -> integer_add(),
                () -> integer_mul(),
                () -> integer_power(),
                () -> rational_add(),
                () -> rational_mul(),
                () -> rational_power(),
                () -> monomial_add(),
                () -> monomial_mul(),
                () -> monomial_derivative(),
                () -> polynomial_add(),
                () -> polynomial_mul(),
                () -> polynomial_derivative(),
                () -> polynomial_evaluate(),
        };

        for (Runnable r : testies) {
            r.run();
        }
        System.out.println("OVERALL  " + total_passed + "/" + total_tests);
    }

    public double get_value(Scalar x){
        if (x.getClass() == Integer.class){
            return ((double) ((Integer) x).getNumber());
        }
        else return ((double)((Rational) x).getNumerator())/((double)((Rational) x).getDenominator()) ;
    }

    // integer tests
    public void integer_add() {
        int passed = 0;
        int tests = 0;

//        System.out.println("+++");
        i = new Integer(0);

        i = i.add(new Integer(0));
//        System.out.println(get_value(i) == 0);
        if (get_value(i) == 0) {passed++;} tests++;


        i = i.add(new Integer(8));
//        System.out.println(get_value(i) == 8);
        if (get_value(i) == 8) {passed++;} tests++;

        i = i.add(new Integer(-11));
//        System.out.println(get_value(i) == -3);
        if (get_value(i) == -3) {passed++;} tests++;

        i = i.add(new Rational(13, 2));
//        System.out.println(get_value(i) == 7./2);
        if (get_value(i) == 7./2) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" integer_add " + passed + "/" + tests);
    }

    public void integer_mul() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
        i = new Integer(1);

        i = i.mul(new Integer(8));
//        System.out.println(get_value(i) == 8);
        if (get_value(i) == 8) {passed++;} tests++;

        i = i.mul(new Integer(-3));
//        System.out.println(get_value(i) == -24);
        if (get_value(i) == -24) {passed++;} tests++;

        i = i.mul(new Rational(3, 4));
//        System.out.println(get_value(i) == -18);
        if (get_value(i) == -18) {passed++;} tests++;

        i = i.mul(new Integer(0));
//        System.out.println(get_value(i) == 0);
        if (get_value(i) == 0) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" integer_mul " + passed + "/" + tests);
    }

    public void integer_power() {
        int passed = 0;
        int tests = 0;
//        System.out.println("- integer_power");
        i = new Integer(0);
//        System.out.println(get_value(i.power(0)) == 1);
        if (get_value(i.power(0)) == 1) {passed++;} tests++;

//        System.out.println(get_value(i.power(12345)) == 0);
        if (get_value(i.power(12345)) == 0) {passed++;} tests++;

        i = new Integer(5);
//        System.out.println(get_value(i.power(4)) == 625);
        if (get_value(i.power(4)) == 625) {passed++;} tests++;

        i = new Integer(2);
//        System.out.println(get_value(i.power(26)) == 67108864);
        if (get_value(i.power(26)) == 67108864) {passed++;} tests++;

//        System.out.println(get_value(i.power(0)) == 1);
        if (get_value(i.power(0)) == 1) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" integer_power " + passed + "/" + tests);
    }

    private Scalar r;
    private Rational r2;

    // rational tests
    public void rational_add() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
        r = new Rational(1, 2);
        r2 = new Rational(1, 2);
        r = r.add(new Rational(0, 1));
//        System.out.println(get_value(r) == 1./2);
        if (get_value(r) == 1./2) {passed++;} tests++;

        r = r.add(r2);
//        System.out.println(get_value(r) == 1);
        if (get_value(r) == 1) {passed++;} tests++;

        r = r.add(new Rational(1, 12345));
//        System.out.println(get_value(r) == 12346./12345);
        if (get_value(r) == 12346./12345) {passed++;} tests++;

        r = new Rational(1, 1);
        r = r.add(new Rational(1, 1000000));
//        System.out.println(get_value(r) == 1000001./1000000);
        if (get_value(r) == 1000001./1000000) {passed++;} tests++;

        r2 = new Rational(-3, 2);
        r = r.add(r2);
//        System.out.println(get_value(r) == -499999./1000000);
        if (get_value(r) == -499999./1000000) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" rational_add " + passed + "/" + tests);
    }

    public void rational_mul() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
        r = new Rational(1, 2);
        r2 = new Rational(1, 2);

        r = r.mul(r2);
//        System.out.println(get_value(r) == 1./4);
        if (get_value(r) == 1./4) {passed++;} tests++;

        r2 = new Rational(400,53);
        r = r.mul(r2);
//        System.out.println(get_value(r) == 100./53);
        if (get_value(r) == 100./53) {passed++;} tests++;

        r = r.mul(new Rational(-13, 43));
//        System.out.println(get_value(r) == -1300./2279);
        if (get_value(r) == -1300./2279) {passed++;} tests++;

        r = r.mul(new Integer(0));
//        System.out.println(get_value(r) == 0);
        if (get_value(r) == 0) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" rational_mul " + passed + "/" + tests);
    }

    public void rational_power() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
        r = new Rational(1, 2);
        r2 = new Rational(1, 2);

        r = r.power(2);
//        System.out.println(get_value(r) == 1./4);
        if (get_value(r) == 1./4) {passed++;} tests++;

        r = r.power(13);
//        System.out.println(get_value(r) == 1./67108864);
        if (get_value(r) == 1./67108864) {passed++;} tests++;

        r = r.power(0);
//        System.out.println(get_value(r) == 1);
        if (get_value(r) == 1) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" rational_power " + passed + "/" + tests);
    }

    private Monomial m;
    private Monomial m2;

    // monomial tests
    public void monomial_add() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
        m = new Monomial(1, new Integer(1));
        m2 = m.add(new Monomial(1, new Rational(3, 10)));
//        System.out.println(m2.equals(new Monomial(1, new Rational(13, 10))));
        if (m2.equals(new Monomial(1, new Rational(13, 10)))) {passed++;} tests++;

        m = new Monomial(3, new Integer(3));
        m2 = m.add(new Monomial(3, new Integer(-4)));
//        System.out.println(m2.equals(new Monomial(3, new Integer(-1))));
        if (m2 != null && m2.equals(new Monomial(3, new Integer(-1)))) {passed++;} tests++;

//        System.out.println(m.add(new Monomial(4, new Integer(17))) == null);
        if (m.add(new Monomial(4, new Integer(17))) == null) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" monomial_add " + passed + "/" + tests);
    }

    public void monomial_mul() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
        m = new Monomial(1, new Integer(1));
        m2 = m.mul(new Monomial(3, new Rational(1, 2)));
//        System.out.println(m2.equals(new Monomial(4, new Rational(1, 2))));
        if (m2.equals(new Monomial(4, new Rational(1, 2)))) {passed++;} tests++;

        m = new Monomial(3, new Rational(3, 10));
        m2 = m.mul(new Monomial(0, new Integer(32)));
//        System.out.println(m2.equals(new Monomial(3, new Rational(96, 10))));
        if (m2.equals(new Monomial(3, new Rational(96, 10)))) {passed++;} tests++;

        m2 = m.mul(new Monomial(43, new Integer(0)));
//        System.out.println(m2.equals(new Monomial(46, new Integer(0))));
        if (m2.equals(new Monomial(46, new Integer(0)))) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" monomial_mul " + passed + "/" + tests);

    }

    public void monomial_derivative() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
        m = new Monomial(1, new Integer(1));
        m = m.derivative();
        m2 = new Monomial(0, new Integer(1));
//        System.out.println(m2.equals(m));
        if (m2.equals(m)) {passed++;} tests++;

        m2 = m.derivative();
//        System.out.println(m2.equals(new Monomial(0, new Integer(0))));
        if (m2.equals(new Monomial(0, new Integer(0)))) {passed++;} tests++;

        m = new Monomial(14, new Rational(16, 14));

        m2 = m.derivative();
//        System.out.println(m2.equals(new Monomial(13, new Integer(16))));
        if (m2.equals(new Monomial(13, new Integer(16)))) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" monomial_derivative " + passed + "/" + tests);
    }

    private Polynomial p;
    private Polynomial p2;

    // polynomial tests
    public void polynomial_add() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
//                p = new Polynomial(new Monomial[0]);
//        p = new Polynomial();
        p = Polynomial.build("1");

        p2 = p.add(Polynomial.build("1 0 0 3"));
        System.out.println(p2.equals(Polynomial.build("2 0 0 3 0 0")));
        if (p2.equals(Polynomial.build("2 0 0 3 0 0"))) {passed++;}
        tests++;

        p = Polynomial.build("0 0 0 3 5 0");
        p2 = p.add(Polynomial.build("0 0 0"));
        System.out.println(p2.equals(p));
        if (p2.equals(p)) {passed++;} tests++;

        p2 = p.add(Polynomial.build("3 0 0 3 7 9 0 0 0"));
        System.out.println(p2.equals(Polynomial.build("3 0 0 6 12 9")));
        if (p2.equals(Polynomial.build("3 0 0 6 12 9"))) {passed++;} tests++;

        p2 = p.add(Polynomial.build("0 0 0 -3 5"));
        System.out.println(p2.equals(Polynomial.build("0 0 0 0 10")));
        if (p2.equals(Polynomial.build("0 0 0 0 10"))) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" polynomial_add " + passed + "/" + tests);
    }

    public void polynomial_mul() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
        i = new Integer(0);
        //        p = new Polynomial(new Monomial[0]);
//        p = new Polynomial();
        p = Polynomial.build("1");

        p2 = p.mul(Polynomial.build("1 3 0 4"));
//        System.out.println(p2.equals(Polynomial.build("1 3 0 4")));
        if (p2.equals(Polynomial.build("1 3 0 4"))) {passed++;} tests++;

        p = Polynomial.build("2 0 3 -8 -3");
        p2 = p.mul(Polynomial.build("3 0 -3 4"));
//        System.out.println(p2.equals(Polynomial.build("6 0 3 -16 -18 36 -23 -12")));
        if (p2.equals(Polynomial.build("6 0 3 -16 -18 36 -23 -12"))) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" polynomial_mul " + passed + "/" + tests);
    }

    public void polynomial_derivative() {
        int passed = 0;
        int tests = 0;
//        System.out.println("+++");
//        p = new Polynomial(new Monomial[0]);
//        p = new Polynomial();
        p = Polynomial.build("1");

        p2 = p.derivative();
//        System.out.println(p2.equals(Polynomial.build("0")));
        if (p2.equals(Polynomial.build("0"))) {passed++;} tests++;

        p = Polynomial.build("1 1 1/2 1/3 1/4 0 1/6");
        p2 = p.derivative();
//        System.out.println(p2.equals(Polynomial.build("1 1 1 1 0 1")));
        if (p2.equals(Polynomial.build("1 1 1 1 0 1"))) {passed++;} tests++;

        p = Polynomial.build("0 50 0 0 0 0 0 0 0 13 1/100");
        p2 = p.derivative();
//        System.out.println(p2.equals(Polynomial.build("50 0 0 0 0 0 0 0 117 1/10")));
        if (p2.equals(Polynomial.build("50 0 0 0 0 0 0 0 117 1/10"))) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" polynomial_derivative " + passed + "/" + tests);
    }


    public void polynomial_evaluate() {
        int passed = 0;
        int tests = 0;
        p = Polynomial.build("1");
        //        System.out.println(p2.equals(Polynomial.build("0")));
        if (get_value(p.evaluate(new Integer(0))) == 1) {passed++;} tests++;

        p = Polynomial.build("1 2 3");
        //        System.out.println(p2.equals(Polynomial.build("0")));
        if (get_value(p.evaluate(new Integer(3))) == 34) {passed++;} tests++;

        p = Polynomial.build("5 0 5");
        //        System.out.println(p2.equals(Polynomial.build("0")));
        if (get_value(p.evaluate(new Integer(5))) == 130) {passed++;} tests++;

        total_passed += passed;
        total_tests += tests;

        System.out.println(" polynomial_evaluate " + passed + "/" + tests);
    }
}
