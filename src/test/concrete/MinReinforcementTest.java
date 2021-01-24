package test.concrete;

import main.concrete.MinReinforcement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinReinforcementTest {

    @Test
    void calculateK_h50_086() {
        //given
        double h = 50;

        //when
        double testAnswer = MinReinforcement.calculateK(h);

        //then
        Assertions.assertEquals(0.86,testAnswer);
    }

    @Test
    void calculateK_h20_1() {
        //given
        double h = 20;

        //when
        double testAnswer = MinReinforcement.calculateK(h);

        //then
        Assertions.assertEquals(1.00,testAnswer);
    }

    @Test
    void calculateK_h200_1() {
        //given
        double h = 200;

        //when
        double testAnswer = MinReinforcement.calculateK(h);

        //then
        Assertions.assertEquals(0.65,testAnswer);
    }

    @Test
    void calculateMinimalReinforcement_CorrectParameters_2329() {
        //given
        String ConcreteClass="C25/30";
        String RebarClass="A-IIIN";
        int MainRebarDiameter=16;
        int StirrupDiameter=8;
        int ConcreteCover=20;
        double ConcreteCrack=0.3;
        double beamWidth=25;
        double beamHight=50;

        //when
        double testAnswer = MinReinforcement.calculateMinimalReinforcement(ConcreteClass,RebarClass,MainRebarDiameter,StirrupDiameter,ConcreteCover,ConcreteCrack,beamWidth,beamHight);
        //then
        Assertions.assertEquals(2.329,testAnswer);
    }


    @Test
    void calculateMinimalReinforcement_CorrectParameters_17063() {
        //given
        String ConcreteClass="C40/50";
        String RebarClass="A-III";
        int MainRebarDiameter=25;
        int StirrupDiameter=12;
        int ConcreteCover=50;
        double ConcreteCrack=0.2;
        double beamWidth=50;
        double beamHight=120;

        //when
        double testAnswer = MinReinforcement.calculateMinimalReinforcement(ConcreteClass,RebarClass,MainRebarDiameter,StirrupDiameter,ConcreteCover,ConcreteCrack,beamWidth,beamHight);
        //then
        Assertions.assertEquals(17.063,testAnswer);
    }


    @Test
    void calculateMinimalReinforcement_CorrectParameters_13617() {
        //given
        String ConcreteClass="C30/37";
        String RebarClass="A-IIIN";
        int MainRebarDiameter=25;
        int StirrupDiameter=8;
        int ConcreteCover=35;
        double ConcreteCrack=0.4;
        double beamWidth=50;
        double beamHight=70;
        double beff1=50;
        double beff2=40;
        double slabThickness=20;

        //when
        double testAnswer = MinReinforcement.calculateMinimalReinforcement(ConcreteClass,RebarClass,MainRebarDiameter,StirrupDiameter,ConcreteCover,ConcreteCrack,beamWidth,beamHight,beff1,beff2,slabThickness);
        //then
        Assertions.assertEquals(13.617,testAnswer);
    }



}