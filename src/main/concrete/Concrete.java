package main.concrete;

import main.common.MathFunctions;

//Class calculate conrete parameters base of cubic sample compression strength
public class Concrete {
    private final int classesB; //characteristic strength of cubic sample
    private final int[] classesCubeIntList = {15, 20, 25, 30, 37, 45, 50, 55, 60, 67, 75, 85, 95, 105}; //list of cubical classes according to PN-EN 1992-1-1
    private final int[] classesCylinderIntList = {12, 16, 20, 25, 30, 35, 40, 45, 50, 55, 60, 70, 80, 90};
    public static String[] classesStringList = {"C12/15", "C16/20", "C20/25", "C25/30", "C30/37", "C35/45", "C40/50", "C45/55", "C50/60", "C55/67", "C60/75", "C70/85", "C80/95", "C90/105"};
    public final static double epsilonCU1=0.0035;
    public final static double epsilonCU2=0.0035;

    //Construntor with class B parameter
    public Concrete(int x) {
        classesB = x;
    }

    //Constructor with string parameter "C15/20"
    public Concrete(String y) {
        classesB = ClassStripper(y);
    }

    //Changes String like "C15/20" to INT 15 etc.
    public int ClassStripper(String cl) {
            if(validBeton(cl)) {
                if (cl.length() == 6 & (cl.charAt(0)== (char) 'C') & (cl.charAt(3)== (char) '/')) {
                    return Integer.parseInt(cl.substring(4));
                } else {
                    return -1;
                }
            } else {
                  return -1;
            }
    }

    //***************************************************************************************
    //Method to get from fck.cube (B class) to fck - from INT
    public int fck(int cl) {
        int result = -1;
        for (int i = 0; i < classesCubeIntList.length; i++) {
            if (cl == classesCubeIntList[i]) {
                result = classesCylinderIntList[i];
            }
        }
        return result;
    }

    //Method to get from fck.cube to fck - from String
    public int fck(String ConcreteClass) {
        return fck(ClassStripper(ConcreteClass));
    }

    //***************************************************************************************
    //calculate fcd base on fck - from INT
    public double fcd(int cl) {
            if (validBeton(cl)) {
                double fcd = fck(cl) / 1.4;
                return MathFunctions.round(fcd, 2);
            } else {
                return -1;
            }
    }

    //calculate fcd base on fck - from Concrete instance
    public double fcd() {
        return fcd(classesB);
    }

    //calculate fcd base on fck - from String
    public double fcd(String cl) {
        return fcd(ClassStripper(cl));
    }

    //***************************************************************************************
    //calculate fcm base on fck - from INT
    public int fcm(int cl) {
        if(validBeton(cl)) {
            return fck(cl) + 8;
        }
        else {
            return -1;
        }
    }

    //calculate fcm base on fck - from String
    public int fcm(String cl) {
        return fck(ClassStripper(cl)) + 8;
    }


    //***************************************************************************************
    //calculate fctm base on fck - from INT
    public double fctm(int cl) {
        if(validBeton(cl)) {
            if (fck(cl) <= 50) {
                return MathFunctions.round(0.3 * Math.pow(fck(cl), (double) 2 / 3), 1);
            } else {
                return MathFunctions.round(2.12 * Math.log(1 + 0.1 * fcm(fck(cl))), 1);
            }
        } else {
            return -1;
        }
    }

    //calculate fctm base on fck - from String
    public double fctm(String cl) {
        return fctm(ClassStripper(cl));
    }

    //***************************************************************************************
    //calculate fctk base on fck - from INT
    public double fctk(int cl) {
        if(validBeton(cl)) {
            return MathFunctions.round(0.7 * fctm(cl), 1);
        } else {
            return -1;
        }
    }

    //calculate fctk base on fck - from String
    public double fctk(String cl) {
        return fctk(ClassStripper(cl));
    }

    //***************************************************************************************
    //calculate Ecm (Ecm in GPa) base on fck - from INT
    public int Ecm(int cl) {
        if(validBeton(cl)) {
            //exception in norm formula for C30/37
            if(cl==37) {
                return 32;
            } else {
                return (int) MathFunctions.round(22 * Math.pow(0.1 * fcm(cl), 0.3), 0);
            }

        } else {
            return -1;
        }
    }

    //calculate Ecm (Ecm in GPa) base on fck - from String
    public int Ecm(String cl) {
        return Ecm(ClassStripper(cl));
    }

    //***************************************************************************************
    //checking if given class is correct - from INT
    public boolean validBeton(int cl) {
        for (int i = 0; i < classesCubeIntList.length; i++) {
            if (classesCubeIntList[i] == cl) {
                return true;
            }
        }
        return false;
    }

    //checking if given class is correct - from String
    public boolean validBeton(String cl) {
        boolean isValid=false;
        try {
            int i = 0;

            while (i < 25) {
                if (classesStringList[i].equals(cl)) {
                    isValid = true;
                    break;
                }
                i++;
            }
        } catch(ArrayIndexOutOfBoundsException exc) {
            System.out.println("Niewłaściwa klasa betonu!");
            isValid = false;
            }
    return isValid;
    }
}