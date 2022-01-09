class Solution {
    public boolean isRobotBounded(String instructions) {
         int x = 0;
        int y = 0;
		//Keep track of directions
        String dir = "North";
    //     N
    // W<----->E
    //     S
	
	//Caluculate position
        for(char c : instructions.toCharArray()){
            if(c == 'G'){
                if(dir.equals("North")){y++;}
                else if(dir.equals("East")){x++;}
                else if(dir.equals("South")){y--;}
                else {x--;}
            }
            else if(c == 'L'){
                if(dir.equals("North")){dir = "West";}
                else if(dir.equals("East")){dir = "North";}
                else if(dir.equals("South")){dir = "East";}
                else {dir = "South";}
            }
            else{
                if(dir.equals("North")){dir = "East";}
                else if(dir.equals("East")){dir = "South";}
                else if(dir.equals("South")){dir = "West";}
                else {dir = "North";}
            }
        }
        //Check if calutucated position is starting position
        if(x == 0 && y == 0){
            return true;
        }
		//check if the final faced direction is not North(Strarting DIrection)
        if(dir.equals("North")){
            return false;
        }
        return true;

    }
}