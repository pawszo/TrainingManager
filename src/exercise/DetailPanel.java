package exercise;

import screens.ComposerPanel;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class DetailPanel extends JPanel {


    public DetailPanel(Color color){
        setSize(new Dimension(480, 420));
        setBackground(color);
    }

    public DetailPanel(Color color, boolean isPlanScore){
        super();
        setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(new Dimension(480, 420));
        setBackground(color);
        createPlanScore();
        setOpaque(true);
    }

    private  LinkedList<MuscleScoreLabel> planScore;

    public void createPlanScore() {
        removeAll();
        repaint();
        planScore = new LinkedList<>();

        for(int i = 1; i <= ComposerPanel.muscleMap.size(); i++) {
            planScore.add(new MuscleScoreLabel(ComposerPanel.muscleMap.get(i)));
          //  System.out.println
            System.out.println(i);
        }
        for(int i = 0; i < planScore.size(); i++) {
            planScore.get(i).setBackground(Color.yellow);
            add(planScore.get(i));
        }
    }

    public LinkedList<MuscleScoreLabel> getPlanScore() {
        return planScore;
    }

    public void setPlanScore(LinkedList<MuscleScoreLabel> planScore) {
        this.planScore = planScore;
    }
}
