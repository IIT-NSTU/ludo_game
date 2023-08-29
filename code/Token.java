import java.util.ArrayList;

class Token{
    String token_name;
    int X,Y,pathIndex;

 boolean isOutOfHome(ArrayList<Player> playerList, int i, int[][] greenHomePos, int[][] redHomePos, int[][] blueHomePos, int[][] yellowHomePos) {
    if (playerList.get(i).player_name.equals("Green")) {
        for (int j = 0; j < 4; j++) {
            if (playerList.get(i).token_list[j].X != greenHomePos[j][0] &&
                playerList.get(i).token_list[j].Y != greenHomePos[j][1]) {
                return true;
            }
        }
    }else if (playerList.get(i).player_name.equals("Red")) {
        for (int j = 0; j < 4; j++) {
            if (playerList.get(i).token_list[j].X != redHomePos[j][0] &&
                playerList.get(i).token_list[j].Y != redHomePos[j][1]) {
                return true;
            }
        }
    }else if (playerList.get(i).player_name.equals("Blue")) {
        for (int j = 0; j < 4; j++) {
            if (playerList.get(i).token_list[j].X != blueHomePos[j][0] &&
                playerList.get(i).token_list[j].Y != blueHomePos[j][1]) {
                return true;
            }
        }
    }else if (playerList.get(i).player_name.equals("Yellow")) {
        for (int j = 0; j < 4; j++) {
            if (playerList.get(i).token_list[j].X != yellowHomePos[j][0] &&
                playerList.get(i).token_list[j].Y != yellowHomePos[j][1]) {
                return true;
            }
        }
    }
    return false;
}


    void takeFromHome(int playerIndex, ArrayList<Player> playerList, LudoBoard board, String choice, int[][] path, String[][] border, String[][] square){
        board.removeToken(playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].X, playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].Y, square);
        playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].X=path[0][0];
        playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].Y=path[0][1];
        playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].pathIndex=0;
        board.initializeHome(playerList, square);
        board.printBoard(border, square);
    }
    void moveToken(int playerIndex, ArrayList<Player> playerList, LudoBoard board, String choice, int[][] path, int randomNumber, int player_number, String[][] border, String[][] square, int[][] greenHomePos, int[][] blueHomePos, int[][] yellowHomePos, int[][] redHomePos){
        board.removeToken(playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].X, playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].Y, square);

        // ROAD TO END
        if(path.length>playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].pathIndex+randomNumber){
            playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].pathIndex+=randomNumber;

            playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].X=path[playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].pathIndex][0];
            playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].Y=path[playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].pathIndex][1];

            board.initializeHome(playerList, square);
            board.printBoard(border, square);
        
        // END
        }else if(path.length==playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].pathIndex+randomNumber){
            if(playerIndex==0){
                playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].X=7;
                playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].Y=6;
            }else if(playerIndex==1){
                playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].X=7;
                playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].Y=8;
            }else if(playerIndex==2){
                playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].X=8;
                playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].Y=7;
            }else if(playerIndex==3){
                playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].X=6;
                playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].Y=7;
            }
        }

        for(int i=0;i<player_number;i++){
            if(i==playerIndex)continue;
            for(int j=0;j<playerList.get(i).token_list.length;j++){
                if(
                    playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].X == playerList.get(i).token_list[j].X &&
                    playerList.get(playerIndex).token_list[Character.getNumericValue(choice.charAt(1))-1].Y == playerList.get(i).token_list[j].Y
                ){
                    if(playerList.get(i).player_name=="Green"){
                      playerList.get(i).token_list[j].X=greenHomePos[j][0];
                      playerList.get(i).token_list[j].Y=greenHomePos[j][1];
                    }else if(playerList.get(i).player_name=="Blue"){
                      playerList.get(i).token_list[j].X=blueHomePos[j][0];
                      playerList.get(i).token_list[j].Y=blueHomePos[j][1];
                    }
                    else if(playerList.get(i).player_name=="Red"){
                      playerList.get(i).token_list[j].X=redHomePos[j][0];
                      playerList.get(i).token_list[j].Y=redHomePos[j][1];
                    }else if(playerList.get(i).player_name=="Yellow"){
                      playerList.get(i).token_list[j].X=yellowHomePos[j][0];
                      playerList.get(i).token_list[j].Y=yellowHomePos[j][1];
                    }
                  break;
                }
            }
        }


    }
}