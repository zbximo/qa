package com.example.zuccqa;


import org.springframework.beans.BeanUtils;

/**
 * @author: ximo
 * @date: 2022/5/3 13:54
 * @description:
 */
public class test {
    static class A {
        public int x;
        public int b;

        public A() {

        }

        public A(int x, int b) {
            this.x = x;
            this.b = b;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "A{" +
                    "x=" + x +
                    ", b=" + b +
                    '}';
        }
    }

    static class B {
        public int x;
        public int b;
        public int a;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public B() {

        }

        public B(int x, int b, int a) {
            this.x = x;
            this.b = b;
            this.a = a;
        }

        @Override
        public String toString() {
            return "B{" +
                    "x=" + x +
                    ", b=" + b +
                    ", a=" + a +
                    '}';
        }
    }

    public static void main(String[] args) {
        A a = new A(1, 2);
        A a1 = new A();
        B b = new B(1,3,4);
        BeanUtils.copyProperties(b, a);
        System.out.println(a);

    }
}
