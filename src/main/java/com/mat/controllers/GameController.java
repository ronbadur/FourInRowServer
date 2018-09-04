package com.mat.controllers;

import com.mat.enums.Color;
import com.mat.minimax.MiniMaxAgent;
import com.mat.minimax.State;
import com.mat.models.GameBoard;
import com.mat.models.Round;
import com.mat.models.RoundResult;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@CrossOrigin(origins = "*")
public class GameController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping(path = "/colorTheLowestWhiteCellInColumn")
    @ResponseBody
    public RoundResult colorTheLowestWhiteCellInColumn(@RequestBody Round round) {
        boolean isCellGotColored = colorCell(round);

        return new RoundResult(round.getGameBoard(), isCellGotColored);
    }


    @PostMapping(path = "/colorBestPlaceForComputer")
    @ResponseBody
    public RoundResult colorBestPlaceForComputer(@RequestBody Round round){
        GameBoard gameBoard = clone(round.getGameBoard());
        MiniMaxAgent miniMaxAgent = new MiniMaxAgent();
        State state = new State(round.getGameBoard());
        int column = miniMaxAgent.getAction(state);
        round.setColumn(column);
        round.setGameBoard(gameBoard);
        boolean isCellGotColored = colorCell(round);

        return new RoundResult(round.getGameBoard(), isCellGotColored);
    }

    private boolean colorCell(Round round) {
        boolean isCellGotColored = false;

        for (int i = round.getGameBoard().getGrid().length - 1; i >= 0 && !isCellGotColored; i--) {
            if (round.getGameBoard().getGrid()[i][round.getColumn()].getColor().toString().toLowerCase().equals("white")) {
                round.getGameBoard().getGrid()[i][round.getColumn()].setColor(Color.valueOf(round.getColor().toUpperCase()));
                isCellGotColored = true;
            }
        }
        return isCellGotColored;
    }

    public GameBoard clone(GameBoard gameBoardToClone) {
        GameBoard newGameBoard = new GameBoard();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(gameBoardToClone);
            oos.flush();
            oos.close();
            bos.close();
            byte[] byteData = bos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
            newGameBoard = (GameBoard) new ObjectInputStream(bais).readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return newGameBoard;
    }
}
