package br.com.joaogabriel.inner;

public class InnerClassInfo {
    private String some = "Some message";

    class Inner {
        public void print() {
            System.out.println(some);
            System.out.println(this);
            System.out.println(InnerClassInfo.this);
        }
    }

    public static void main(String[] args) {
        InnerClassInfo innerClassInfo = new InnerClassInfo();
        Inner inner = innerClassInfo.new Inner();
        inner.print();
    }
}
