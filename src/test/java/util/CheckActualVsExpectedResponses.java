package util;

import models.Board;
import org.testng.Assert;

public class CheckActualVsExpectedResponses {


        public static void checkBoardEquality(Board actualBoard, Board expectedBoard) {

            Assert.assertEquals(actualBoard.getId(), expectedBoard.getId(), "Board ID mismatch");
            Assert.assertEquals(actualBoard.getName(), expectedBoard.getName(), "Board Name mismatch");
            Assert.assertEquals(actualBoard.getDesc(), expectedBoard.getDesc(), "Board Description mismatch");
        }


}
