import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Set<String> moveSet = new HashSet<>(Arrays.asList(args));
        if (args.length % 2 == 0 || args.length <= 1 || args.length != moveSet.size()) {
            System.out.println("Something wrong! Check all the rules and launch it again! \n" +
                    "1. Number of moves must be odd and > 1\n" +
                    "2. All moves must be unique\n" +
                    "Try 'java -jar game.jar 1 2 3' or 'java -jar game.jar rock paper scissors lizard Spock'");
            System.exit(0);
        }
        ArrayList<String> moves = new ArrayList<>(Arrays.asList(args));
        RockPaperScissors rockPaperScissors = new RockPaperScissors(moves);
        rockPaperScissors.startGame();





    }
}
