package exercise;

import javax.swing.*;

public class MuscleScoreLabel extends JLabel {

    public int count;
    private String text;
    private String muscle;

     public MuscleScoreLabel (String text) {
         count = 0;
         this.muscle = text;
         setText(muscle + " : " + count + "\n");
      //   setNewText(text);
      //   super.setText(this.text);

     }

     public void increase() {
         ++count;
         setText(text);
     }

     public String getMuscle() {
         return muscle;
     }

     //@Override
     public void setNewText() {
         setText(muscle + " : " + count + "\n");
     }

}
