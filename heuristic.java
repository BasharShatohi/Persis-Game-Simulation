 private int evaluateHeuristic(int[] playerStonesInKitchen) {
        // You can customize the heuristic based on your strategy
        // For example, you might use the count of stones in the kitchen for each player
        return playerStonesInKitchen[0] - playerStonesInKitchen[1];
    }
    private boolean isInKitchen(int row, int col) {
    // Assuming the kitchen is in the center of the board
    int boardSize = 8;  // Adjust this based on your actual board size
    int kitchenSize = 3;  // Assuming the kitchen is a 3x3 square in the center

    int kitchenStartRow = (boardSize - kitchenSize) / 2;
    int kitchenEndRow = kitchenStartRow + kitchenSize - 1;

    int kitchenStartCol = (boardSize - kitchenSize) / 2;
    int kitchenEndCol = kitchenStartCol + kitchenSize - 1;

    // Check if the position is within the kitchen area
    return row >= kitchenStartRow && row <= kitchenEndRow &&
           col >= kitchenStartCol && col <= kitchenEndCol;
}

    private int countStonesInKitchen(char[][] board, char player) {
        int stonesInKitchen = 0;
    
        // Iterate through the board to count stones in the kitchen for the specified player
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == player && isInKitchen(row, col)) {
                    stonesInKitchen++;
                }
            }
        }
    
        return stonesInKitchen;
    }

    // Example: Evaluate heuristic for the current game state
    int[] playerStonesInKitchen = {countStonesInKitchen(player1Stones), countStonesInKitchen(player2Stones);
    int heuristicValue = evaluateHeuristic(playerStonesInKitchen) ;

    // Example: Make a move based on the heuristic value
    if (heuristicValue > 0) {
        // Player 1 has an advantage, make a move accordingly
    } else if (heuristicValue < 0) {
        // Player 2 has an advantage, make a move accordingly
    } else {
        // Heuristic value is zero, the game is balanced, make a move accordingly
    }