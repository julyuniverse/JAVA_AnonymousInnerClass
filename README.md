# 익명 내부 클래스의 활용

## 지역 내부 클래스

- 지역 변수와 같이 메서드 내부에서 정의하여 사용하는 클래스
- 메서드의 호출이 끝나면 메서드에 사용된 지역변수의 유효성은 사라짐.
- 메서드 호출 이후에도 사용해야 하는 경우가 있을 수 있으므로 지역 내부 클래스에서 사용하는 메서드의 지역 변수나 매개 변수는 final로 선언됨.
- MyRunnable 클래스를 사용하려면 직접 생성하는 것이 아닌 getRunnable() 메서드를 호출하여 생성된 개체를 반환 받아야 함.

## 익명 내부 클래스

- 이름이 없는 클래스 (위 지역 내부 클래스의 MyRunnable 클래스 이름은 실제로 호출되는 경우가 없음)
- 클래스의 이름을 생략하고 주로 하나의 인터페이스나 하나의 추상 클래스를 구현하여 반환.
- 인터페이스나 추상 클래스 자료형의 변수에 직접 대입하여 클래스를 생성하거나 지역 내부 클래스의 메서드 내부에서 생성하여 반환할 수 있음.
- android에서 widget의 이벤트 핸들러에 활용됨.
```java
button1.setOnClickListener(new View.OnClickListener() {
    public boolean onClick(View v) {
        Toast.makeText(getBaseContext(), "hello", Toast.LENGTH_LONG).show();
        return true;
    }
});
```
