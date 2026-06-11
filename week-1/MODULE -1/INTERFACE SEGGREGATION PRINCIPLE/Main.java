
class Main {
    public static void main(String[] args) {
        TwoDShape sq = new Square();
        sq.area();
        
        Cube cube = new Cube();
        cube.volume();
        
    }
}

interface TwoDShape{
    void area();
}

interface ThreeDShape{
    void volume();
}

class Square implements TwoDShape{
    public void area(){
     System.out.println("Prints area of square");
    }
}


class Cube implements ThreeDShape{
    public void volume(){
     System.out.println("Prints volume of cube");
    }
    
}
