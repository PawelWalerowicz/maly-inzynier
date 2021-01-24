package test.concrete;

import main.concrete.Concrete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.*;

class ConcreteTest {

    @Test
    public void ClassStripper_correctStringC3037_return37() {
        //given
        String classesB = "C30/37";
        Concrete testConcrete = new Concrete(classesB);

        //when
        int testAnswer = testConcrete.ClassStripper(classesB);

        //then
        Assertions.assertEquals(37, testAnswer);
    }

    @Test
    public void ClassStripper_incorrectString123437() {
        //given
        String classesB = "123437";
        Concrete testConcrete = new Concrete(classesB);

        //when
        int testAnswer = testConcrete.ClassStripper(classesB);

        //then
        Assertions.assertEquals(-1, testAnswer);
    }

    @Test
    public void ClassStripper_incorrectStringC3030() {
        //given
        String classesB = "C30/30";
        Concrete testConcrete = new Concrete(classesB);

        //when
        int testAnswer = testConcrete.ClassStripper(classesB);

        //then
        Assertions.assertEquals(-1, testAnswer);
    }

    @Test
    public void fck_IncorrectInt11() {
        //given
        int classesB = 11;
        Concrete testConcrete = new Concrete(classesB);

        //when
        int testAnswer = testConcrete.fck(classesB);

        //then
        Assertions.assertEquals(-1, testAnswer);
    }

    @Test
    public void fck_CorrectInt25_returnsCorrectClass20() {
        //given
        int classesB = 25;
        Concrete testConcrete = new Concrete(classesB);

        //when
        int testAnswer = testConcrete.fck(classesB);

        //then
        Assertions.assertEquals(20, testAnswer);
    }

    @Test
    public void fck_CorrectStringC2025_returns20() {
        //given
        String classesB = "C20/25";
        Concrete testConcrete = new Concrete(classesB);

        //when
        int testAnswer = testConcrete.fck(classesB);

        //then
        Assertions.assertEquals(20, testAnswer);
    }



    @Test
    void fcd_CorrectStringC2025_returns1429() {
        //given
        String classesB = "C20/25";
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fcd(classesB);

        //then
        Assertions.assertEquals(14.29, testAnswer);
    }

    @Test
    void fcd_CorrectInt37_returns2143() {
        //given
        int classesB = 37;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fcd(classesB);

        //then
        Assertions.assertEquals(21.43, testAnswer);
    }

    @Test
    void fcd_InCorrectInt7() {
        //given
        int classesB = 7;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fcd(classesB);

        //then
        Assertions.assertEquals(-1, testAnswer);
    }



    @Test
    void fcm_CorrectStringC2025_returns28() {
        //given
        String classesB = "C20/25";
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fcm(classesB);

        //then
        Assertions.assertEquals(28, testAnswer);
    }

    @Test
    void fcm_CorrectInt37_returns38() {
        //given
        int classesB = 37;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fcm(classesB);

        //then
        Assertions.assertEquals(38, testAnswer);
    }

    @Test
    void fcm_InCorrectInt7_returns0() {
        //given
        int classesB = 7;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fcm(classesB);

        //then
       //Assertions.assertEquals(java.lang.NumberFormatException, testAnswer);
        Assertions.assertEquals(-1,testAnswer);
    }



    @Test
    void fctm_CorrectStringC2025_returns22() {
        //given
        String classesB = "C20/25";
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fctm(classesB);

        //then
        Assertions.assertEquals(2.2, testAnswer);
    }

    @Test
    void fctm_CorrectInt37_returns29() {
        //given
        int classesB = 37;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fctm(classesB);

        //then
        Assertions.assertEquals(2.9, testAnswer);
    }

    @Test
    void fctm_InCorrectInt7() {
        //given
        int classesB = 7;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fctm(classesB);

        //then
        Assertions.assertEquals(-1, testAnswer);
    }



    @Test
    void fctk_CorrectStringC2025_returns15() {
        //given
        String classesB = "C20/25";
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fctk(classesB);

        //then
        Assertions.assertEquals(1.5, testAnswer);
    }

    @Test
    void fctk_CorrectInt37_returns29() {
        //given
        int classesB = 37;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fctk(classesB);

        //then
        Assertions.assertEquals(2.0, testAnswer);
    }

    @Test
    void fctk_InCorrectInt7() {
        //given
        int classesB = 7;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.fctk(classesB);

        //then
        Assertions.assertEquals(-1, testAnswer);
    }

    @Test
    void Ecm_CorrectStringC2025_returns30() {
        //given
        String classesB = "C20/25";
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.Ecm(classesB);

        //then
        Assertions.assertEquals(30, testAnswer);
    }

    @Test
    void Ecm_CorrectInt37_returns32() {
        //given
        int classesB = 37;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.Ecm(classesB);

        //then
        Assertions.assertEquals(32, testAnswer);
    }

    @Test
    void Ecm_InCorrectInt7() {
        //given
        int classesB = 7;
        Concrete testConcrete = new Concrete(classesB);

        //when
        double testAnswer = testConcrete.Ecm(classesB);

        //then
        Assertions.assertEquals(-1, testAnswer);
    }

    @Test
    void validBeton_InCorrectInt7_returnsFalse() {
        //given
        int classesB = 7;
        Concrete testConcrete = new Concrete(classesB);

        //when
        boolean testAnswer = testConcrete.validBeton(classesB);

        //then
        Assertions.assertEquals(false, testAnswer);
    }


    @Test
    void validBeton_CorrectInt25_returnsTrue() {
        //given
        int classesB = 25;
        Concrete testConcrete = new Concrete(classesB);

        //when
        boolean testAnswer = testConcrete.validBeton(classesB);

        //then
        Assertions.assertEquals(true, testAnswer);
    }

    @Test
    void validBeton_CorrectStringC3037_returnsTrue() {
        //given
        String classesB = "C30/37";
        Concrete testConcrete = new Concrete(classesB);

        //when
        boolean testAnswer = testConcrete.validBeton(classesB);

        //then
        Assertions.assertEquals(true, testAnswer);
    }


    @Test
    void validBeton_InCorrectStringC3030_returnsFalse() {
        //given
        String classesB = "C30/30";
        Concrete testConcrete = new Concrete(classesB);

        //when
        boolean testAnswer = testConcrete.validBeton(classesB);

        //then
        Assertions.assertEquals(false, testAnswer);
    }
/*



    @Test
    void validBeton() {
    }

    @Test
    void testValidBeton() {
    }

    @Test
    void testValidBeton1() {
    }
    */
}