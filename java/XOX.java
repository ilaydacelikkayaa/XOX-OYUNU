import java.util.Scanner;
//XOX OYUNU JAVADA 
public class XOX {
    private static char[][] tahta = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
    private static char player = 'X'; 

    public static void main(String[] args) {
        while (true) {
            yerlestir();
            tahtagoster();
            if (kazanan() || tahtadolu()) {
                tahtagoster();
                System.out.println("Oyun bitti! "+player+" kazandi");
                break;
            }
            oyuncusec();
        }
    }

    public static void tahtagoster() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tahta[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }

    private static void yerlestir() {
        Scanner scanner = new Scanner(System.in);
        int satir, sutun;

        System.out.println("Player " + player + " hareketini gir (satır sutun olarak): ");
        satir = scanner.nextInt() - 1;
        sutun = scanner.nextInt() - 1;

        if (gecerlihareket(satir, sutun)) {
            tahta[satir][sutun] = player;
        } else {
            System.out.println("Geçersiz hareket. Tekrar deneyin.");
            yerlestir();
        }
    }

    private static boolean gecerlihareket(int satir, int sutun) {
        return satir >= 0 && satir < 3 && sutun >= 0 && sutun < 3 && tahta[satir][sutun] == ' ';
    }

    private static boolean kazanan() {
        return satirkontrol() || sutunkontrol() || kosegenkontrol();
    }

    private static boolean satirkontrol() {
        for (int i = 0; i < 3; i++) {
            if (tahta[i][0] == player && tahta[i][1] == player && tahta[i][2] == player) {
                return true;
            }
        }
        return false;
    }

    private static boolean sutunkontrol() {
        for (int i = 0; i < 3; i++) {
            if (tahta[0][i] == player && tahta[1][i] == player && tahta[2][i] == player) {
                return true;
            }
        }
        return false;
    }

    private static boolean kosegenkontrol() {
        return (tahta[0][0] == player && tahta[1][1] == player && tahta[2][2] == player)
                || (tahta[0][2] == player && tahta[1][1] == player && tahta[2][0] == player);
    }

    private static boolean tahtadolu() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tahta[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void oyuncusec() {
        player = (player == 'X') ? 'O' : 'X';
    }
}