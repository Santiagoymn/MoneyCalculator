package Model;

public class Currency {
    private final String code;
    private final String name;
    private String symbol = null;

    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
    
    @Override
    public String toString(){
        if (getSymbol() != null){
            return getCode() + " - " + getName() + " (" + getSymbol() + ")";
        }
        return getCode() + " - " + getName();
    }
}
