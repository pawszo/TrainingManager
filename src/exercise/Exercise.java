package exercise;

import screens.ComposerPanel;

import java.util.ArrayList;
import java.util.Set;

public class Exercise {

    public String[] primMuscles; //primary muscles trained
    public String[] secMuscles;  //secondary muscles trained
    private int currExcKey;
    private String currExc;
    private ComposerPanel composerPanel;


    public Exercise(String currExc, ComposerPanel composerPanel) {
        this.currExc = currExc;
        this.composerPanel = composerPanel;
        this.currExcKey = composerPanel.excMap.indexOf(currExc);
        create();
    }



    public void create() {

                switch (currExcKey) {
                    case 2:
                        primMuscles = new String[] {(composerPanel.muscleMap.get(1))};
                        secMuscles = new String[]{(composerPanel.muscleMap.get(2)), (composerPanel.muscleMap.get(3))};
                        break;
                    case 3:
                        primMuscles = new String[] {composerPanel.muscleMap.get(1)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(2), composerPanel.muscleMap.get(3)};
                        break;
                    case 4:
                        primMuscles = new String[] {composerPanel.muscleMap.get(1)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(2), composerPanel.muscleMap.get(3), composerPanel.muscleMap.get(23)};
                        break;
                    case 5:
                        primMuscles = new String[] {composerPanel.muscleMap.get(1), composerPanel.muscleMap.get(2)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(17)};
                        break;
                    case 6:
                        primMuscles = new String[] {composerPanel.muscleMap.get(2)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(24), composerPanel.muscleMap.get(1)};
                        break;
                    case 7:
                        primMuscles = new String[] {composerPanel.muscleMap.get(2)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(1)};
                        break;
                    case 8:
                        primMuscles = new String[] {composerPanel.muscleMap.get(2)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(1)};
                        break;
                    case 9:
                        primMuscles = new String[] {composerPanel.muscleMap.get(1), composerPanel.muscleMap.get(2), composerPanel.muscleMap.get(20)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(22), composerPanel.muscleMap.get(17)};
                        break;
                    case 10:
                        primMuscles = new String[] {composerPanel.muscleMap.get(4)};
                        break;
                    case 11:
                        primMuscles = new String[] {composerPanel.muscleMap.get(4)};
                        break;
                    case 12:
                        primMuscles = new String[] {composerPanel.muscleMap.get(4)};
                        break;
                    case 13:
                        primMuscles = new String[] {composerPanel.muscleMap.get(4)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(5)};
                        break;
                    case 14:
                        primMuscles = new String[] {composerPanel.muscleMap.get(4)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(5)};
                        break;
                    case 15:
                        primMuscles = new String[] {composerPanel.muscleMap.get(5)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(4)};
                        break;
                    case 16:
                        primMuscles = new String[] {composerPanel.muscleMap.get(5)};
                        break;
                    case 17:
                        primMuscles = new String[] {composerPanel.muscleMap.get(5)};
                        break;
                    case 18:
                        primMuscles = new String[] {composerPanel.muscleMap.get(6)};
                        break;
                    case 19:
                        primMuscles = new String[] {composerPanel.muscleMap.get(6)};
                        break;
                    case 20:
                        primMuscles = new String[] {composerPanel.muscleMap.get(6)};
                        break;
                    case 21:
                        primMuscles = new String[] {composerPanel.muscleMap.get(6)};
                        break;
                    case 22:
                        primMuscles = new String[] {composerPanel.muscleMap.get(6)};
                        break;
                    case 23:
                        primMuscles = new String[] {composerPanel.muscleMap.get(7)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(8)};
                        break;
                    case 24:
                        primMuscles = new String[] {composerPanel.muscleMap.get(7)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(14)};
                        break;
                    case 25:
                        primMuscles = new String[] {composerPanel.muscleMap.get(7)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(6)};
                        break;
                    case 26:
                        primMuscles = new String[] {composerPanel.muscleMap.get(14)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(7), composerPanel.muscleMap.get(6)};
                        break;
                    case 27:
                        primMuscles = new String[] {composerPanel.muscleMap.get(12)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(14), composerPanel.muscleMap.get(11), composerPanel.muscleMap.get(13)};
                        break;
                    case 28:
                        primMuscles = new String[] {composerPanel.muscleMap.get(17), composerPanel.muscleMap.get(10), composerPanel.muscleMap.get(20)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(14), composerPanel.muscleMap.get(16)};
                        break;
                    case 29:
                        primMuscles = new String[] {composerPanel.muscleMap.get(14)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(5)};
                        break;
                    case 30:
                        primMuscles = new String[] {composerPanel.muscleMap.get(12)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(4), composerPanel.muscleMap.get(14), composerPanel.muscleMap.get(9), composerPanel.muscleMap.get(13)};
                        break;
                    case 31:
                        primMuscles = new String[] {composerPanel.muscleMap.get(12)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(4), composerPanel.muscleMap.get(11), composerPanel.muscleMap.get(13)};
                        break;
                    case 32:
                        primMuscles = new String[] {composerPanel.muscleMap.get(12)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(4), composerPanel.muscleMap.get(11), composerPanel.muscleMap.get(13)};
                        break;
                    case 33:
                        primMuscles = new String[] {composerPanel.muscleMap.get(12)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(14), composerPanel.muscleMap.get(9), composerPanel.muscleMap.get(11), composerPanel.muscleMap.get(13)};
                        break;
                    case 34:
                        primMuscles = new String[] {composerPanel.muscleMap.get(12)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(14), composerPanel.muscleMap.get(9), composerPanel.muscleMap.get(11), composerPanel.muscleMap.get(13)};
                        break;
                    case 35:
                        primMuscles = new String[] {composerPanel.muscleMap.get(17)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(20), composerPanel.muscleMap.get(16)};
                        break;
                    case 36:
                        primMuscles = new String[] {composerPanel.muscleMap.get(20), composerPanel.muscleMap.get(16)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(10)};
                        break;
                    case 37:
                        primMuscles = new String[] {composerPanel.muscleMap.get(15)};
                        break;
                    case 38:
                        primMuscles = new String[] {composerPanel.muscleMap.get(17)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(20), composerPanel.muscleMap.get(16)};
                        break;
                    case 39:
                        primMuscles = new String[] {composerPanel.muscleMap.get(16)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(20)};
                        break;
                    case 40:
                        primMuscles = new String[] {composerPanel.muscleMap.get(17)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(20), composerPanel.muscleMap.get(16)};
                        break;
                    case 41:
                        primMuscles = new String[] {composerPanel.muscleMap.get(20)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(16)};
                        break;
                    case 42:
                        primMuscles = new String[] {composerPanel.muscleMap.get(20), composerPanel.muscleMap.get(17)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(16)};
                        break;
                    case 43:
                        primMuscles = new String[] {composerPanel.muscleMap.get(24)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(20)};
                        break;
                    case 44:
                        primMuscles = new String[] {composerPanel.muscleMap.get(18), composerPanel.muscleMap.get(22)};
                        break;
                    case 45:
                        primMuscles = new String[] {composerPanel.muscleMap.get(25)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(7), composerPanel.muscleMap.get(6)};
                        break;
                    case 46:
                        primMuscles = new String[] {composerPanel.muscleMap.get(25)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(7), composerPanel.muscleMap.get(6)};
                        break;
                    case 47:
                        primMuscles = new String[] {composerPanel.muscleMap.get(25)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(7), composerPanel.muscleMap.get(6)};
                        break;
                    case 48:
                        primMuscles = new String[] {composerPanel.muscleMap.get(25)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(7), composerPanel.muscleMap.get(6)};
                        break;
                    case 49:
                        primMuscles = new String[] {composerPanel.muscleMap.get(25)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(7), composerPanel.muscleMap.get(6)};
                        break;
                    case 50:
                        primMuscles = new String[] {composerPanel.muscleMap.get(25)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(7)};
                        break;
                    default: //Parallel Bar Dips
                        primMuscles = new String[] {composerPanel.muscleMap.get(25)};
                        secMuscles = new String[]{composerPanel.muscleMap.get(7)};
                        break;
                }
                if(secMuscles == null) {
                    secMuscles = new String[] {""};
                }

        }


    public int getCurrExcKey() {
        return currExcKey;
    }

    public String getCurrExc() {
        return currExc;
    }
}

