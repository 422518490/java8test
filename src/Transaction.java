/**
 * @author liaoyubo
 * @version 1.0
 * @date 2018/8/28
 * @description
 */
public class Transaction {

    private Currency currency;

    private Integer totalMoney;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }
}
