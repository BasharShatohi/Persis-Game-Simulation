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
public class UtilityFunction {
    public static int calculateUtility(Board board, Player currentPlayer) {
        // احتساب الفائدة (أو الخسارة) حسب الوضع الحالي للوحة واللاعب الحالي
        int currentPlayerPieces = countPlayerPieces(board, currentPlayer);
        int opponentPieces = countOpponentPieces(board, currentPlayer);
        int kitchenPieces = countKitchenPieces(board, currentPlayer);

        // تأخذ عدم تواجد أي قطعة في مطبخ اللاعب نقاطاً إيجابية
        int emptyKitchenPoints = (kitchenPieces == 0) ? 10 : 0;

        // يمكنك إضافة تفاصيل إضافية حسب تصميم لعبتك
        return currentPlayerPieces - opponentPieces + emptyKitchenPoints;
    }

    private static int countPlayerPieces(Board board, Player player) {
        // عدد القطع لدى اللاعب الحالي
        int count = 0;
        // احتساب عدد القطع في الرقعة الخاصة باللاعب
        // يمكنك تخصيص هذا الكود حسب تصميم لعبتك
        return count;
    }

    private static int countOpponentPieces(Board board, Player currentPlayer) {
        // عدد القطع لدى اللاعب الخصم
        int count = 0;
        // احتساب عدد القطع في الرقعة الخاصة بالخصم
        // يمكنك تخصيص هذا الكود حسب تصميم لعبتك
        return count;
    }

    private static int countKitchenPieces(Board board, Player currentPlayer) {
        // عدد القطع في مطبخ اللاعب الحالي
        int count = 0;
        // احتساب عدد القطع في مطبخ اللاعب
        // يمكنك تخصيص هذا الكود حسب تصميم لعبتك
        return count;
    }
}

