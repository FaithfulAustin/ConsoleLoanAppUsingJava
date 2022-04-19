package  user;

import java.util.Scanner;

public  class UserImp extends  userInterface{
    public UserImp() {

    }

    public void register(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input Your FirstName");
        String inputFNM = scan.next();
        System.out.println("Input Your LastName");
        String inputLNM = scan.next();
        System.out.println("Input Your UserName");
        String inputUserNM = scan.next();
        System.out.println("Input Your Password");
        String inputPassword = scan.next();
        super.register(inputFNM, inputLNM, inputUserNM,inputPassword);
        isRegistered = true;
        login();

    }
     public void login(){

         System.out.println(" ");
         System.out.println("-------LOGIN SECTION-------");
         System.out.println(" ");
         System.out.println("Input Your UserName");
         String loginUserNM = scan.next();
         System.out.println("Input Your Password");
         String loginPassword = scan.next();

         if(loginUserNM.equals(username)){
             if(loginPassword.equals(password)){
                 viewProfile();
             }else{
                 System.out.println("Password not correct");
             }

         }else{
             System.out.println("User does not exist");
         }
     }

     public void  viewProfile(){
        menu menu = new menu();

         System.out.println("Hi..."+ username);
         System.out.println("First Name:" + firstname);
         System.out.println("Last Name :" + lastname);


         System.out.println("----- Do Want To ? ------");
         System.out.println(">>  1: View Loans       <<");
         System.out.println(">>  2: Take Loan         <<");
         System.out.println(">>  3: Exit             <<");

         int input = scan.nextInt();

         switch(input) {
             case 1:
                 viewLoan();
                 break;
             case 2:
                 takeLoan();
                 break;
             case 3:
                 user.menu.showMenu();

         }


     }

     public void viewLoan(){

        double basicPlan = loanAmt*(20/100);
        double sliverPlan = loanAmt*(30/100);
        double eachMonthPay = 0;

        if (loanAmt <= 499999){
            eachMonthPay = (loanAmt+basicPlan)/monthDuration;
            for(int i = 1 ; i <= monthDuration ; i++){
                System.out.println("Month " + i + ": " +"Basic Plan"+" "+ eachMonthPay + "\n");
            }


        }
        else if (loanAmt > 499999){
            eachMonthPay = (loanAmt+sliverPlan)/monthDuration;
            for(int i = 1 ; i <= monthDuration ; i++){
                System.out.println("Month " + i + ": " +"Sliver Plan"+ " "+ eachMonthPay + "\n");
            }

        }

         System.out.println(" ");
         System.out.println("Press '1' to exit");
         int input = scan.nextInt();
         if (input == 1){
             viewProfile();
         }

     }

     public void takeLoan(){


         System.out.println("-----------Choose From The Following Plans--------");
         System.out.println(">>>> 1: BASIC (499,999 and below) with 20% interest  <<<<<");
         System.out.println(">>>> 2: SLIVER (500,000 and above) with 30% interest <<<<<");

         int inputTypeOfPlan = scan.nextInt();

         if (inputTypeOfPlan== 1){
                 System.out.println(" ");
                 System.out.println("------BASIC PLAN-----");
                 System.out.println(" ");
                 System.out.println("Input Loan Amount");
                 loanAmt = scan.nextDouble();
                 if(loanAmt > 499999){
                     System.err.println("Pls Input amount from 499999 and above ...or try D sliver plan");
                     System.out.println(" ");
                     viewProfile();

                 }
                 else{

                     System.out.println("Input Month of Duration");
                     monthDuration = scan.nextInt();
                     if(monthDuration>12){
                         System.err.println("A month pls ");
                         System.out.println(" ");
                         viewProfile();
                     }else {
                         viewLoan();
                     }
                 }



         }
         else if(inputTypeOfPlan==2){
             System.out.println(" ");
             System.out.println("------SLIVER PLAN-----");
             System.out.println(" ");
             System.out.println("Input Loan Amount");
             loanAmt = scan.nextDouble();
             if(loanAmt <= 499999){
                 System.err.println("Pls input numbers from 500,000 and above");

             }
             else{

                 System.out.println("Input Month of Duration");
                 monthDuration = scan.nextInt();
                 if(monthDuration>12){
                     System.out.println("Month pls");
                 }
                 else{
                     viewLoan();
                 }
             }
         }
     }
}