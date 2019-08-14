package top.felixu.grass.common.core.utils;

import java.lang.reflect.Field;

/**
 * @author felixu
 * @date 2019.08.13
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Integer a = Integer.parseInt("10");
        Integer b = Integer.valueOf(10);
        Integer c = 10;
        changeValue(a, 100);
        changeValue(b, 200);
        changeValue(c, 300);
        System.out.printf("%d %d %d", a, b, c);
    }

    private static void changeValue(Integer i, int value) throws Exception {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(i, value);
    }

//    public static void main(String[] args) {
//        int a = 10;
//        int b = 10;
//        method(a, b);
//        System.out.println("a=" + a);
//        System.out.println("b=" + b);
//    }
//
//    private static void method(int a, int b) {
//        System.setOut(new PrintStream(System.out) {
//
//            @Override
//            public void println(String value) {
//                switch (value) {
//                    case "a=10":
//                        super.println("a=200");
//                        break;
//                    case "b=10":
//                        super.println("b=200");
//                        break;
//                    default:
//                        super.println(value);
//                }
//            }
//        });
//    }


//    private static void method(Integer a, Integer b) {
//        change(a, 200);
//        change(b, 200);
//    }
//
//    private static void change(Integer i, int value) {
//        try {
//            Field field = Integer.class.getDeclaredField("value");
//            field.setAccessible(true);
//            field.set(i, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
