/*
* Name: SIDDHARTH PATHAK
* ID: V00876495
* Date: MARCH 12th, 2017
* Filename: MazeSolver.java
* 
*/


/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the
 *   description.
 *
 * 
 */

public class MazeSolver {
    public static String findPath(Maze maze) {
        
        Stack<MazeLocation> solution=new StackRefBased<MazeLocation>();
        MazeLocation entry=maze.getEntry();
        MazeLocation exit=maze.getExit();
        solution.push(entry);
        
        int totalRows=maze.getNumRows();
        int totalCols=maze.getNumCols();
        boolean[][] visit= new boolean[totalRows][totalCols];
    
        int cRow=entry.getRow();
    	int cCol=entry.getCol();
        	visit[cRow][cCol]=true;          //position visited shown through boolean
        	
        while(!solution.isEmpty() && !entry.equals(exit)){
        	
        	if(solution==null){
				break;
        	}
        	if(!maze.isWall(cRow,cCol+1) && visit[cRow][cCol+1]==false){	  	 //checks element on right, if not a wall and not visited
        		cCol=cCol+1;												  	//moves right
				entry=new MazeLocation(cRow,cCol);								//creates a new node to push to stack,
        		visit[cRow][cCol]=true;										 	//marks position as visited
        		solution.push(entry);											
    	 	}	
        	else if(!maze.isWall(cRow+1,cCol) && visit[cRow+1][cCol]==false){  		 //checks element on top, if not a wall and not visited
	        	cRow=cRow+1;     												//moves up
        		entry=new MazeLocation(cRow,cCol);								//creates a new node to push to stack,
        		visit[cRow][cCol]=true;											 //marks position as visited
        		solution.push(entry);											 
        	}	
        	
    	 	else if(!maze.isWall(cRow-1,cCol) && visit[cRow-1][cCol]==false){    	//checks element on bottom, if not a wall and not visited
        		cRow=cRow-1;													//moves down
        		entry=new MazeLocation(cRow,cCol);								//creates a new node to push to  stack,
        		visit[cRow][cCol]=true;		 									//marks position as visited
        		solution.push(entry);											
        	}
        	else if(!maze.isWall(cRow,cCol-1) && visit[cRow][cCol-1]==false){		//checks element on left, if not a wall and not visited
	 	 		cCol=cCol-1;													//moves left
	 	 		entry=new MazeLocation(cRow,cCol);								//creates a new node to push to stack
        		visit[cRow][cCol]=true;											//marks position as visited,
        		solution.push(entry);										
	 	 	}
	 	 	
        	
        	else{															//if obstructions in all sides pop the element
        		try{														//and start again with the previous element 
        			solution.pop();											
        			MazeLocation lastElement= solution.peek();							
        			if(lastElement==null){
        			break;
        			}
        			else{	
        			int R=lastElement.getRow();;										//Use row and column of the previous element 
        			int C=lastElement.getCol();										//for the path to solve the maze
           			cRow = R;
        			cCol = C;
        			
        			}
        		}
        		catch(StackEmptyException E){								//exit the loop, if the stack becomes empty.
					entry=exit;
        		}
        	}        	
        }
        																	//return the solution in the form of a string.
        if(solution.isEmpty()){
        	return "";
        }																	
        else{
        Stack<MazeLocation> printSolution=new StackRefBased<MazeLocation>();
    	try{
    		while(!solution.isEmpty()){
    			printSolution.push(solution.pop());
    		}
    	}
    	catch(StackEmptyException see){
    		System.out.println("");
    	}
        String result = printSolution.toString();
        return result;
        }
    }
}
