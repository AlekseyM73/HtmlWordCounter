
public class Main {

    public static void main(String[] args) {
        if (args.length == 0 ){
            System.out.println("URL not found");
            System.exit(1);
        } else new Manager(args[0]).start();
    }
}
