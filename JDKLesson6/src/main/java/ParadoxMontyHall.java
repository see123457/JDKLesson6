import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ParadoxMontyHall {
    private static final int GAMES = 1000;

    private int win = 0;
    private int loss = 0;
    private Random random = new Random();
    private Map<Integer, String> gameResults = new HashMap<>();

    public void start() {
        for (int i = 0; i < GAMES; i++) {
            int carLocation = random.nextInt(3);
            int myChoice = random.nextInt(3);

            int remainingDoor = -1;
            for (int j = 0; j < 3; j++) {
                if (j != myChoice && j != carLocation) {
                    remainingDoor = j;
                    break;
                }
            }

            int myChoiceTwo = -1;
            for (int j = 0; j < 3; j++) {
                if (j != myChoice && j != remainingDoor) {
                    myChoiceTwo = j;
                    break;
                }
            }

            if (myChoiceTwo == carLocation) {
                win++;
                gameResults.put(i + 1, "win");
            } else {
                loss++;
                gameResults.put(i + 1, "loss");
            }
        }
    }

    public void print() {

        System.out.println("Результаты каждой игры:");
        for (Map.Entry<Integer, String> entry : gameResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Выигрыши: " + win);
        System.out.println("Проигрыши: " + loss);

    }

    public static void main(String[] args) {
        ParadoxMontyHall paradox = new ParadoxMontyHall();
        paradox.start();
        paradox.print();
    }
}