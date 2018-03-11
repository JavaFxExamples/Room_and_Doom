package sample;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Player extends SpriteBase {
    //EKLENECEK ŞEYLER VAR (İNT,STR,VİT VB... )
    //HEALTH DAMAGE DEĞERLERİ DEĞİŞECEK.STR,INT,GİBİ DEĞERLERLE BELİRLENECEK.
    //SINIFLARI AYARLAMAK İÇİN CLASS LAZIM VE BU CLASS I KULLANMAK

    double characterMinX;
    double characterMaxX;
    double characterMinY;
    double characterMaxY;

    Input input;


    double speed;
    static SpriteAnimation animation;
    static SpriteAnimation attackAnimation;
    public SpriteAnimation deathAnimation;

    public Player(Pane layer, Image image, double health, double damage, double speed, Input input) {

<<<<<<< HEAD
        super(layer, image, 200, 400, 4, 4, health, damage);
=======
        super(layer, image, 200, 0, 4, 4, health, damage);
>>>>>>> 3321901106b7324d79bae8a346263d07b902ec09

        this.speed = speed;
        this.input = input;

        //Here we crop the style sheet's specific part
        this.imageView.setViewport(new Rectangle2D(0, 0, 64, 64));

        //Setting animations
        animation = new SpriteAnimation(imageView, Duration.millis(800), 9, 9, 0, 0, 64, 64);
        attackAnimation = new SpriteAnimation(imageView, Duration.millis(1000), 8, 8, 0, 0, 64, 64);
        deathAnimation = new SpriteAnimation(imageView, Duration.millis(1200), 6, 6, 0, 1280, 64, 64);

        //Animation cycles
        animation.setCycleCount(Animation.INDEFINITE);
        deathAnimation.setCycleCount(1);
        attackAnimation.setCycleCount(1);
        attackAnimation.setOnFinished(e -> Input.setIsAttacking(false)); //Everytime when cycle finished it set's the value 0

<<<<<<< HEAD
        rectangle.setHeight(imageView.getViewport().getHeight());
        rectangle.setWidth(imageView.getViewport().getWidth());


        init();



=======
        init();

>>>>>>> 3321901106b7324d79bae8a346263d07b902ec09
    }

    public void checkAlive(){
        if(!this.isAlive()){
            deathAnimation.play();
            animation.stop();
            attackAnimation.stop();
            stopMovement();
        }
    }

    private void init() {
        // calculate movement bounds of the character
        // allow character can not to be outside of the screen
        characterMinX = 0;
        characterMaxX = Settings.SCENE_WIDTH - rectangle.getWidth();
        characterMinY = 0;
        characterMaxY = Settings.SCENE_HEIGHT - rectangle.getHeight();

    }


    public void processInput() {

        // ------------------------------------
        // movement
        // ------------------------------------

        // vertical direction
        if (input.isMoveUp()) {
            animation.play();
            animation.setOffSetY(512);
            dy = -speed;
        } else if (input.isMoveDown()) {
            animation.play();
            animation.setOffSetY(640);
            dy = speed;
        } else {
            dy = 0d;
        }

        // horizontal direction
        if (input.isMoveLeft()) {
            animation.play();
            animation.setOffSetY(576);
            dx = -speed;
        } else if (input.isMoveRight()) {
            animation.play();
            animation.setOffSetY(704);
            dx = speed;
        } else {
            dx = 0d;
        }
        //Attack statements
        if (input.isAttack()) {
            if (animation.getOffSetY() == 512) {
                //Up attack.
                attackAnimation.play();
                attackAnimation.setOffSetY(256);
            }
            if (animation.getOffSetY() == 640) {
                //Bot attack.
                attackAnimation.play();
                attackAnimation.setOffSetY(384);
            }
            if (animation.getOffSetY() == 576) {
                //Left attack.
                attackAnimation.play();
                attackAnimation.setOffSetY(320);
            }
            if (animation.getOffSetY() == 704) {
                //Right attack.
                attackAnimation.play();
                attackAnimation.setOffSetY(448);
            }

        }

    }

    @Override
    public void move() {

        super.move();

        //ensure the character can't move outside of the screen
        checkBounds();

    }

    private void checkBounds() {

        // vertical
        if (Double.compare(rectangle.getY(), characterMinY) < 0) {
            rectangle.setY(characterMinY);
        } else if (Double.compare(y, characterMaxY) > 0) {
            rectangle.setY(characterMaxY);
        }
        // horizontal
        if (Double.compare(rectangle.getX(), characterMinX) < 0) {
            rectangle.setX(characterMinX);
        } else if (Double.compare(x, characterMaxX) > 0) {
            rectangle.setX(characterMaxX);
        }

    }


    @Override
    public void checkRemovability() {

        }
}