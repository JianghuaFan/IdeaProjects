package Trie;

import OOD.OverRide;

import java.util.*;

/*
154. Word Search
Hard
Given a 2D board and a word, find if the word exists in the grid.The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
Input: board = [
                           [“ABCE”],
                           [“SFCS”],
                           [“ADEE”]
                       ]
Output: Word = “ABCCED”   return true
            Word = “SEE”      return true
            Word = “ABCB”      return false
 */
public class WordSearchCisco {
    public boolean isWord(char[][] board, String word) {
        // Write your solution here
        //ref https://www.youtube.com/watch?v=NxWefJtJJwk
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++) {
                if(helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int rowNumber, int colNumber, String word, int indexOfWord) {
        if(indexOfWord == word.length()) {
            return true;
        }
        if(rowNumber < 0 || rowNumber >= board.length  || colNumber < 0 ||  colNumber >= board[0].length || word.charAt(indexOfWord) != board[rowNumber][colNumber]) {
            return false;
        }
        char temp = board[rowNumber][colNumber]; // save the current visited cell, so we can revert back to original status
        board[rowNumber][colNumber] = '*'; //to mark the current cell as visited
        //DFS
        boolean found = helper(board, rowNumber, colNumber - 1, word, indexOfWord + 1) || helper(board, rowNumber + 1, colNumber, word, indexOfWord + 1) ||
                helper(board, rowNumber, colNumber + 1, word, indexOfWord + 1) || helper(board, rowNumber - 1, colNumber, word, indexOfWord + 1);
        //吐
        board[rowNumber][colNumber] = temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] grid ={
                {'C','A','T'},
                {'I','D','O'},
                {'N','O','M'}
        };
        String[] word = {"CAT","TOM","ADO","MOM"};

        WordSearchCisco wordSearchCisco = new WordSearchCisco();
        for(String str : word){
            if(wordSearchCisco.isWord(grid,str)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
