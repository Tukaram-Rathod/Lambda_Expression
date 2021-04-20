package com.math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberPlayList {
    public static void main(String[] args) {
        //creating sample collection
        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i=0; i<5;i++) myNumberList.add(i);

        //Method 1: traversing uding Iterator
        Iterator<Integer> it = myNumberList.iterator();
        while (it.hasNext()){
            Integer i = it.next();
            System.out.println("Iterator Value:"+i);
        }
        //Method 2: Traversing with Consumer interface implementation
        class MyConsumer implements Consumer<Integer>{
            public void accept(Integer t){
                System.out.println("Mth2:Consumer impl Value::"+t );
            }
        }
        MyConsumer action = new MyConsumer();
        myNumberList.forEach(action);

        //Method 3: traversing with Anonymous Consumer interface implementation
        myNumberList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println("Mth3: forEach anonymous class Value::"+t);
            }
        });

        //Method 4: Explicit Lambda Function
        Consumer<Integer>myListAction = n->{
            System.out.println("Mth4: forEach Lambda impl Value::"+n);

        };
        myNumberList.forEach(myListAction);

        //method 5 :Implcit Lambda Function
        myNumberList.forEach (n->{
            System.out.println("Mth5: forEach Llambda imp Value::"+n);
        });

        //Method 6: forEach Lambda  Function  to print double value
        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        myNumberList.forEach(n->{
            System.out.println("Mth6 forEach Lambda double Value::"+toDoubleFunction.apply(n));
        });

        //Method  7: Implicit Lambda Function to Check even
        Predicate<Integer> isEvenFunction = n-> n%2 ==0;
        myNumberList.forEach(n->{
            System.out.println("Mth7: forEach value of:"+isEvenFunction.test(n));
        });
    }

}
