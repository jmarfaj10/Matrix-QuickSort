
package matrixquicksort;
import java.util.*;
public class MatrixQuickSort {

    public static void main(String[] args) {
        int[][] matrix={{45,89,23,44},{15,2,78,20},{33,56,131,243},{10,79,25,83}};
        quickSortMatrix(matrix, new Location(), new Location(matrix.length-1,matrix[0].length-1));
        pintarMatrix(matrix);
    }
    
    public static void quickSortMatrix(int[][] matrix, Location min, Location max){
        boolean cmp=max.compareLocations(min);
        if(cmp==true){
                Location q=new Location(dividir(matrix,min,max));
                Location nuevomax= new Location(q);
                nuevomax.decr(matrix.length, matrix[0].length);
                Location nuevomin= new Location(q);
                nuevomin.incr(matrix.length, matrix[0].length);
                quickSortMatrix(matrix,min,nuevomax);
                quickSortMatrix(matrix,nuevomin,max);
            }
        }
    
    public static Location dividir(int[][] matrix,Location min, Location max){
        int nfil=matrix.length;
        int ncol=matrix[0].length;
        Location rastro=new Location(min);
        rastro.decr(nfil, ncol);
        Location pivote=new Location(max);
        boolean enc=false;
        Location auxLoc=new Location(min);
        while(!enc){
                if(matrix[auxLoc.x][auxLoc.y]<=matrix[pivote.x][pivote.y]){
                    rastro.incr(nfil,ncol);
                    int aux=matrix[auxLoc.x][auxLoc.y];
                    matrix[auxLoc.x][auxLoc.y]=matrix[rastro.x][rastro.y];
                    matrix[rastro.x][rastro.y]=aux;
                    enc=max.equals(auxLoc);
                }
                auxLoc.incr(nfil, ncol);
        }
        return rastro;
    }
    
    public static void pintarMatrix(int[][]matrix){
        
        for(int i=0;i<matrix.length;i++){
            System.out.print("{");
            for(int j=0;j<matrix[0].length;j++){
                if(j!=matrix[0].length-1){
                System.out.print(matrix[i][j]+",");
                }else{
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.print("}\n");
        }
    }
}
