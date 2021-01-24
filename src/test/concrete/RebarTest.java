package test.concrete;

import main.concrete.Rebar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RebarTest {


    @Test
    void fyk_AIIIN_500() {
        //given
        String SteelClass = "A-IIIN";

        //when
        int testAnswer = Rebar.fyk(SteelClass);

        //then
        Assertions.assertEquals(500, testAnswer);
    }


    @Test
    void fyk_IncorrectInput_0() {
        //given
        String SteelClass = "Zielony";

        //when
        int testAnswer = Rebar.fyk(SteelClass);

        //then
        Assertions.assertEquals(0, testAnswer);
    }

    @Test
    void sigmas_CorrectDiamAndCrack_240() {
        //given
        double ConcreteCrack=0.3;
        int MainRebarDiameter=16;

        //when
        int testAnswer=Rebar.calculateRebarSigma(ConcreteCrack, MainRebarDiameter);

        //then
        Assertions.assertEquals(240,testAnswer);
    }


    @Test
    void sigmas_CorrectDiamAndCrack_200() {
        //given
        double ConcreteCrack=0.3;
        int MainRebarDiameter=20;

        //when
        int testAnswer=Rebar.calculateRebarSigma(ConcreteCrack, MainRebarDiameter);

        //then
        Assertions.assertEquals(200,testAnswer);
    }



    @Test
    void sigmas_CorrectDiamAndCrack_360() {
        //given
        double ConcreteCrack=0.2;
        int MainRebarDiameter=5;

        //when
        int testAnswer=Rebar.calculateRebarSigma(ConcreteCrack, MainRebarDiameter);

        //then
        Assertions.assertEquals(360,testAnswer);
    }


    @Test
    void sigmas_InCorrectDiamAndCrack_0() {
        //given
        double ConcreteCrack=0.5;
        int MainRebarDiameter=10;

        //when
        int testAnswer=Rebar.calculateRebarSigma(ConcreteCrack, MainRebarDiameter);

        //then
        Assertions.assertEquals(0,testAnswer);
    }



    @Test
    void sigmas_InCorrectDiamAndCrack2_0() {
        //given
        double ConcreteCrack=0.3;
        int MainRebarDiameter=1;

        //when
        int testAnswer=Rebar.calculateRebarSigma(ConcreteCrack, MainRebarDiameter);

        //then
        Assertions.assertEquals(0,testAnswer);
    }




}