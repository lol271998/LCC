public class Calculadora {
  public static void main(String args[]){
    int n=10;
    num(n);
  }
  public static void linhas(char num){
  /*led[0][0] = '#';// linha 0 (1 . . .)
    led[0][1] = '#';// linha 0 (. 1 . .)
    led[0][2] = '#';// linha 0 (. . 1 .)
    led[0][3] = '#';// linha 0 (. . . 1)
    led[1][0] = '#';// linha 1 (1 . . .)
    led[1][1] = '#';// linha 1 (. 1 . .)
    led[1][2] = '#';// linha 1 (. . 1 .)
    led[1][3] = '#';// linha 1 (. . . 1)
    led[2][0] = '#';// linha 2 (1 . . .)
    led[2][1] = '#';// linha 2 (. 1 . .)
    led[2][2] = '#';// linha 2 (. . 1 .)
    led[2][3] = '#';// linha 2 (. . . 1)
    led[3][0] = '#';// linha 3 (1 . . .)
    led[3][1] = '#';// linha 3 (. 1 . .)
    led[3][2] = '#';// linha 3 (. . 1 .)
    led[3][3] = '#';// linha 3 (. . . 1)
    led[4][0] = '#';// linha 4 (1 . . .)
    led[4][1] = '#';// linha 4 (. 1 . .)
    led[4][2] = '#';// linha 4 (. . 1 .)
    led[4][3] = '#';// linha 4 (. . . 1)
    led[5][0] = '#';// linha 5 (1 . . .)
    led[5][1] = '#';// linha 5 (. 1 . .)
    led[5][2] = '#';// linha 5 (. . 1 .)
    led[5][3] = '#';// linha 5 (. . . 1)
    led[6][0] = '#';// linha 6 (1 . . .)
    led[6][1] = '#';// linha 6 (. 1 . .)
    led[6][2] = '#';// linha 6 (. . 1 .)
    led[6][3] = '#';// linha 6 (. . . 1)*/
  }
  public static void num(int n){
    char [][] esp = new char[7][1];
    char [][] led = new char[7][4];
    char [] num = String.valueOf(n).toCharArray();
    int size = num.length;
    for(int espl=0;espl<7;espl++){
        for(int espac=0;espac<1;espac++){
            esp[espl][espac]=' ';       
        }    
    }
    for(int i=0;i<size;i++){
        for(int a=0;a<7;a++){
            for(int b=0;b<4;b++){
                led[a][b] = '.';
            }
        }       
        switch(num[i]){
            case '0' : 
                led[0][1] = '#';// linha 0 (. 1 . .)
                led[0][2] = '#';// linha 0 (. . 1 .)
                led[1][0] = '#';// linha 1 (1 . . .)
                led[1][3] = '#';// linha 1 (. . 1 .)
                led[2][0] = '#';// linha 2 (1 . . .)
                led[2][3] = '#';// linha 2 (. . . 1)
                led[3][0] = '#';// linha 3 (1 . . .)
                led[3][3] = '#';// linha 3 (. . . 1)
                led[4][0] = '#';// linha 4 (1 . . .)
                led[4][3] = '#';// linha 4 (. . . 1)
                led[5][0] = '#';// linha 5 (1 . . .)
                led[5][3] = '#';// linha 5 (. . . 1)
                led[6][1] = '#';// linha 6 (. 1 . .)
                led[6][2] = '#';// linha 6 (. . 1 .)             
                break;
            case '1' :
                led[1][3] = '#';// linha 1 (. . . 1)
                led[2][3] = '#';// linha 2 (. . . 1)
                led[4][3] = '#';// linha 4 (. . . 1)
                led[5][3] = '#';// linha 5 (. . . 1)
                break;
            }
            for(int a=0;a<7;a++){
                if(a<6){
                    for(int b=0;b<4;b++){
                        if(b<3) System.out.print(led[a][b]);
                        else System.out.println(led[a][b]);
                    }
                }
                else{
                    for(int b=0;b<4;b++){
                        System.out.print(led[a][b]);
                    }                    
                }
            }
            /*for(int espl=0;espl<7;espl++){
                for(int espac=0;espac<1;espac++){
                    System.out.print(esp[espl][espac]);       
                }    
            }*/                                      
        }        
    }
}
/*
Linha 0{              
    led[0][1] = '#';// linha 0 (. 1 . .)
    led[0][2] = '#';// linha 0 (. . 1 .)
}
Linha 1{
    
}*/