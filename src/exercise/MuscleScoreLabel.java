package exercise;

import javax.swing.*;

public class MuscleScoreLabel extends JLabel {

    public int count;
    private String newText;
    private String text;

     public MuscleScoreLabel (String text) {
         count = 0;
         setNewText(text);
         super.setText(this.text);

     }

     public void increase() {
         ++count;
         setText(text);
     }

     //@Override
     public void setNewText(String text) {
         this.text = "      " + text + " : " + count + "\n";
     }

}
