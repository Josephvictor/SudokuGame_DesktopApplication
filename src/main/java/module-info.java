module game.sudoku.sudokugamejavadesktopapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens game.sudoku.sudokugamejavadesktopapp to javafx.fxml;
    exports game.sudoku.sudokugamejavadesktopapp;
}