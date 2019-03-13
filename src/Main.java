
import window.Frame;
import window.MenuBar;


public class Main {

    private Frame frame;
    public MenuBar menuBar;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        menuBar = new MenuBar();
        frame = new Frame(960, 840, menuBar);
        frame.setTitle("TRAINING MANAGER");
        menuBar.addFrame(frame);



    }


}
