class Outer {
    // 멤버 변수
    int outNum = 100;
    static int sNum = 200;

    // 내부 메서드
    Runnable getRunnable(/* final */ int i) {
        // 지역 변수
        /* final */ int num = 10;

        // 지역 내부 클래스
        class MyRunnable implements Runnable {
            // 멤버 변수
            int localNum = 1000;

            @Override
            public void run() {
                // run() 메서드는 다시 호출될 가능성이 있기 때문에 i(매개 변수)나 num(지역 변수)은 바뀌면 안 된다. 그래서 i나 num은 묵시적으로 final 변수로 선언되어 있다.
                // i = 50;
                // num = 100;

                System.out.println("i = " + i);
                System.out.println("num = " + num);
                System.out.println("localNum = " + localNum);

                System.out.println("outNum = " + outNum + " (외부 클래스 인스턴스 변수)");
                System.out.println("Outer.sNum = " + Outer.sNum + " (외부 클래스 정적 변수)");
            }
        }

        return new MyRunnable();
    }
}

public class AnonymousInnerTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Runnable runnable = outer.getRunnable(100);
        runnable.run(); // run() 메서드를 호출할 때 자세히 보면 MyRunnable 내부 클래스는 호출되는 일이 없다. 그래서 익명 내부 클래스로 선언이 가능하다. (AnonymousInnerTest2.java 참조)

        // 결과
        // i = 100
        // num = 10
        // localNum = 1000
        // outNum = 100 (외부 클래스 인스턴스 변수)
        // Outer.sNum = 200 (외부 클래스 정적 변수)
    }
}
