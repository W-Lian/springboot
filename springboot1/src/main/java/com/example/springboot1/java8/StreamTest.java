package com.example.springboot1.java8;

import com.example.springboot1.dto.Trader;
import com.example.springboot1.dto.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        Trader raoul=new Trader("Raoul", "Cambridge");
        Trader mario=new Trader("Mario", "Milan");
        Trader alan=new Trader("Alan", "Cambridge");
        Trader brian=new Trader("Brian", "Cambridge");


        List<Transaction> transactions= Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950),
                new Transaction(alan, 2013, 950)
        );

        /**
         * (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
         * (2) 交易员都在哪些不同的城市工作过？
         * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
         * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
         * (5) 有没有交易员是在米兰工作的？
         * (6) 打印生活在剑桥的交易员的所有交易额。
         * (7) 所有交易中，最高的交易额是多少？
         * (8) 找到交易额最小的交易。
         */

        transactions.stream()
                .filter(transaction -> transaction.getYear() != 2012)
                .filter(transaction -> transaction.getYear() != 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(transaction-> System.out.println(transaction));

//        transactions.stream()
//                .map(transaction -> transaction.getTrader().getCity())
//                .distinct()
//                .forEach(transaction-> System.out.println(transaction));

//       List<Trader> traders = transactions.stream()
//                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge") )
//                .sorted(Comparator.comparing(Trader::getName))
//                .forEach(transaction-> System.out.println(transaction));

//        String stringOptional =  transactions.stream()
//                .map(transaction -> transaction.getTrader().getName())
//                .distinct()
//                .sorted()
//                .reduce("",  (n1, n2)-> n1+n2);
//        System.out.println(stringOptional);

//        transactions.stream()
//                .filter(transaction -> transaction.getTrader().getCity() == "Milan")
//                .forEach(transaction-> System.out.println(transaction));

//        transactions.stream()
//                .filter(transaction -> transaction.getTrader().getCity() == "Cambridge")
//                .map(transaction -> transaction.getValue())
//                .forEach(transaction-> System.out.println(transaction));
//
//        Optional<Integer> max = transactions.stream()
//                .map(transaction -> transaction.getValue())
//                .reduce(Integer :: max);
//        System.out.println(max);

//        Optional<Transaction> min = transactions.stream()
//                .min(Comparator.comparing(Transaction::getValue));
//        System.out.println(min);
    }


}
