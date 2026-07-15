/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bar;

/**
 *
 * @author Eng Naji
 */
public class Piece {
    private String symbol; // رمز القطعة
    private Player player; // اللاعب الذي يمتلك القطعة

    public Piece(String symbol,Player player) {
        this.symbol = symbol;
        this.player = player;
    }
    public Piece(String symbol)
    {
        this.symbol=symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
   
}

