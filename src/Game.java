import java.util.Scanner;

public class Game
{
    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int col;
    private static int row;

    public static void main(String[] args)
    {
        ox = new OX();
        while (true)
        {
            printTableOX();
            input();
            if(ox.checkWin(col,row))
            {
                printTableOX();
                System.out.println(ox.getCurrentPlayer() + " " + "WIN");
                System.out.println("Score X :" + ox.getScoreX());
                System.out.println("Score O :" + ox.getScoreO());
                System.out.println("Draw :" + ox.getScoreDraw());
                ox.reset();
                continue;
            }
            if(ox.isDraw())
            {
                printTableOX();
                System.out.println("DRAW");
                System.out.println("Score X :" + ox.getScoreX());
                System.out.println("Score O :" + ox.getScoreO());
                System.out.println("Draw :" + ox.getScoreDraw());
                ox.reset();
                continue;
            }
            ox.switchPlayer();

        }

    }

    private static void input()
    {
        boolean canPut = true;
        do {
            System.out.print(ox.getCurrentPlayer() + " Col :");
            col = sc.nextInt();
            System.out.print(ox.getCurrentPlayer() + " Row :");
            row = sc.nextInt();
            canPut = ox.put(col,row);
            if(!canPut)
            {
                System.out.println("Please input number betwenn 0-2");
            }
        } while (!canPut);
    }

    private static void printTableOX() {
        System.out.print(ox.getTableString());
    }
}
