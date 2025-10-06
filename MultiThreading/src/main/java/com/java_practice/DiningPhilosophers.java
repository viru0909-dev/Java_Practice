import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Main class for the Dining Philosophers visual simulation.
 * This corrected version uses the standard "Resource Ordering" technique
 * to guarantee deadlock prevention.
 *
 * @author Virendra the Code-Blooded
 */
public class DiningPhilosophers extends JFrame {

    private static final int NUM_PHILOSOPHERS = 5;
    // These arrays are the shared resources all threads will access.
    private static final Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
    private static final Lock[] chopsticks = new ReentrantLock[NUM_PHILOSOPHERS];

    public DiningPhilosophers() {
        // Create the shared resources (chopsticks)
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            chopsticks[i] = new ReentrantLock();
        }

        // Create the philosophers (threads)
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            // Pass the philosopher its ID and the shared array of chopsticks
            philosophers[i] = new Philosopher(i, chopsticks);
            new Thread(philosophers[i]).start();
        }

        // --- GUI Setup ---
        setTitle("Dining Philosophers (Corrected)");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        TablePanel tablePanel = new TablePanel();
        add(tablePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiningPhilosophers().setVisible(true));
    }

    /**
     * The View: A panel that draws the current state of the simulation.
     */
    class TablePanel extends JPanel {
        private final Timer timer;

        public TablePanel() {
            timer = new Timer(100, e -> repaint());
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int tableRadius = Math.min(centerX, centerY) - 100;

            g2d.setColor(new Color(139, 69, 19)); // SaddleBrown
            g2d.fillOval(centerX - tableRadius, centerY - tableRadius, 2 * tableRadius, 2 * tableRadius);

            for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
                double angle = 2 * Math.PI * i / NUM_PHILOSOPHERS;
                int px = (int) (centerX + (tableRadius - 40) * Math.cos(angle));
                int py = (int) (centerY + (tableRadius - 40) * Math.sin(angle));

                g2d.setColor(philosophers[i].getState().getColor());
                g2d.fillOval(px - 30, py - 30, 60, 60);
                g2d.setColor(Color.BLACK);
                g2d.drawString("P" + i, px - 5, py + 5);

                // Find the chopstick to the "left" of the philosopher on the screen
                int chopstickIndex = i;
                int cx1 = (int) (centerX + (tableRadius - 90) * Math.cos(angle - 0.2));
                int cy1 = (int) (centerY + (tableRadius - 90) * Math.sin(angle - 0.2));
                int cx2 = (int) (centerX + (tableRadius - 120) * Math.cos(angle - 0.2));
                int cy2 = (int) (centerY + (tableRadius - 120) * Math.sin(angle - 0.2));

                // *** FIX: Cast the Lock to a ReentrantLock to access the isLocked() method ***
                if (((ReentrantLock) chopsticks[chopstickIndex]).isLocked()) {
                    g2d.setColor(Color.RED);
                    g2d.setStroke(new BasicStroke(4));
                } else {
                    g2d.setColor(Color.GRAY);
                    g2d.setStroke(new BasicStroke(2));
                }
                g2d.drawLine(cx1, cy1, cx2, cy2);
            }
        }
    }
}

/**
 * The Model: Represents a philosopher thread.
 */
class Philosopher implements Runnable {
    private final int id;
    private final Lock[] chopsticks;
    private volatile State state;
    private final Random random = new Random();

    public Philosopher(int id, Lock[] chopsticks) {
        this.id = id;
        this.chopsticks = chopsticks;
        this.state = State.THINKING;
    }

    public State getState() {
        return state;
    }

    private void think() throws InterruptedException {
        state = State.THINKING;
        Thread.sleep(random.nextInt(3000) + 1000); // Think for 1-4 seconds
    }

    private void eat() throws InterruptedException {
        state = State.EATING;
        Thread.sleep(random.nextInt(4000) + 2000); // Eat for 2-6 seconds
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                state = State.HUNGRY;

                // *** CORRECTED DEADLOCK PREVENTION LOGIC ***
                // Determine which chopstick has the lower index to establish a locking order.
                int leftChopstickIndex = id;
                int rightChopstickIndex = (id + 1) % chopsticks.length;

                Lock firstChopstick = chopsticks[Math.min(leftChopstickIndex, rightChopstickIndex)];
                Lock secondChopstick = chopsticks[Math.max(leftChopstickIndex, rightChopstickIndex)];

                // Always lock the lower-indexed chopstick first.
                firstChopstick.lock();
                try {
                    secondChopstick.lock();
                    try {
                        // Both locks acquired, philosopher can now eat.
                        eat();
                    } finally {
                        // Always release locks in the reverse order of acquisition.
                        secondChopstick.unlock();
                    }
                } finally {
                    firstChopstick.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * An enum to represent the state of a Philosopher.
 */
enum State {
    THINKING(Color.GREEN),
    HUNGRY(Color.ORANGE),
    EATING(Color.RED);

    private final Color color;

    State(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

