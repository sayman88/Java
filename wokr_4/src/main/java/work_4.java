import org.omg.CosNaming.BindingIterator;

import java.util.Random;
import java.util.Scanner;

public class work_4 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static char[][] table;
    static int size = 3;
    static final char xMark = 'X';
    static final char oMark = 'O';
    static final char empty = '.';

    public static void main(String[] args) {
       initTable();
       printTable();

       while (true) {
           turnHuman();
           printTable();
           if (checkWin(xMark)){
               System.out.println("Human won");
               break;
           }
           if (tableIsFulll()){
            System.out.println("DRAW!");
            break;
           }

           turnAI();
           printTable();
           if (checkWin(oMark)){
               System.out.println("Computer won");
               break;
           }
       }
    }

    private static boolean tableIsFulll() {
       for (int i = 0; i < size; i++){
           for (int j = 0; j < size; j++){
               if(table[i][j] == empty) return false;
           }
        }
       return true;
    }

    private static boolean checkWin(char symbol){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (checkLine(i, j, 0, 1, symbol)) return true;
                if (checkLine(i, j, 1, 1, symbol)) return true;
                if (checkLine(i, j, 1, 0, symbol)) return true;
                if (checkLine(i, j, -1, 1, symbol)) return true;
            }
        }
        return false;
    }

    private static boolean checkLine(int y, int x, int yDirection, int xDirection, char symbol) {
        int wayX = x + (size - 1) * xDirection;
        int wayY = y + (size - 1) * yDirection;
        if (wayX < 0 || wayY < 0 || wayX > size - 1 || wayY > size - 1) return false;
        for (int i = 0; i < size; i++) {
            if (table[y + i * yDirection][x + i * xDirection] != symbol) return false;
        }
        return true;
    }

    private static void printTable() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void initTable(){
      table = new char[size][size];
      for(int i = 0; i < table.length; i++){
          for (int j = 0; j < table.length; j++){
              table[i][j] = empty;
          }
        }
    }
    private static void turnHuman() {
        int x, y;

        do {
            System.out.println("Enter x y from 1 to 3");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidCell(x, y));
        table[x][y] = xMark;

    }
    private static boolean isValidCell(int x, int y){

        if (x >= size || y > size || x < 0 || y < 0) return false;
        if (table[x][y] == empty) return true;
        return false;
    }
    private static void turnAI(){
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isValidCell(x, y));

        System.out.println("Computer filled [" + (x+1) + ", " + (y+1) + " ]");
        table[x][y] = oMark;
    }
}
