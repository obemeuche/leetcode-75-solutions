package com.algorithm.leetcode75.interviews;

import java.util.ArrayList;
import java.util.List;

public class LiftProgramBankOfAmerica {
    /*
        Lift Program I The task is to program a lift. The environment the lift
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

        System.out.println(getFloors(0,0,2));
        System.out.println(getFloors(1,2,3));

//        System.out.println(Arrays.toString(getFloors_UsingStaticArrays(0, 0, 2)));
//        System.out.println(Arrays.toString(getFloors_UsingStaticArrays(1, 2, 3)));
    }

    static List<Integer> getFloors(int userFloor, int currentFloor, int designatedFloor){
        List<Integer> floors = new ArrayList<>();

        //check if currentFloor is not equal to the userFloor
        if(currentFloor != userFloor){
            if(currentFloor > userFloor){
                //add the currentFloor
                floors.add(currentFloor);
                iterateFloors(floors,userFloor,designatedFloor);
            }else{
                iterateFloors(floors, currentFloor, designatedFloor);
            }

        }else{
            iterateFloors(floors, currentFloor, designatedFloor);
        }
        return floors;
    }

    static void iterateFloors(List<Integer> floors, int firstPosition, int secondPosition){
        for(int i = firstPosition; i <= secondPosition; i++){
            floors.add(i);
        }
    }

//    static int [] getFloors_UsingStaticArrays(int userFloor, int currentFloor, int selectFloor){
////        List<Integer> floors = new ArrayList<>();
//        int [] floors = new int[5];
//
//        //check if currentFloor is not equal to the userFloor
//        if(currentFloor != userFloor){
//            if(currentFloor > userFloor){
//                //add the currentFloor
//                floors[0] = currentFloor;
////                floors.add(currentFloor);
//                iterateArray(floors,userFloor,selectFloor);
//            }else{
//                iterateArray(floors, currentFloor, selectFloor);
//            }
//
//        }else{
//            iterateArray(floors, currentFloor, selectFloor);
//        }
//        return floors;
//    }
//
//    static void iterateArray(int [] floors, int firstPosition, int secondPosition){
//        for(int i = firstPosition; i <= secondPosition; i++){
//            floors[i] = i;
//        }
//    }
}
