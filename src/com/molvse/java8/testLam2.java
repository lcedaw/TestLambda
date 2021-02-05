package com.molvse.java8;

import com.molvse.java8.entity.Employee;
import com.molvse.java8.service.MathPridicate;
import com.molvse.java8.service.StrPridicate;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class testLam2 {

    List<Employee> list = Arrays.asList(
            new Employee("张三",18,555.55),
            new Employee("李四",18,666.66)
    );

    /**
     * lambda:无参数无返回值
     */
    @Test
    public void test(){
        Runnable r = () -> {
            System.out.println("test");
        };
        r.run();

        Runnable r1 = () -> System.out.println("test");
    }

    /**
     * lambda: 有参数无返回值
     */
    @Test
    public void test1(){
        Consumer<String> a = (x) -> System.out.println(x);
        a.accept("墨绿色");
    }

    /**
     * lambda:有多个参数，有返回值，有多行语句
     */
    @Test
    public void test2(){
        Comparator<Integer> comparator = (x,y) -> {
            System.out.println("多行语句");
            return Integer.compare(x, y);
        };
        System.out.println(comparator.compare(1,2));
    }

    /**
     * lambda: 有返回值并且只有一行，可以省略{}和return
     * lambda参数列表中的数据类型可以不写，因为jvm会根据上下文推断出数据类型，即“类型推断”
     */
    @Test
    public void test3(){
//        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        //与上一条语句等价
        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(1,5));
    }

    @Test
    public void test4(){
        Comparator<Employee> comparator = (e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return -e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        };
        Collections.sort(list, comparator);
        list.forEach(System.out::println);
    }

    @Test
    public void test5(){
        String str = "juchengse";
        StrPridicate p = s -> s.substring(0,1).toUpperCase();
        String res = testStr(str, p);
        System.out.println(res);

        String subRes = testStr(str, s -> s.substring(2,4));
        System.out.println(subRes);

        Long l1 = 4L;
        Long l2 = 5L;
        Long lres = testMath(l1,l2,(t1,t2) -> {
            return t1 + t2;
        });
        System.out.println(lres);
    }

    private String testStr(String str,StrPridicate p){
        return p.getValue(str);
    }

    private Long testMath(long l1, long l2, MathPridicate<Long, Long> m){
        return m.getValue(l1, l2);
    }
}
