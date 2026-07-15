package Bar;
public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Player player1 = new Player("Player 1", 'X', PlayerType.HUMAN);
        Player player2 = new Player("Player 2", 'O', PlayerType.COMPUTER);
        Piece X1=new Piece("X1",player1);
        Piece X2=new Piece("X2",player1);
        Piece X3=new Piece("X3",player1);
        Piece X4=new Piece("X4",player1);
        Piece O1=new Piece("O1",player2);
        Piece O2=new Piece("O2",player2);
        Piece O3=new Piece("O3",player2);
        Piece O4=new Piece("O4",player2);
        Piece Stones1[]={X1,X2,X3,X4};
        Piece Stones2[]={O1,O2,O3,O4};
        player1.setPlayerStones(Stones1);
        player2.setPlayerStones(Stones2);
        int length = 8;
        int width = 3;
        Board board = new Board(length, width);
        gameController.setBoard(board);
        gameController.setPlayers(player1, player2);
        gameController.startGame();
    }
}




