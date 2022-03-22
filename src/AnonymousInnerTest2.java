class Outer2 {
    // 멤버 변수
    int outNum = 100;
    static int sNum = 200;

    // 내부 메서드
    Runnable getRunnable(/* final */ int i) { // 해당 메서드에서 선언된 클래스는 하나밖에 없기 때문에 익명 내부 클래스로 선언할 수 있다.
        // 지역 변수
        /* final */ int num = 10;

        return new Runnable() {
            // 멤버 변수
            int localNum = 1000;

            @Override
            public void run() {
                System.out.println("i = " + i);
                System.out.println("num = " + num);
                System.out.println("localNum = " + localNum);

                System.out.println("outNum = " + outNum + " (외부 클래스 인스턴스 변수)");
                System.out.println("Outer.sNum = " + Outer2.sNum + " (외부 클래스 정적 변수)");
                System.out.println();
            }
        }; // 해당 메서드를 ;으로 마무리 지어준다.
    }

    // 내부 메서드
    Runnable runnable2 = new Runnable() { // 또 다른 익명 내부 클래스 선언
        @Override
        public void run() {
            System.out.println("Runnable class");
        }
    };
}

public class AnonymousInnerTest2 {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        Runnable runnable = outer2.getRunnable(100);
        runnable.run();

        outer2.runnable2.run();

        // 결과
        // i = 100
        // num = 10
        // localNum = 1000
        // outNum = 100 (외부 클래스 인스턴스 변수)
        // Outer.sNum = 200 (외부 클래스 정적 변수)
        //
        // Runnable class
    }
}
