
import window.Frame;
import window.MenuBar;


public class Main {
    public static Main main;
    private Frame frame;
    public static MenuBar menuBar;

    public static void main(String[] args) {
        main = new Main();
    }

    public Main() {
        menuBar = new MenuBar();
        frame = new Frame(960, 840, menuBar);
        frame.setTitle("TRAINING MANAGER");
        menuBar.addFrame(frame);



    }



}
