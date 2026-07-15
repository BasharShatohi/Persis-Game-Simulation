package Bar;
public class Player {
    private String name;
    private char symbol;
    private PlayerType type;
    private Piece PlayerStones[];
    public Player(String name, char symbol, PlayerType type) {
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
    public PlayerType getType() {
        return type;
    }
    public void setPlayerStones(Piece[] PlayerStones){
        this.PlayerStones=PlayerStones;
    }
    public Piece[] getPlayerStones(){
        return PlayerStones;
    }

    public boolean isEmpty(Piece[] currentPlayerStones) {
    for (int i = 0; i < currentPlayerStones.length; i++) {
        if (currentPlayerStones[i] != null &&
            currentPlayerStones[i].getPlayer() == null &&
            currentPlayerStones[i].getSymbol() == null) {
            return true;
        }
    }
    return false;
}

    
    
}

