package main.concrete;

import main.common.MathFunctions;

public class MinReinforcement {

    //Calculate minimal reinforcement for beam bending according to PN-EN 1992-1-1 - rectangular
    public static double calculateMinimalReinforcement(String ConcreteClass, String RebarClass, int MainRebarDiameter, int StirrupDiameter, int ConcreteCover, double ConcreteCrack, double beamWidth, double beamHight) {
        Concrete Conc = new Concrete(ConcreteClass);
        double fctm=Conc.fctm(ConcreteClass);
        double fyk=Rebar.fyk(RebarClass);
        double d=(beamHight*10-ConcreteCover-StirrupDiameter-MainRebarDiameter/2)/1000;
        double h=beamHight/100;
        double b=beamWidth/100;
        double Asmin1=0.26*(fctm/fyk)*b*d;
        double Asmin2=0.0013*b*d;
        double kc=0.4;
        double k=calculateK(beamHight);
        double Act=(0.5*b*h);
        int sigmas = Rebar.calculateRebarSigma(ConcreteCrack,MainRebarDiameter);
        double Asmin3=(kc*k*fctm*Act)/sigmas;
        return MathFunctions.round((Math.max(Math.max(Asmin1,Asmin2),Asmin3))*Math.pow(100,2),2);
    }

    //Calculate minimal reinforcement for beam bending according to PN-EN 1992-1-1 - Tshape upper
    public static double calculateMinimalReinforcement(String ConcreteClass, String RebarClass, int MainRebarDiameter, int StirrupDiameter, int ConcreteCover, double ConcreteCrack, double beamWidth, double beamHight, double beff1, double beff2, double slabThickness) {
        Concrete Conc = new Concrete(ConcreteClass);
        double fctm=Conc.fctm(ConcreteClass);
        double fyk=Rebar.fyk(RebarClass);
        double d=(beamHight*10-ConcreteCover-StirrupDiameter-MainRebarDiameter/2)/1000;
        double b=(beamWidth+beff1+beff2)/100;
        double Asmin1=0.26*fctm/fyk*b*d;
        double Asmin2=0.0013*b*d;
        double kc=0.5;
        double k=calculateK(b*100);
        double Act=(b*slabThickness/100); //SPRAWDŹ CZY TO PRAWDA
        int sigmas = Rebar.calculateRebarSigma(ConcreteCrack,MainRebarDiameter);
        double Asmin3=(kc*k*fctm*Act)/sigmas;

        return MathFunctions.round((Math.max(Math.max(Asmin1,Asmin2),Asmin3))*Math.pow(100,2),2);
    }

    public static double calculateK(double x) {
        if(x*10<=300) {
            return 1.0;
        } else if(x*10>800) {
            return 0.65;
        } else {
            return MathFunctions.interpolate(x*10,300,1,800,0.65);
        }
    }


}
