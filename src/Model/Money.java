package Model;

public class Money {
    private final double Amount;
    private final Currency currency;
        
    public Money(double Amount, Currency currency) {
        this.Amount = Amount;
        this.currency = currency;
    }

    public double getAmount() {
        return Amount;
    }

    public Currency getCurrency() {
        return currency;
    }
    
    @Override
    public String toString(){
        if (currency.getSymbol() != null){
            return Amount + " " + currency.getSymbol() + " (" + currency.getName() + ")";
        }
        return Amount + " " + currency.getCode() + " - " + currency.getName();
    }

}
