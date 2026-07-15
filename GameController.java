
package Bar;

import java.util.Random;
import java.util.Scanner;
public class GameController {
    private Board board;
    private Player player1;
    private Player player2;
    private Scanner scanner;
    private static final Random random = new Random();
    private int X;
    private int Y;

    public GameController() {
        this.scanner = new Scanner(System.in);
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public void startGame() {
        boolean gameOver = false;

        while (!gameOver) {
            board.printBoard();
            
            Player currentPlayer = getCurrentPlayer();
            makeMove(currentPlayer);

            if(board.isGameOver(player1)==true ||board.isGameOver(player2)==true)
            {
                gameOver=true;
            }
            else{
                gameOver=false;
            }
            switchPlayers();
        }

        board.printBoard();
        board.displayResult();
    }
    private Player getCurrentPlayer() {
        return (board.getNumMoves() % 2 == 0) ? player1 : player2;
    }
    private void makeMove(Player player) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Player " + player.getName() + ", it's your turn.");
        Piece[] currentPlayerStones=board.CurrentPlayerStones(player);
        System.out.println("Throw Your dice:");
        int diceValue =rollDice();
        int stoneToMove;
        Move move=new Move(board);
        switch (diceValue) {
            case 1: // Dast
            {
                System.out.println("Player " + player.getName()+ " got Dast!");
                if(player.isEmpty(currentPlayerStones))
                {
                    board.addNewStoneToBoard(player);
                    Piece[] c=board.CurrentPlayerStones(player);
                    move.move(c[0],findLocation(currentPlayerStones[0]),diceValue);
                    board.printBoard();
                }
                else{
                board.printBoard();
                System.out.print("Enter the index of the Piece you want to move: ");
                stoneToMove = scanner.nextInt();
                move.move(currentPlayerStones[stoneToMove],findLocation(currentPlayerStones[stoneToMove]),diceValue);
                board.printBoard();
                System.out.print("Do you want to move an extra step? (yes/no): ");
                boolean playerWantsExtraStep = scanner.nextBoolean();
                if (playerWantsExtraStep) {
                    stoneToMove=scanner.nextInt();
                   // Move.moveUncle(currentPlayerStones[stoneToMove]);
                } else {
                    board.addNewStoneToBoard(player);
                }
                board.printBoard();
                }
                break;
            }
                
                case 2: // Dowak
                {
                System.out.println("Player " + player + " got Dowak!");
                board.printBoard();
                System.out.print("Enter the index of the stone you want to move: ");
                stoneToMove = scanner.nextInt();
                move.move(currentPlayerStones[stoneToMove],findLocation(currentPlayerStones[stoneToMove]),diceValue);
                board.printBoard();
                break;
                }
                
                case 3:// Althalatha
                {
                System.out.println("Player " + player + " got Althalatha!");
                board.printBoard();
                System.out.print("Enter the index of the stone you want to move: ");
                stoneToMove = scanner.nextInt();
                move.move(currentPlayerStones[stoneToMove],findLocation(currentPlayerStones[stoneToMove]),diceValue);
                board.printBoard();
            break;
                }
                
            case 4: //Arbaa
            {
            System.out.println("Player " + player + " got Arbaa!");
            board.printBoard();
            System.out.print("Enter the index of the stone you want to move: ");
            stoneToMove = scanner.nextInt();
            move.move(currentPlayerStones[stoneToMove],findLocation(currentPlayerStones[stoneToMove]),diceValue);
            board.printBoard();
            break;
            }
            case 5:  // Albanj
            {
                System.out.println("Player " + player.getName()+ " got Albanj!");
                if(player.isEmpty(currentPlayerStones))
                {
                    board.addNewStoneToBoard(player);
                    board.printBoard();
                }
                else{
                board.printBoard();
                System.out.print("Enter the index of the Piece you want to move: ");
                stoneToMove = scanner.nextInt();
                move.move(currentPlayerStones[stoneToMove],findLocation(currentPlayerStones[stoneToMove]),diceValue);
                board.printBoard();
                System.out.print("Do you want to move an extra step? (true/false): ");
                boolean playerWantsExtraStep = scanner.nextBoolean();
                if (playerWantsExtraStep) {
                    stoneToMove=scanner.nextInt();
                   // Move.moveUncle(currentPlayerStones[stoneToMove]);
                } else {
                    board.addNewStoneToBoard(player);
                }
                board.printBoard();
                }
                break;
            }
            case 6: // Alshakaa
            {
            System.out.println("Player " + player + " got Alshakaa!");
            board.printBoard();
            System.out.print("Enter the index of the stone you want to move: ");
            stoneToMove = scanner.nextInt();
            move.move(currentPlayerStones[stoneToMove],findLocation(currentPlayerStones[stoneToMove]),diceValue);
            board.printBoard();
            break;
            }
            case 7:  // Albaraa
            {
            System.out.println("Player " + player + " got Albaraa!");
            board.printBoard();
            System.out.print("Enter the index of the stone you want to move: ");
            stoneToMove = scanner.nextInt();
            move.move(currentPlayerStones[stoneToMove],findLocation(currentPlayerStones[stoneToMove]),diceValue);
            board.printBoard();
            break;
            }

            default:
                System.out.println("Invalid dice value!");
                break ;
        }
    }
    private int rollDice(){
        
       int moveType = random.nextInt(729);
       if (moveType < 12) {
            return 1;
        } else if (12<moveType && moveType <60+12) {
            return 2;
        } else if (60+12<moveType && moveType <12+60+160) {
            return 3;
        } else if (12+60+160<moveType && moveType<12+60+160+ 240) {
            return 4;
        } else if (12+60+160+ 240<moveType && moveType<12+60+160+240+192) {
            return 5;
        } else if (12+60+160+240+192<moveType && moveType<12+60+160+240+192+1){
            return 6;
        } else {
            return 7;
        }
    }
    private void switchPlayers() {
        Player temp = player1;
        player1 = player2;
        player2 = temp;
    }
    public int[] findLocation(Piece stone){
        int A[]=new int[2];
        for (int i = 0; i < board.grid.length; i++) {
    for (int j = 0; j < board.grid[i].length; j++) {
        if (board.grid[i][j] != null) {
            // Add a null check for board.grid[i][j].getSymbol()
            if (stone != null && board.grid[i][j].getSymbol() != null && 
                board.grid[i][j].getSymbol().equals(stone.getSymbol())) {
                this.X = i;
                this.Y = j;
            }
        }
    }
}

        /*for(int i=0;i<board.grid.length;i++)
        {
            for(int j=0;j<board.grid[i].length;j++)
            {
                if(board.grid[i][j]!=null)
                {
                    if(board.grid[i][j].getSymbol()==stone.getSymbol())
                    {
                    this.X=i;
                    this.Y=j;
                    }
                }
            }
        }*/
        A[0]=this.X;
        A[1]=this.Y;
        return A;
    }
    
}


