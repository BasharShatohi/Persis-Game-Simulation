package Bar;
public class Board {
    public Piece [][] grid;
    private int numRows;//length8
    private int numCols;//width3
    private int numMoves;
    public Board(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.grid = new Piece[19][19];
        this.numMoves = 0;
        initializeBoard();
    }
    private void initializeBoard() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                grid[i][j] =new Piece(" ");
            }
        }
        for(int i=0; i<numRows; i++)
        {
            for(int j=numRows;j<numRows+numCols;j++)
            {
                grid[i][j] =new Piece("_");
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j =numRows+numCols; j< numRows+numCols+numRows; j++) {
                grid[i][j] =new Piece(" ");
            }
        }
        
        for(int i=numRows;i<numRows+numCols;i++)
        {
            for(int j=0;j<numRows;j++)
            {
                grid[i][j]=new Piece("_");
            }
        }
        for(int i=numRows;i<numRows+numCols;i++)
        {
            for(int j=numRows;j<numRows+numCols;j++)
            {
                grid[i][j]=new Piece("K");
            }
        }
        for(int i=numRows;i<numRows+numCols;i++)
        {
            for(int j=numRows+numCols;j<numRows+numCols+numRows;j++)
            {
                grid[i][j]=new Piece("_");
            }
        }
        for(int i=numRows+numCols;i<numRows+numCols+numRows;i++)
        {
            for(int j=0;j<numRows;j++)
            {
                grid[i][j]=new Piece(" ");
            }
        }
        for(int i=numRows+numCols;i<numRows+numCols+numRows;i++)
        {
            for(int j=numRows;j<numRows+numCols;j++)
            {
                grid[i][j]=new Piece("_");
            }
        }
        for(int i=numRows+numCols;i<numRows+numCols+numRows;i++)
        {
            for(int j=numRows+numCols;j<numRows+numCols+numRows;j++)
            {
                grid[i][j]=new Piece(" ");
            }
        }
        
        
        
    }
    public void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(grid[i][j].getSymbol()+ " ");
            }
            System.out.println();
        }
    }
    public Piece[] CurrentPlayerStones(Player player){
        Piece [] myStones=player.getPlayerStones();
        Piece [] CurrentStones=new Piece[4];
        for(int i=0;i<myStones.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                for(int k=0;k<grid[j].length;k++)
                {
                    if(grid[j][k].getSymbol().equals(myStones[i].getSymbol()))
                    {
                       // CurrentStones[i].setPlayer(myStones[i].getPlayer());
                      //  CurrentStones[i].setSymbol(myStones[i].getSymbol());
                        CurrentStones[i]=myStones[i];
                    }
                   /* else{
                        CurrentStones[i].setPlayer(null);
                        CurrentStones[i].setSymbol(" ");
                        CurrentStones[i]=null;
                    }*/
                    
                }
            }
        }
        return CurrentStones;
    }
    public void addNewStoneToBoard(Player player){
        if("Player 1".equals(player.getName())){
        Piece[] OStones=player.getPlayerStones();
        Piece[] Stones=CurrentPlayerStones(player);
        for(int i=0;i<player.getPlayerStones().length;i++)
        {
            /*if(Stones[i].getPlayer()==null&&Stones[i].getSymbol()==null)
            {
                grid[7][9].setPlayer(OStones[i].getPlayer());
                grid[7][9].setSymbol(OStones[i].getSymbol());
                break;
            }*/
            // Check if Stones[i] is not null before accessing its methods
        if (Stones[i] == null) {
            // Check if OStones[i] is not null before setting grid values
            if (OStones[i] != null) {
            Stones[i]=OStones[i];
              grid[7][9].setPlayer(OStones[i].getPlayer());
              grid[7][9].setSymbol(OStones[i].getSymbol());
            	
                break;

        }
    
        }
        }
        if("Player 2".equals(player.getName())){
        for(int i=0;i<player.getPlayerStones().length;i++)
        {
            /*if(Stones[i].getPlayer()==null&&Stones[i].getSymbol()==null)
            {
                grid[11][9].setPlayer(OStones[i].getPlayer());
                grid[11][9].setSymbol(OStones[i].getSymbol());
                break;
            }*/
           if (Stones[i] != null && Stones[i].getPlayer() == null && Stones[i].getSymbol() == null) {
            // Check if OStones[i] is not null before setting grid values
            if (OStones[i] != null) {
                grid[11][9].setPlayer(OStones[i].getPlayer());
                grid[11][9].setSymbol(OStones[i].getSymbol());
                break;

        }
           }
        }
    }
        
    }
    }
    public boolean isGameOver(Player player) {
       Piece[] Stones=player.getPlayerStones();
       boolean V[][]=new boolean[3][3];
       int inside=4;
       for(int i=0;i<Stones.length;i++){
         for(int j=8;j<11;j++)
         {
           for(int k=8;k<11;k++)
           {
               if(grid[j][k].getSymbol().equals(Stones[i].getSymbol()))
               {
                   V[j][k]=true;
               }
           }
         }
       }
       for(int i=0;i<V.length;i++)
       {
           for(int j=0;j<V[i].length;j++)
           {
            if(V[i][j]==true)
            {
                inside--;
            }
           }
       }
       if(inside==0)
       {
         return true;
       }
      return false;
    }
    private boolean isValidMove(int row, int col) {
    return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
    public int getNumMoves() {
        return numMoves;
    }
    public void resetBoard() {
        initializeBoard();
        numMoves = 0;
    }
    public int getLength() {
        return numRows;
    }
    public int getWidth() {
        return numCols;
    }
    void displayResult() {
        
    }
    
}
