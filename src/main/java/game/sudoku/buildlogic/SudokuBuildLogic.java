package game.sudoku.buildlogic;

import game.sudoku.computationallogic.GameLogic;
import game.sudoku.persistance.LocalStorage;
import game.sudoku.problemdomain.IStorage;
import game.sudoku.problemdomain.SudokuGame;
import game.sudoku.userinterface.IUserInterfaceContract;
import game.sudoku.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException{
        SudokuGame initialState;

        IStorage storage = new LocalStorage();

        try {
            //will throw if no game data is found in local storage

            initialState = storage.getGameData();
        } catch (IOException e) {

            initialState = GameLogic.getNewgame();
            //this method below will also throw an IOException
            //if we cannot update the game data. At this point
            //the application is considered unrecoverable
            storage.updateGameData(initialState);
        }

        try{
            initialState = storage.getGameData();
        }catch(IOException e){
            initialState = GameLogic.getNewgame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic =
                new ControlLogic(storage, userInterface);

        userInterface.setListener((uiLogic));
        userInterface.updateBoard(initialState);

    }
}
