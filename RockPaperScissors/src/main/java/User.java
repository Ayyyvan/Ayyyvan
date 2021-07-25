import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class User {
    private List<String> moves;
    private int index;

    public User(List<String> moves) {
        this.moves = moves;
    }

    public String getMove() {
        printAvailableMoves();
        Scanner inputScanner = new Scanner(System.in);
        try {
            int userInput = inputScanner.nextInt();
            if (userInput == 0) {System.exit(0);}
                    index = userInput - 1;
                    return moves.get(index);
        }
        catch (InputMismatchException ex) {
            System.out.println("Please, enter the NUMBER of move");
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Wrong move!\n ");
        }
        return getMove();
    }

    public List<String> winList(){
        List<String> win = new ArrayList<>();
        int half = moves.size()/2;

        if (index <= half){
            win = moves.subList(index + 1, index + half + 1);
            return win;
        }
        win.addAll(moves);
        if (index >= index - half) {
            win.subList(index - half, index + 1).clear();
        }
        return win;
    }

    public void printAvailableMoves(){
        System.out.print("Available moves:\n");
        for (int i = 1; i <= moves.size(); i++){
            System.out.println(i + " - " + moves.get(i-1));
        }
        System.out.print("0 - Exit\nEnter your move: ");
    }
}

