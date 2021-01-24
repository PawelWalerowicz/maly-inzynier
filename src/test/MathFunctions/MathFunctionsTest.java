package test.MathFunctions;

import main.common.MathFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathFunctionsTest {

    @Test
    void round_CorrectRoundup1() {
        //given
        double input = 37;
        int decimalplaces=0;

        //when
        double testAnswer = MathFunctions.round(input,decimalplaces);

        //then
        Assertions.assertEquals(37, testAnswer);
    }


    @Test
    void round_CorrectRoundup2() {
        //given
        double input = 36.32323212515964132;
        int decimalplaces=2;


        //when
        double testAnswer = MathFunctions.round(input,decimalplaces);

        //then
        Assertions.assertEquals(36.32, testAnswer);
    }



    @Test
    void round_CorrectRoundup3() {
        //given
        double input = 0.00001;
        int decimalplaces=2;

        //when
        double testAnswer = MathFunctions.round(input,decimalplaces);

        //then
        Assertions.assertEquals(0.00, testAnswer);
    }




    @Test
    void round_CorrectRoundup4() {
        //given
        double input = -2;
        int decimalplaces=2;

        //when
        double testAnswer = MathFunctions.round(input,decimalplaces);

        //then
        Assertions.assertEquals(-2.00, testAnswer);
    }


    @Test
    void round_InCorrectRoundup1() {
        //given
        double input = -2;
        int decimalplaces=-20;

        //when
        double testAnswer = MathFunctions.round(input,decimalplaces);

        //then
        Assertions.assertEquals(0, testAnswer);
    }

    @Test
    void interpolate_CorrectParams_5() {
        //given
        double x=3;
        double x0=1;
        double y0=1;
        double x1=5;
        double y1=5;

        //when
        double testAnswer = MathFunctions.interpolate(x, x0, y0, x1, y1);

        //then
        Assertions.assertEquals(3, testAnswer);
    }

    @Test
    void interpolate_InCorrectParams_0() {
        //given
        double x=3;
        double x0=1;
        double y0=1;
        double x1=1;
        double y1=5;

        //when
        double testAnswer = MathFunctions.interpolate(x, x0, y0, x1, y1);

        //then
        Assertions.assertEquals(0,testAnswer);
    }


}

