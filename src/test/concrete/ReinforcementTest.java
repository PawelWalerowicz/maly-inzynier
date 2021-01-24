package test.concrete;

import main.concrete.Reinforcement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static main.concrete.Reinforcement.*;

class ReinforcementTest {
    @Test
    void calculateReinforcementRectangularSGN_Correct_Parameters_1221() {
        //given
        double MEd = 216.49;
        String ConcreteClass = "C30/37";
        String RebarClass = "A-IIIN";
        int MainRebarDiameter = 16;
        int StirrupDiameter = 8;
        int ConcreteCover = 35;
        double beamWidth = 30;
        double beamHight = 50;

        //when
        double[] testAnswer = calculateReinforcementRectangularSGN(MEd, ConcreteClass, RebarClass, MainRebarDiameter, MainRebarDiameter, StirrupDiameter, ConcreteCover, ConcreteCover, beamWidth, beamHight);
        //then
        Assertions.assertEquals(12.21, testAnswer[0]);

    }

    @Test
    void calculateDoubleReinforcementRectangle_Correct_2723573() {
        //given
        double fcd = 17.9;
        double b = 0.25;
        double d = 0.425;
        double fyd = 434.783;
        double ksiefflim = 0.493;
        double MEd = 400;
        double upperCover = 10;
        int stirrupDiameter = 5;
        int CompressedRebarDiameter = 10;

        //when
        double[] testAnswer = calculateDoubleReinforcementRectangle(fcd, b, d, fyd, ksiefflim, MEd, upperCover, stirrupDiameter, CompressedRebarDiameter);
        //then
        Assertions.assertEquals(27.23, testAnswer[0]);
        Assertions.assertEquals(5.66, testAnswer[1]);
    }


    @Test
    void calculateDoubleReinforcementRectangle_incorrect_param_1() {
        //given
        double fcd = 0;
        double b = 0.25;
        double d = 0.425;
        double fyd = 434.783;
        double ksiefflim = 0.493;
        double MEd = 400;
        double upperCover = 10;
        int stirrupDiameter = 5;
        int CompressedRebarDiameter = 10;

        //when
        double[] testAnswer = calculateDoubleReinforcementRectangle(fcd, b, d, fyd, ksiefflim, MEd, upperCover, stirrupDiameter, CompressedRebarDiameter);
        //then
        Assertions.assertEquals(27.23, testAnswer[0]);
        Assertions.assertEquals(5.66, testAnswer[1]);
    }


    @Test
    void calculateKsiEffLim_Correct_0493() {
        //given
        String RebarClass = "A-IIIN";

        //when
        double testAnswer = Reinforcement.calculateKsiEffLim(RebarClass);
        //then
        Assertions.assertEquals(0.493, testAnswer);

    }

    @Test
    void howManyRebarsTest_1() {
        //given
        Double ReinforcementArea = 22.3;
        int RebarDiameter = 16;
        //when
        double testAnswer = Reinforcement.howManyRebars(ReinforcementArea, RebarDiameter);
        //then
        Assertions.assertEquals(12, testAnswer);

    }

    @Test
    void howManyRebarsTest_2() {
        //given
        Double ReinforcementArea = 0.3;
        int RebarDiameter = 8;
        //when
        double testAnswer = Reinforcement.howManyRebars(ReinforcementArea, RebarDiameter);
        //then
        Assertions.assertEquals(2, testAnswer);

    }


    @Test
    void howManyRebarsTest_3() {
        //given
        Double ReinforcementArea = 12.44;
        int RebarDiameter = 12;
        //when
        double testAnswer = Reinforcement.howManyRebars(ReinforcementArea, RebarDiameter);
        //then
        Assertions.assertEquals(11, testAnswer);

    }

    @Test
    void reinforcementAreaTest() {
        Assertions.assertEquals(0.13, reinforcementArea(4, 1));
        Assertions.assertEquals(6.03, reinforcementArea(16, 3));
        Assertions.assertEquals(3.14, reinforcementArea(20, 1));
        Assertions.assertEquals(31.42, reinforcementArea(20, 10));

    }

    @Test
    void checkIfReallyTBeamShapeTest() {
        double[] answer=Reinforcement.checkIfReallyTBeamShape(150,"C25/30","A-IIIN",16,16,8,9,9,20,40,18,15,15);
        Assertions.assertEquals(9.83,answer[0]);
        //double[] answer2=Reinforcement.checkIfReallyTBeamShape(480,"C25/30","A-IIIN",16,16,8,9,9,20,40,18,15,15);
       // Assertions.assertEquals(39.73,answer2[0]);

    }



}





