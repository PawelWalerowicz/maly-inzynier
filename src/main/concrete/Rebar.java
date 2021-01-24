package main.concrete;

public class Rebar {
    final public static String[] rebarClasses = {"A-0", "A-I", "A-II", "A-III", "A-IIIN"};
    final public static Integer[] rebarDiameters = {6, 8, 10, 12, 14, 16, 18, 20, 22, 25, 28, 32};
    final public static int Es=200;
    final public static double GAMMAS=1.15;

    public static int fyk(String SteelClass) {
        switch (SteelClass) {
            case "A-0":
                return 220;
            case "A-I":
                return 240;
            case "A-II":
                return 355;
            case "A-III":
                return 400;
            case "A-IIIN":
                return 500;
            default:
                return 0;
        }
    }

    public static double fyd(String SteelClass) {
        return fyk(SteelClass)/GAMMAS;
    }


    public static int calculateRebarSigma(double ConcreteCrack, int MainRebarDiameter) {
        int[] sigmasList = {160, 200, 240, 280, 320, 360, 400, 450};
        int[] diameterList = new int[8];
        if (ConcreteCrack == 0.4) {
            diameterList = new int[] {40, 32, 20, 16, 12, 10, 8, 6};
           } else if (ConcreteCrack == 0.3) {
            diameterList = new int[] {32, 25, 16, 12, 10, 8, 6, 5};
        } else if (ConcreteCrack == 0.2) {
            diameterList = new int[] {25, 16, 12, 8, 6, 5, 4, 0};
        }
        int closestSigma=0;
        int i=0;
        try {
            while(MainRebarDiameter<=diameterList[i] & i<=sigmasList.length) {
                closestSigma = sigmasList[i];
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            closestSigma=0;
        }

        return closestSigma;

    }


}
