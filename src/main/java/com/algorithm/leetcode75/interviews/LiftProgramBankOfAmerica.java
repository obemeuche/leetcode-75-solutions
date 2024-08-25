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
        System.out.println(getFloors(0,0,2));
        System.out.println(getFloors(5,5,0));
        System.out.println(getFloors(1,2,3));
        System.out.println(getFloors(4,1,3));
        System.out.println(getFloors(4,3,1));
        System.out.println(getFloors(4,0,2));

    }

    static List<Integer> getFloors(int userFloor, int currentFloor, int designatedFloor){
        List<Integer> floors = new ArrayList<>();

        //check if currentFloor is not equal to the userFloor
        if(currentFloor != userFloor){
            if(currentFloor > userFloor){
                //move to user floor in descending order
                for(int i = currentFloor; i > userFloor; i--){
                    floors.add(i);
                }
            }else{
                //move to user floor in ascending order
                for(int i = currentFloor; i < userFloor; i++){
                    floors.add(i);
                }
            }
        }
        if(designatedFloor > userFloor){
            //move to ascending designated floor
            moveToDesignatedFloorAsc(floors,userFloor,designatedFloor);
        }else{
            //move to descending designated floor
            moveToDesignatedFloorDesc(userFloor, designatedFloor, floors);
        }
        return floors;
    }

    private static void moveToDesignatedFloorDesc(int userFloor, int designatedFloor, List<Integer> floors) {
        for(int i = userFloor; i >= designatedFloor; i--){
            floors.add(i);
        }
    }

    private static void moveToDesignatedFloorAsc(List<Integer> floors, int userFloor, int designatedFloor){
        for(int i = userFloor; i <= designatedFloor; i++){
            floors.add(i);
        }
    }
}
