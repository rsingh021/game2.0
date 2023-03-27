package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class : UIController.java
 * This class is the UI version of the DB Tutorial
 */
public class UIController {
    @FXML private TextArea descTA;
    @FXML private TextField cmdTF;
    @FXML private TextField numTF;

    private int number = 0;

    private GameController gc = new GameController();

    /**
     * Method: cancel
     * Purpose: Closes the DOA application
     * @return void
     */
    @FXML
    public void cancel() {
        Stage stage = (Stage) descTA.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void process() throws SQLException{
        String retStr = "";
        descTA.clear();
        try {
            number = Integer.parseInt(cmdTF.getText());
            switch (number) {
                case 1: {
                    retStr = buildStrs(gc.getAllRoomsData());
                    descTA.setText(retStr);
                    break;
                }
                case 2: {
                    int room = 0;
                    try{
                        room = Integer.parseInt(numTF.getText());
                        retStr = gc.getRoomData(room);
                        descTA.setText(retStr);
                    }
                    catch(NumberFormatException nfe){
                        descTA.setText("You must enter an int for the room number");
                    }
                    catch(SQLException sqe){
                        descTA.setText(("Room " + room + " was not found."));
                    }
                    break;
                }
                case 3: {
                    retStr = buildStrs(gc.getAllMonstersData());
                    descTA.setText(retStr);
                    break;
                }
                case 4: {
                    int monster = 0;
                    try{
                        monster = Integer.parseInt(numTF.getText());
                        retStr = gc.getMonsterData(monster);
                        descTA.setText(retStr);
                    }
                    catch(NumberFormatException nfe){
                        descTA.setText("You must enter an int for the monster number");
                    }
                    catch(SQLException sqe){
                        descTA.setText(("Monster " + monster + " was not found."));
                    }
                    break;
                }
                case 5: {
                    int room = 0;
                    try {
                        room = Integer.parseInt(numTF.getText());

                        retStr = gc.getMonsterRoomData(room);
                    }
                    catch(NumberFormatException nfe){
                        descTA.setText("You must enter an int for the room number");
                    }
                    catch(GameException ge){
                        descTA.setText(ge.getMessage());
                    }
                    descTA.setText(retStr);
                    break;
                }
                case 6: {
                    try {
                        retStr = buildStrs(gc.getAllMonsterRoomData());
                        descTA.setText(retStr);
                    }
                    catch (GameException ge) {
                        System.out.println(ge.getMessage());
                    }
                    break;
                }
                default: {
                    retStr = "Error: Invalid command";
                    descTA.setText(retStr);
                }
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            descTA.setText(e.getMessage());
        }
        catch(NumberFormatException nfe){
            descTA.setText("You must enter a number for the command");
        }

    }

    private String buildStrs(ArrayList<String> strs) {
        String retStr = "";
        for (String str : strs) {
            retStr += str;
            retStr += "\n";
        }
        return retStr;
    }
}
