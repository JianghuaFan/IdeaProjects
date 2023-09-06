package cisco;

import java.util.Scanner;

public class PrintChessBoardBlackWhite {
    public static void printChessBoard(int a){
        char[][] board = new char[a][a];
        for(int i = 0; i < a ; i++){
            for(int j = 0; j < a; j++){
                if((i + j) % 2 == 0){
                    System.out.print('W');
                }else{
                    System.out.print('B');
                }
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        printChessBoard(num);
    }
}
