package util;

import models.Board;

public class PrepareExpectedResponse {


        public static Board prepareExpectedResponse(String id, String name, String desc) {
            Board expectedBoard = new Board();
            expectedBoard.setId(id);
            expectedBoard.setName(name);
            expectedBoard.setDesc(desc);
            return expectedBoard;
        }

}
