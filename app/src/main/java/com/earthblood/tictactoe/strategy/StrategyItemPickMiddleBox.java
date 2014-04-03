package com.earthblood.tictactoe.strategy;

import android.util.Log;

import com.earthblood.tictactoe.application.Toe;
import com.earthblood.tictactoe.util.GameSymbol;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author John Piser developer@earthblood.com
 *         Copyright 2014.
 *
 *
 *         PICK THE MIDDLE BOX IF AVAILABLE
 */
public class StrategyItemPickMiddleBox extends StrategyItem {


    public StrategyItemPickMiddleBox(StrategyItem successor) {
        this.setSuccessor(successor);
    }

    public int execute(int[] selectedXBoxIds, int[] selectedOBoxIds, GameSymbol androidSymbol){
        Log.d(Toe.TAG, "Inside StrategyItemPickMiddleBox");
        int boxId = getBoxId(selectedXBoxIds, selectedOBoxIds, androidSymbol);
        if(ArrayUtils.contains(ALL_BOXES, boxId)){
            Log.d(Toe.TAG, "Found: " + boxId);
            return boxId;
        }
        else{
            return super.execute(selectedXBoxIds, selectedOBoxIds, androidSymbol);
        }
    }


    public int getBoxId(int[] selectedXBoxIds, int[] selectedOBoxIds, GameSymbol androidSymbol) {

        int[] currentlySelectedBoxes = ArrayUtils.addAll(selectedXBoxIds, selectedOBoxIds);
        currentlySelectedBoxes = ArrayUtils.removeElements(currentlySelectedBoxes, DEFAULT_ZEROS);
        int[] availableBoxes = ArrayUtils.removeElements(ALL_BOXES, currentlySelectedBoxes);

        if(ArrayUtils.contains(availableBoxes, MIDDLE_BOX_POSITION)){
            return MIDDLE_BOX_POSITION;
        }
        else{
            return NOT_FOUND;
        }
    }
}