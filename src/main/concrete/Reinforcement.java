package main.concrete;

import main.common.MathFunctions;

import javax.swing.*;

import static main.common.JTools.*;
import static main.common.JTools.getJLabel;

public class Reinforcement {

    public static void manageReinforcement(JPanel ConcreteWindow) {

        //Importing elements from ConcreteWindow
        JPanel MaterialPanel = getJPanel(ConcreteWindow, "MaterialPanel");
        JPanel CrackPanel = getJPanel(ConcreteWindow, "CrackPanel");
        JPanel GeometryPanel = getJPanel(ConcreteWindow, "GeometryPanel");
        JPanel ForcesPanel = getJPanel(ConcreteWindow, "ForcesPanel");
        JPanel ReinforcementPanel = getJPanel(ConcreteWindow, "ReinforcementPanel");

        boolean ULSCheck = getJCheckBoxStatus(ConcreteWindow,"SLSCheckOption");
        boolean MinReinfCheck = getJCheckBoxStatus(ConcreteWindow,"MinReinfCheckOption");

        JTextField As1field = getJComponent(ReinforcementPanel,"As1");
        As1field.setText("0.00");
        JTextField As2field = getJComponent(ReinforcementPanel,"As2");
        As2field.setText("0.00");

        //Getting material values
        String ConcreteClass= getJContent(MaterialPanel,"ConcreteClass");
        String MainRebarClass= getJContent(MaterialPanel,"MainRebarClass");
        String StirrupsRebarClass= getJContent(MaterialPanel,"StirrupsRebarClass");
        int DownRebarDiameter = Integer.valueOf(getJContent(MaterialPanel,"DownRebarDiameter"));
        int UpperRebarDiameter= Integer.valueOf(getJContent(MaterialPanel,"UpperRebarDiameter"));
        int StirrupsRebarDiameter= Integer.valueOf(getJContent(MaterialPanel,"StirrupsRebarDiameter"));

        //Getting crack values
        double CrackWidth = Double.valueOf(getJContent(CrackPanel,"wk"));

        //Getting geometry values
        int DownCover= Integer.valueOf(getJContent(GeometryPanel,"DownCover"));
        int UpperCover= Integer.valueOf(getJContent(GeometryPanel,"UpperCover"));
        double beamWidth= Double.valueOf(getJContent(GeometryPanel,"beamb"));
        double beamHight= Double.valueOf(getJContent(GeometryPanel,"beamh"));

        boolean beamIsRectangular = getJCheckBoxStatus(GeometryPanel,"IsBeamRectangularInvisibleCheck");

        double slabThickness=0;
        double beff1=0;
        double beff2=0;
        if(!beamIsRectangular) {
            slabThickness= Double.valueOf(getJContent(GeometryPanel, "beamhf"));
            beff1= Double.valueOf(getJContent(GeometryPanel, "beambeff1"));
            beff2= Double.valueOf(getJContent(GeometryPanel, "beambeff2"));
        }

        //Getting forces values
        double MEd= Double.valueOf(getJContent(ForcesPanel,"MEd"));
        double MEk= Double.valueOf(getJContent(ForcesPanel,"MEk"));
        double VEd= Double.valueOf(getJContent(ForcesPanel,"VEd"));
        double VEk= Double.valueOf(getJContent(ForcesPanel,"VEk"));
        double TEd= Double.valueOf(getJContent(ForcesPanel,"TEd"));

        //Getting reinforcement values
        double As1= Double.valueOf(getJContent(ReinforcementPanel,"As1"));
        double As2= Double.valueOf(getJContent(ReinforcementPanel,"As2"));
        double Asw= Double.valueOf(getJContent(ReinforcementPanel,"Asw"));

        JLabel As1InRebars= getJLabel(ReinforcementPanel,"As1InRebars");
        JLabel As2InRebars= getJLabel(ReinforcementPanel,"As2InRebars");

        //Setting compressed parameter names
        int StretchedReinforcementDiameter;
        int CompressedReinforcementDiameter;
        int StretchedReinforcementCover;
        int CompressedReinforcementCover;
        double StretchetReinforcementMin=0;
        double CompressedReinforcementMin=0;
        JTextField AsStretchedField;
        JTextField AsCompressedField;
        JLabel StretchedRebarsNumber;
        JLabel CompressedRebarsNumber;


        if(MEd>=0) {
            StretchedReinforcementDiameter=DownRebarDiameter;
            CompressedReinforcementDiameter=UpperRebarDiameter;
            StretchedReinforcementCover=DownCover;
            CompressedReinforcementCover=UpperCover;
            AsStretchedField=As1field;
            AsCompressedField=As2field;
            StretchedRebarsNumber=As1InRebars;
            CompressedRebarsNumber=As2InRebars;
        } else {
            StretchedReinforcementDiameter=UpperRebarDiameter;
            CompressedReinforcementDiameter=DownRebarDiameter;
            StretchedReinforcementCover=UpperCover;
            CompressedReinforcementCover=DownCover;
            AsStretchedField=As2field;
            AsCompressedField=As1field;
            StretchedRebarsNumber=As2InRebars;
            CompressedRebarsNumber=As1InRebars;
        }
        double[] As={0.0,0.0};

        if(beamIsRectangular) {

            if(ULSCheck) {
                System.out.println("Doklep to miśku");
            } else {
                As= Reinforcement.calculateReinforcementRectangularSGN(MEd,ConcreteClass,MainRebarClass, StretchedReinforcementDiameter,CompressedReinforcementDiameter,StirrupsRebarDiameter,StretchedReinforcementCover,CompressedReinforcementCover,beamWidth,beamHight);
            }

            if(MinReinfCheck) {
                StretchetReinforcementMin = MinReinforcement.calculateMinimalReinforcement(ConcreteClass,MainRebarClass,StretchedReinforcementDiameter,StirrupsRebarDiameter,StretchedReinforcementCover,CrackWidth,beamWidth,beamHight);
                CompressedReinforcementMin = MinReinforcement.calculateMinimalReinforcement(ConcreteClass,MainRebarClass,CompressedReinforcementDiameter,StirrupsRebarDiameter,CompressedReinforcementCover,CrackWidth,beamWidth,beamHight);

                if(As[0]<StretchetReinforcementMin) {
                    As[0]=StretchetReinforcementMin;
                }
            }

            AsStretchedField.setText(String.valueOf(As[0]));
            int AmountOfStretchedRebars=Reinforcement.howManyRebars(As[0],StretchedReinforcementDiameter);
            double ActualStretchedRebarArea=Reinforcement.reinforcementArea(StretchedReinforcementDiameter,AmountOfStretchedRebars);
            StretchedRebarsNumber.setText("("+AmountOfStretchedRebars+" x \u03D5"+StretchedReinforcementDiameter+" = "+ActualStretchedRebarArea+"cm2)");

            AsCompressedField.setText(String.valueOf(As[1]));
            int AmountOfCompressedRebars=Reinforcement.howManyRebars(As[1],CompressedReinforcementDiameter);
            double ActualCompressedRebarArea=Reinforcement.reinforcementArea(CompressedReinforcementDiameter,AmountOfCompressedRebars);
            CompressedRebarsNumber.setText("("+AmountOfCompressedRebars+" x \u03D5"+CompressedReinforcementDiameter+" = "+ActualCompressedRebarArea+"cm2)");
        } else {

            if(ULSCheck) {
                System.out.println("Doklep to miśku");
            } else {
                As= Reinforcement.checkIfReallyTBeamShape(MEd,ConcreteClass,MainRebarClass,StretchedReinforcementDiameter,CompressedReinforcementDiameter,StirrupsRebarDiameter,DownCover,UpperCover,beamWidth,beamHight,slabThickness, beff1, beff2);
            }

            if(MinReinfCheck) {
                StretchetReinforcementMin = MinReinforcement.calculateMinimalReinforcement(ConcreteClass,MainRebarClass,StretchedReinforcementDiameter,StirrupsRebarDiameter,StretchedReinforcementCover,CrackWidth,beamWidth,beamHight);
                CompressedReinforcementMin = MinReinforcement.calculateMinimalReinforcement(ConcreteClass,MainRebarClass,CompressedReinforcementDiameter,StirrupsRebarDiameter,CompressedReinforcementCover,CrackWidth,beamWidth,beamHight);

                if(As[0]<StretchetReinforcementMin) {
                    As[0]=StretchetReinforcementMin;
                }
            }

            AsStretchedField.setText(String.valueOf(As[0]));
            int AmountOfStretchedRebars=Reinforcement.howManyRebars(As[0],StretchedReinforcementDiameter);
            double ActualStretchedRebarArea=Reinforcement.reinforcementArea(StretchedReinforcementDiameter,AmountOfStretchedRebars);
            StretchedRebarsNumber.setText("("+AmountOfStretchedRebars+" x \u03D5"+StretchedReinforcementDiameter+" = "+ActualStretchedRebarArea+"cm2)");

            AsCompressedField.setText(String.valueOf(As[1]));
            int AmountOfCompressedRebars=Reinforcement.howManyRebars(As[1],CompressedReinforcementDiameter);
            double ActualCompressedRebarArea=Reinforcement.reinforcementArea(CompressedReinforcementDiameter,AmountOfCompressedRebars);
            CompressedRebarsNumber.setText("("+AmountOfCompressedRebars+" x \u03D5"+CompressedReinforcementDiameter+" = "+ActualCompressedRebarArea+"cm2)");

        }

    }



    public static double[] checkIfReallyTBeamShape(double MEd, String ConcreteClass, String RebarClass, int StretchedRebarDiameter, int CompressedRebarDiameter, int StirrupDiameter, int DownCover, int UpperCover, double beamWidth, double beamHight, double slabThickness, double beff1, double beff2) {
        MEd=Math.abs(MEd);
        double d = (beamHight * 10 - DownCover - StirrupDiameter - ((double) StretchedRebarDiameter / 2)) / 1000;
        Concrete Conc = new Concrete(ConcreteClass);
        double ksiefflim = calculateKsiEffLim(RebarClass);
        double fyd=Rebar.fyd(RebarClass);
        double fcd=Conc.fcd(ConcreteClass);
        double beff=(beamWidth+beff1+beff2)/100;
        double Mf=fcd*1000*beff*(slabThickness/100)*(d-0.5*(slabThickness/100));

        double[] Reinforcement={0,0};
        if(MEd>0 & MEd<=Mf) {
            //Przekrój pozornie teowy
            System.out.println("Przekrój pozornie teowy");
            Reinforcement = calculateReinforcementRectangularSGN(MEd,ConcreteClass,RebarClass,StretchedRebarDiameter,CompressedRebarDiameter,StirrupDiameter,DownCover,UpperCover,beff*100,beamHight);
        } else if (MEd<0) {
            Reinforcement = calculateReinforcementRectangularSGN(MEd,ConcreteClass,RebarClass,StretchedRebarDiameter,CompressedRebarDiameter,StirrupDiameter,DownCover,UpperCover,beamWidth,beamHight);
        } else if(MEd>Mf) {
            System.out.println("przekrój rzeczywiście teowy");
            calculateReinforcementTBeamSGN(MEd, fcd, fyd, slabThickness, beff*100, beamWidth, d, ksiefflim);
        }
        return Reinforcement;
    }

    public static double[] calculateReinforcementTBeamSGN(double MEd, double fcd, double fyd, double hf, double beff, double bw, double d, double ksiefflim) {

        double M1 = fcd*1000*hf/100*(beff-bw)/100*(d-0.5*hf/100);
        double As11=(fcd*1000*hf/100*beff/100-bw/100)/(fyd*1000);
        double M2 = MEd-M1;
        double sceff=(M2)/(fcd*1000*bw/100*Math.pow(d,2));
        double[] Reinforcement={0,0};
        if(sceff>=0.5) {
            System.out.println("Zwiększ przekrój belki!");
            return Reinforcement;
        }
        double ksieff=1-Math.sqrt(1-2*sceff);
        if(ksieff<=ksiefflim) {
            double xeff=ksieff*d;
            double As12=(fcd*1000*bw/100*xeff)/(fyd*1000);
            Reinforcement[0]=As11+As12;
        } else {
            System.out.println("Przekrój podwójnie zbrojony rzeczywiście teowy");
        }
        return Reinforcement;
    }

    public static double[] calculateReinforcementRectangularSGN(double MEd, String ConcreteClass, String RebarClass, int StretchedRebarDiameter,int CompressedRebarDiameter, int StirrupDiameter, int DownCover, int UpperCover, double beamWidth, double beamHight) {
        MEd=Math.abs(MEd);
        double d = (beamHight * 10 - DownCover - StirrupDiameter - ((double) StretchedRebarDiameter / 2)) / 1000;
        Concrete Conc = new Concrete(ConcreteClass);
        double ksiefflim = calculateKsiEffLim(RebarClass);
        double fyd=Rebar.fyd(RebarClass);
        double fcd=Conc.fcd(ConcreteClass);
        double beff=beamWidth/100;
        double sceff=MEd/(fcd*1000*beff*Math.pow(d,2));
        double[] Reinforcement={0,0};
        if(sceff>=0.5) {
            System.out.println("Zwiększ przekrój belki!");
            return Reinforcement;
        }
        double ksieff=1-Math.sqrt(1-2*sceff);
        System.out.println(ksieff);

        if(ksieff<=ksiefflim) {
            Reinforcement=calculateSingleReinforcement(fcd,beff,ksieff,d,fyd);
        } else {
            Reinforcement=calculateDoubleReinforcementRectangle(fcd,beff,d,fyd,ksiefflim,MEd,UpperCover,StirrupDiameter,CompressedRebarDiameter);
        }
        return Reinforcement;
    }

        public static double calculateKsiEffLim(String RebarClass) {
        int Es = Rebar.Es;
        double fyd = Rebar.fyd(RebarClass);
        double epsiloncu2 = Concrete.epsilonCU2;
        double epsilodyd = ((-fyd) / (Es*1000));
        return MathFunctions.round(0.8 * (epsiloncu2) / (epsiloncu2 - epsilodyd),3);
    }

    private static double[] calculateSingleReinforcement(double fcd, double b, double ksieff, double d, double fyd) {
        double[] Reinforcement = {MathFunctions.round((ksieff*d*b*fcd/fyd)*Math.pow(100,2),2),0};
        return Reinforcement;
    }

    public static double[] calculateDoubleReinforcementRectangle(double fcd, double b, double d, double fyd, double ksiefflim, double MEd, double upperCover, int stirrupDiameter, int CompressedRebarDiameter) {
        double MRdprim=ksiefflim*(1-ksiefflim/2)*Math.pow(d,2)*b*fcd*1000;
        double As1prim=ksiefflim*d*b*fcd/fyd*Math.pow(100,2);
        double DeltaMEd=MEd-MRdprim;
        double zprim=(d*1000-upperCover-stirrupDiameter-(double) CompressedRebarDiameter/2)/1000;
        double As2=(DeltaMEd/(fyd*1000*zprim))*Math.pow(100,2);
        double As1=As1prim+As2;
        double[] Reinforecement={MathFunctions.round(As1,2),MathFunctions.round(As2,2)};

        return Reinforecement;
    }

    public static int howManyRebars(double ReinforcementArea, int RebarDiameter) {
        double rebarArea = reinforcementArea(RebarDiameter,1);
        double rebarAmount = ReinforcementArea/rebarArea;
        int rebarRounded;
        if(rebarAmount%1>0.01) {
            rebarRounded=((int) rebarAmount)+1;
        } else
            rebarRounded=(int) rebarAmount;

        return Math.max(rebarRounded,2);
    }

    public static double reinforcementArea(int rebarDiamenter, int amount) {
        return MathFunctions.round(Math.pow((double) rebarDiamenter/20,2)*Math.PI*amount,2);
    }

}



