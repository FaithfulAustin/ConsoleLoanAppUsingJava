package user;

import java.util.Scanner;

public class menu {



    public static void showMenu(){

        UserImp userActions = new UserImp();
        Scanner scan = new Scanner(System.in);

        System.out.println("----- Pls Choose From The Options Below ------");
        System.out.println(">>  1: Register       <<");
        System.out.println(">>  2: Login          <<");
        System.out.println(">>  3: Exit           <<");

        int input = scan.nextInt();

        switch(input) {
            case 1:
                System.out.println("");
                if(userActions.isRegistered){
                    System.out.println("----- Yello!! you already have an account with us ------");
                    showMenu();
                }else{
                    userActions.register();
                }
                break;
            case 2:
                userActions.login();
                break;
            case 3:
                System.exit(0);

    }
}
}
