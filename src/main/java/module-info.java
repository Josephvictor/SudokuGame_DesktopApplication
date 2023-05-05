module game.sudoku.sudokugamejavadesktopapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens game.sudoku to javafx.fxml;
    exports game.sudoku;
}