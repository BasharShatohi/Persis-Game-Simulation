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
public class Move {
    private Piece stone;
    private int fromRow; // صف القطعة المراد تحريكها
    private int fromCol; // عمود القطعة المراد تحريكها
    private int toRow; // الصف الجديد للقطعة
    private int toCol; // العمود الجديد للقطعة
    private int dice;
    private Board board;
    private final int G1[][]=new int[19][19];
    public Move(Board board)
    {
        this.board=board;
        this.G1();
    }
    public int getFromRow() {
        return fromRow;
    }
    public int getFromCol() {
        return fromCol;
    }
    public int getToRow() {
        return toRow;
    }
    public int getToCol() {
        return toCol;
    }
    public void move(Piece stone,int[] number,int dice)
    {
       this.stone=stone;
       this.fromRow=number[0];
       this.fromCol=number[1];
       this.dice=dice;
       switch(dice)
       {
           case 1:
           {
               moveDast(10);
               break;
           }
           case 2:
           {
               moveDowak(2);
               break;
           }
           case 3:
           {
               moveAlthalatha(3);
               break;
           }
           case 4:
           {
               moveArbaa(4);
               break;
           }
           case 5:
           {
               moveAlbanj(24);
               break;
           }
           case 6:
           {
               moveAlshakaa(6);
               
           }
           case 7:
           {
               moveAlbaraa(12);
           }
               
       }
    }
    void moveDast(int value) {
       int S=G1[this.fromRow][this.fromCol]+value;
       cal(S);
       change(this.toRow,this.toCol);
       
    }

    void moveUncle(int value) {
       int S=G1[this.fromRow][this.fromCol]+value;
       cal(S);
       change(this.toRow,this.toCol);
    }

    void moveDowak(int value) {
       int S=G1[this.fromRow][this.fromCol]+value;
       cal(S);
       change(this.toRow,this.toCol);
    }

    void moveAlthalatha(int value) {
        int S=G1[this.fromRow][this.fromCol]+value;
        cal(S);
        change(this.toRow,this.toCol);
    }

    void moveArbaa(int value) {
        int S=G1[this.fromRow][this.fromCol]+value;
        cal(S);
        change(this.toRow,this.toCol);
    }

    void moveAlbanj(int value) {
        int S=G1[this.fromRow][this.fromCol]+value;
        cal(S);
        change(this.toRow,this.toCol);
    }

    void moveAlshakaa(int value) {
        int S=G1[this.fromRow][this.fromCol]+value;
        cal(S);
        change(this.toRow,this.toCol);
    }

    void moveAlbaraa(int value) {
        int S=G1[this.fromRow][this.fromCol]+value;
        cal(S);
        change(this.toRow,this.toCol);
    }
    public void cal(int S)
    {
        for(int i=0;i<G1.length;i++)
        {
            for(int j=0;j<G1[i].length;j++)
            {
                if(G1[i][j]==S)
                {
                    this.toRow=i;
                    this.toCol=j;
                }
            }
        }
        
    }
    public void G1(){
        int value=0;
        for(int i=7;i>=0;i--)
        {
            G1[i][9]=value;
            value+=1;
        }
        value=8;
        for(int i=0;i<=7;i++)
        {
            G1[i][8]=value;
            value+=1;
        }
        value=16;
        for(int i=7;i>=0;i--)
        {
            G1[8][i]=value;
            value+=1;
        }
        G1[9][0]=24;
        value=25;
        for(int i=0;i<=7;i++)
        {
            G1[10][i]=value;
            value+=1;
        }
        value=33;
        for(int i=11;i<=18;i++)
        {
            G1[i][8]=value;
            value+=1;
        }
        G1[18][9]=41;
        value=42;
        for(int i=18;i>=11;i--)
        {
            G1[i][8]=value;
            value+=1;
        }
        value=50;
        for(int i=11;i<=18;i++)
        {
            G1[10][i]=value;
            value+=1;
        }
        G1[9][18]=58;
        value=59;
        for(int i=18;i>=11;i--)
        {  
            G1[8][i]=value;
            value+=1;  
        }
        value=67;
        for(int i=7;i>=0;i--)
        {
            G1[i][10]=value;
            value+=1;
        }

        
    }

    private void change(int toRow, int toCol) {
       String p=board.grid[toRow][toCol].getSymbol();
       board.grid[toRow][toCol].setSymbol(board.grid[fromRow][fromCol].getSymbol());
       board.grid[fromRow][fromCol].setSymbol(p);
       /*Piece p=board.grid[toRow][toCol];
       board.grid[toRow][toCol]=board.grid[fromRow][fromCol];
       board.grid[fromRow][fromCol]=p;*/
    }
}


