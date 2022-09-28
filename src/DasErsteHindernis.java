import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.apps.BouncerLauncher;

public class DasErsteHindernis extends BouncerApp {

    /**
     * Bouncer bewegt sich von links nach rechts und klettert über ein Hindernis.
     * Vorbedingung: Bouncer steht auf der linken Seite der Hindernisse, nach Osten ausgerichtet.
     * Nachbedingung: Bouncer steht auf der rechten Seite der Hindernisse, nach Osten ausgerichtet.
     */
    @Override
    public void bounce() {
        loadMap("Obstacles");
        moveToObstacle();
        climbOverObstacle();
        moveToWall();
    }

    /**
     * Bouncer bewegt sich zum Hindernis.
     * Vorbedingung: Bouncer steht auf der linken Seite des Hindernisses, nach Osten ausgerichtet
     *                  bzw. Bouncer steht hinter dem Hindernis, nach Osten ausgerichtet.
     * Nachbedingung: Bouncer steht vor dem Hindernis, nach Osten ausgerichtet
     *                  bzw. Bouncer steht an der östlichen Wand.
     */
    private void moveToObstacle() {
        while(bouncer.canMoveForward()) {
            bouncer.move();
        }
    }

    /**
     * Bouncer klettert über das Hindernis.
     * Vorbedingung: Bouncer steht vor dem Hindernis, nach Osten ausgerichtet.
     * Nachbedingung: Bouncer steht hinter dem Hindernis, nach Osten ausgerichtet.
     */
    private void climbOverObstacle() {
        climbUp();
        climbDown();
    }

    /**
     * Bouncer klettert das Hindernis hinauf.
     * Vorbedingung: Bouncer steht vor dem Hindernis, nach Osten ausgerichtet.
     * Nachbedingung: Bouncer steht auf dem Hindernis, nach Osten ausgerichtet.
     */
    private void climbUp() {
        bouncer.turnLeft();
        bouncer.move();
        turnRight();
        bouncer.move();
        bouncer.turnLeft();
        bouncer.move();
        turnRight();
        bouncer.move();
    }

    /**
     * Bouncer klettert das Hindernis hinunter.
     * Vorbedingung: Bouncer steht auf dem Hindernis, nach Osten ausgerichtet.
     * Nachbedingung: Bouncer steht hinter dem Hindernis, nach Osten ausgerichtet.
     */
    private void climbDown() {
        bouncer.move();
        turnRight();
        bouncer.move();
        bouncer.turnLeft();
        bouncer.move();
        turnRight();
        bouncer.move();
        bouncer.turnLeft();
    }

    /**
     * Bouncer bewegt sich bis er an der östlichen Wand steht.
     * Vorbedingung: Bouncer steht hinter dem Hindernis, nach Osten ausgerichtet.
     * Nachbedingung: Bouncer steht an der östlichen Wand.
     */
    private void moveToWall() {
        while(bouncer.canMoveForward()){
            bouncer.move();
        }
    }

    private void turnRight() {
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.turnLeft();
    }

    public static void main(String[] args) {
        BouncerLauncher.launch("DasErsteHindernis");
    }
}