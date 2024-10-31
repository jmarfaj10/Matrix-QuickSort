
package matrixquicksort;

public class Location {
    int x;
    int y;
    
    public Location(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public Location(){
        this.x=0;
        this.y=0;
    }
    
    public Location(Location i){
        this.x=i.x;
        this.y=i.y;
    }
    
    public void incr(int nfil,int ncol){
        if(this.y<ncol-1){
           this.y=this.y+1; 
        }else{
            this.y=0;
            this.x++;
        }
        
    }
    
    public void decr(int nfil, int ncol){
        if(y==0){
            y=ncol-1;
            x--;
        }else{
            y--;
        }
    }
    
    public void iniY(){
        y=0;
    }
    
    public boolean equals(Location l){
        boolean fact=false;
        if(this.x==l.x){
            if(this.y==l.y){
                fact=true;
            }
        }
        return fact;
    }
    
    public boolean compareLocations(Location l){
        if(this.x>l.x){
            return true;
        }else if(this.x==l.x){
            if(this.y==l.y){
                return true;
            }else{
                if(this.y>l.y){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
}
