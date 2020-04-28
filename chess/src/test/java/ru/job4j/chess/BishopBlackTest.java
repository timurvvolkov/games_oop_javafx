package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void positionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell rsl = bishopBlack.position();
        assertThat(rsl, is(Cell.C8));
    }

    @Test
    public void copyTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F8);
        Figure figure = bishopBlack.copy(Cell.D6);
        Cell rsl = figure.position();
        assertThat(rsl, is(Cell.D6));
    }

    @Test
    public void wayTestUpRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] rsl = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] cellArray = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(rsl, is(cellArray));
    }

    @Test
    public void wayTestUpLeft() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H2);
        Cell[] rsl = bishopBlack.way(Cell.H2, Cell.E5);
        Cell[] cellArray = {Cell.G3, Cell.F4, Cell.E5};
        assertThat(rsl, is(cellArray));
    }

    @Test
    public void wayTestDownRight() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D7);
        Cell[] rsl = bishopBlack.way(Cell.D7, Cell.H3);
        Cell[] cellArray = {Cell.E6, Cell.F5, Cell.G4, Cell.H3};
        assertThat(rsl, is(cellArray));
    }

    @Test
    public void wayTestDownLeft() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] rsl = bishopBlack.way(Cell.D4, Cell.A1);
        Cell[] cellArray = {Cell.C3, Cell.B2, Cell.A1};
        assertThat(rsl, is(cellArray));
    }

    @Test
    public void noDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A1);
        String rsl = "";
        String expect = "Could not move by diagonal from A1 to H7";
        try {
            Cell[] cells = bishopBlack.way(Cell.A1, Cell.H7);
        } catch (IllegalStateException e) {
            rsl = e.getMessage();
        }
        assertThat(rsl, is(expect));
    }
}
