public class BoilerPlateClass{
    private String name;
    private int age;
    
    private BoilerPlateClass(String name, int age){
        this.name = name;
        this.age = age;
    }
    public static void main(String[] args){
        BoilerPlateClass bpc = new BoilerPlateClass("Robert", 21);
        System.out.println(bpc.name);
    }
}
