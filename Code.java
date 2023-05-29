package misc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class main_misc2 {
	
	
   
	
	
	public static void main(String[] args) {
	//(a+b)%k = ((a % k)+(b % k)) % k    || ||
	
		ArrayList<ArrayList<Integer>> board = create_board(8);
		n_queens(0,board,8);
		
		
		
		
	}	
	
	private static ArrayList<ArrayList<Integer>> create_board(int n){
		
		ArrayList<ArrayList<Integer>> board = new ArrayList<>();
		for(int i = 0;i < n;i++) {
			board.add(new ArrayList<>());
			for(int j = 0;j < n;j++) {
				board.get(i).add(0);
			}
		}
		return board;
		
	}
	
	private static void print_board(ArrayList<ArrayList<Integer>> board){
		
		for(int i = 0;i < board.size();i++){
			System.out.println(board.get(i));
		}
		
	}
	
	
	private static boolean valid_spot(int x,int y,ArrayList<ArrayList<Integer>> board,int n){
		
		for(int i = 0;i < n;i++) {
			
			if(board.get(i).get(y) == 1) {
				return false;
			}
			if(board.get(x).get(i) == 1) {
				return false;
			}
		}
		
		//diagonal -->
		int a = x;
		int b = x;
		for(int i = y+1;i < n;i++) {
			a++;
			b--;
			if(a < n) {
				if(board.get(a).get(i) == 1) {
					return false;
				}
			}
			if(b >= 0) {
				if(board.get(b).get(i) == 1) {
					return false;
				}
			}
		}
		
		//diagonal <--
		a = x;
		b = x;
		for(int i = y-1;i >= 0;i--) {
			a++;
			b--;
			if(a < n) {
				if(board.get(a).get(i) == 1) {
					return false;
				}
			}
			if(b >= 0) {
				if(board.get(b).get(i) == 1) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	private static void place_queen(int x,int y,ArrayList<ArrayList<Integer>> board){
		board.get(x).remove(y);
		board.get(x).add(y,1);
	}
	private static void remove_queen(int x,int y,ArrayList<ArrayList<Integer>> board){
		board.get(x).remove(y);
		board.get(x).add(y,0);
	}
	
	
	private static boolean n_queens(int y,ArrayList<ArrayList<Integer>> board,int n){
		
		if(y == n){
			System.out.println();
			print_board(board);
			return true;
		}
		
		
		
		for(int i = 0;i < n;i++){
			
			if(valid_spot(i,y,board,n)){
				
				place_queen(i,y,board);
				
				n_queens(y+1,board,n);
				
				//after all the recursive calls remove each queen to reset the board 
				remove_queen(i,y,board);
				
			}
			
			
		}
		return false;
	}
	
	
	} 
	
