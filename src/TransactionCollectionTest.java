import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * @author liaoyubo
 * @version 1.0
 * @date 2018/8/28
 * @description
 */
public class TransactionCollectionTest {

    public static   void main(String [] args){
        List<Transaction> transactions = Arrays.asList(new Transaction() ,new Transaction());
        // 按照币种统计数据
        transactions.stream().collect(groupingBy(Transaction::getCurrency));

        // 求和

        transactions.stream().collect(summarizingInt(Transaction::getTotalMoney));
        transactions.stream().map(Transaction::getTotalMoney).reduce(Integer::sum).get();
        transactions.stream().mapToInt(Transaction::getTotalMoney).sum();

        // 求平均值
        transactions.stream().collect(averagingInt(Transaction::getTotalMoney));

        // 求最大值
        transactions.stream().collect(maxBy(Comparator.comparingInt(Transaction::getTotalMoney)));

        // 连接字符串
        transactions.stream().map(Transaction::getCurrency).map(Currency::getName).collect(joining(","));

        transactions.stream()
                .collect(groupingBy(Transaction::getCurrency
                ,collectingAndThen(maxBy(Comparator.comparingInt(Transaction::getTotalMoney)), Optional::get)));
    }
}
