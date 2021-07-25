import java.util.List;

public class RockPaperScissors {
    private User user;
    private Computer computer;

    public RockPaperScissors(List<String> moves) {
        user = new User(moves);
        computer = new Computer(moves);
    }

    public void startGame() {
            String computerMove = computer.getMove();
            System.out.println("HMAC: " + computer.getHmac());
            String userMove = user.getMove();

            System.out.println("\nYour move:  " + userMove);
            System.out.println("Computer move:  " + computerMove);

            if (computerMove.equals(userMove)){
                System.out.println("It's a draw");
            }
            else if (user.winList().contains(computerMove)){
                System.out.println("You win!");
            }
            else {
                System.out.println("You lose!");
            }
            System.out.println("Key: " + computer.getKey());
        }
}
