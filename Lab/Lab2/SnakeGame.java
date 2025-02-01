import java.util.*;


public class SnakeGame {
    private int n; // Grid size
    private List<Pair> snake; // Snake's body
    private int[] apple; // Apple position
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, down, left, up
    private int currentDirection = 0; // Start direction (0 = right)

    private static class Pair{
        int x;
        int y;

        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public SnakeGame(int n) {
        this.n = n;
        ArrayList<Integer> answer = new ArrayList<>();
        answer.getLast();
        this.snake = new ArrayList<Pair>();
        snake.add(new Pair(0, 0));
        this.generateApple();
    }

    private void generateApple() {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(n);
            y = rand.nextInt(n);
        } while (isOccupiedBySnake(x, y)); // Ensure apple doesn't spawn on the snake
        this.apple = new int[]{x, y};
    }

    private boolean isOccupiedBySnake(int x, int y) {
        return snake.contains(new Pair(x,y));
    }

    public void changeDirection(int newDirection) {
        // Ensure new direction is not directly opposite
        if(currentDirection == 0 && newDirection == 2){
            return;
        }
        if(currentDirection == 1 && newDirection == 3){
            return;
        }

        if(currentDirection == 2 && newDirection == 0){
            return;
        }
        if(currentDirection==3 && newDirection == 1){
            return;
        }

        this.currentDirection = newDirection;
    }

    public boolean moveSnake() {
        int newX = snake.get(snake.size()-1).x + directions[currentDirection][0];
        int newY = snake.get(snake.size()-1).y + directions[currentDirection][1];
        
        if(isCollision(newX, newY)){
            return false;
        }
        
        if(isOccupiedBySnake(newX, newY)){
            return false;
        }
        
        if(apple[0] == newX && apple[1] ==  newY){
            this.snake.add(new Pair(newX,newY));
            generateApple();
        }else{  
            for(int i =0;i<snake.size()-1;i++){
                this.snake.set(i, this.snake.get(i +1));
            }
            this.snake.set(snake.size()-1,new Pair(newX, newY));
        }

        return true;
    }

    private boolean isCollision(int newX, int newY) {
        return newX >=  n || newX < 0 || newY >= n || newY < 0;
    }

    public void printState() {
        // Clear console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        // Mark snake body
        for (Pair p : snake) {
            grid[p.x][p.y] = 'S';
        }

        // Mark apple
        grid[apple[0]][apple[1]] = 'A';

        // Print grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Snake Length: " + snake.size());
        System.out.println("Directions: 0=Right, 1=Down, 2=Left, 3=Up");
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(10);
        Scanner scanner = new Scanner(System.in);
        
        new Thread(() -> {
            while (true) {
                game.printState();
                
                try {
                    Thread.sleep(1000);  // 1 second delay
                    
                    synchronized(game) {
                        if (!game.moveSnake()) {
                            System.out.println("Game Over!");
                            scanner.close();
                            System.exit(0);
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();

        // Input thread
        while (true) {
            int direction = scanner.nextInt();
            
            if (direction < 0 || direction > 3) {
                System.out.println("Game Over!");
                scanner.close();
                System.exit(0);
            }
            
            synchronized(game) {
                game.changeDirection(direction);
            }
        }
    }
}