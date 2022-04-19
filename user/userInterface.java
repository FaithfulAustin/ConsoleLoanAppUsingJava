package user;


import java.util.Scanner;

public  abstract  class userInterface{
    Scanner scan = new Scanner(System.in);

    String firstname="";
    String lastname="";
    String username = "";
    String  password="";
    double loanAmt = 0;
    int monthDuration = 0;
    int balance =0;
    boolean isRegistered = false;

    public userInterface() {

    }

    public void register(String firstname, String lastname, String username,String password){

        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;



    }
    public  void login(String username,String password){

        this.username = username;
        this.password = password;

    }

}