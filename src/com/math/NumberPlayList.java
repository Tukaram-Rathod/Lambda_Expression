package com.math;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
       Function<Integer,Double>toDoubleFunction = Integer::doubleValue;
       Predicate<Integer>isEvenFunction = n -> n > 0 && n%2 == 0;
       List<Double> doublesArrayList = new ArrayList<Double>();
       List<Double> evenList = new ArrayList<Double>();
       myNumberList.forEach(n->{
            doublesArrayList.add(toDoubleFunction.apply(n));
       });
       doublesArrayList.forEach(n ->{
           if (isEvenFunction.test(n.intValue()))
               evenList.add(n);
       });
        System.out.println("Even list:"+evenList);

       //Method  7: Implicit Lambda Function to Check even
       myNumberList.forEach(n->{
            System.out.println("Mth7: forEach value of:"+n+"Check for Even:"+isEvenFunction.test(n));
        });
       //Method 8: Processing the Stream
       myNumberList.stream().forEach(n ->{
            System.out.println("Mth8: Stream forEach Value:"+n);
        });
       //Method 9: Processing the Stream ,Apply Operation on the Stream and then  Strore the Result
        //collect function
       List<Double> doubleList = myNumberList.stream()
                                       .filter(isEvenFunction)
                                       .peek(n -> System.out.println("peak Even Number :"+n ))
                                       .map(toDoubleFunction)
                                       .collect(Collectors.toList());
        System.out.println("Mth9: Printing Doouble List:" +doubleList);

       //Method 10: Listing the first even elements
       Integer first = myNumberList.stream()
                        .filter(isEvenFunction)
                        .peek(n -> System.out.println("peak Even Number :"+n))
                        .findFirst()
                        .orElse(null);
       System.out.println("Mth10: First Even: "+first);

       //Method 11:Minimum Even Number
        Integer min = myNumberList.stream()
                .filter(isEvenFunction)
                .min((n1,n2) -> n1-n2)
                .orElse(null);
        System.out.println("Mth11: Min Even: "+min);

        //Method 12:Maximum Even Number
        Integer max = myNumberList.stream()
                .filter(isEvenFunction)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(null);
        System.out.println("Mth12: max Even: "+max);

        //Method 13.Sum ,Count and Average pf numbers
        Integer sum = myNumberList.stream()
                .reduce(0,Integer::sum);
        long count = myNumberList.stream().count();
        System.out.println("Mth13: Avg of "+sum+ "/"+count+" = "+sum/count);
    }
    
}
