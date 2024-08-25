package com.algorithm.leetcode75.interviews;

import java.util.ArrayList;
import java.util.List;

public class LiftProgramBankOfAmerica {
    /*
        Lift Program I
        The task is to program a lift. The environment the lift
        will be operating on has 5 floors. A user presses a button to choose what
        floor they want to access, then the lift should decide its own sequence of
        movement.
        For example •
        Given a user is on floor 0, the user selects floor 2 and the lift is on
        floor 0 => [0, 1, 2].

        • Given a user is on floor 1, the user selects floor 3
        and the lift is on floor 2 => [2, 1, 2, 3]
     */

    public static void main(String[] args) {
        //userFloor == 1
        //designatedFloor == 3
        //currentFloor == 2
        //output == [2,1,2,3]

        //userFloor == 0
        //designatedFloor == 2
        //currentFloor == 0
        //output == [0,1,2]

        System.out.println(getFloors(0,4,5));
        System.out.println(getFloors(1,2,3));

    }

    static List<Integer> getFloors(int userFloor, int currentFloor, int designatedFloor){
        List<Integer> floors = new ArrayList<>();

        //check if currentFloor is not equal to the userFloor
        if(currentFloor != userFloor){
            if(currentFloor > userFloor){
                //move to user floor
                for(int i = currentFloor; i >= userFloor; i--){
                    floors.add(i);
                }
//                iterateFloors(floors,userFloor,designatedFloor);
            }else{
                moveToDesignatedFloor(floors, currentFloor, designatedFloor);
            }

        }else{
            moveToDesignatedFloor(floors, currentFloor, designatedFloor);
        }
        return floors;
    }

    static void moveToDesignatedFloor(List<Integer> floors, int firstPosition, int secondPosition){
        for(int i = firstPosition; i <= secondPosition; i++){
            floors.add(i);
        }
    }
}
