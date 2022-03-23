import java.util.Scanner;

public class ShapeMaker {
    //Sets the "LU" that will be used as default if user does not enter custom String.
    static String luLabel = "LU";
    
//Draws square, takes an int for size of square, string for word, and int for what row to place the word on.
            static void squareShape(int size, String label, int labelRow){
            //converts String to character array to be used for printing.
             char[] labelArr = label.toCharArray();
            //Verifies that user is not entering a negative number.
            if (size >= 0){
            for(int i = 0;i < size;i++){
                /*tells program to place word on selected labelRow
                The -1 is to offset the Array index so the program is in human terms. 
                Example: Entering 10 should put the word on the last row. Without the offset, user would have to enter number 9 for last row.*/
                if(i == labelRow -1){
                    //prints entire word even if wider than the shape.
                    if (labelArr.length >= size){
                        for (int j = 0; j < labelArr.length ;j++){
                        System.out.print(labelArr[j] + " ");}
                    }
                    if (labelArr.length < size){
                        //Adds an extra X if there's an odd numbered word on an even width row.
                        if (labelArr.length % 2 == 1 && size % 2 != 1){
                            System.out.print("X ");
                        }
                    //Prints Xs before word.
                    int difference = (size - labelArr.length)/2;
                    for (int y = 0; y < difference; y++){
                        System.out.print("X ");
                    }
                    for (int j = 0; j < labelArr.length ;j++)
                    //Prints word
                    System.out.print(labelArr[j] + " ");
                    //Prints Xs after word
                     for (int y = 0; y < difference; y++){
                        System.out.print("X ");
                    }
                    }
                    
                }
             //Prints Xs on rows without label
                else{
            for(int j = 0;j < size; j++){
                System.out.print("X ");
            }}
            System.out.println();
            }
            }
            else{
            System.out.println("Please enter a positive whole number when selecting shape size.");
            }
            }
//End Draws square
            

//Draws Triangle
              static void triangleShape(int n, String label, int rowLabel){
        char[] labelArr = label.toCharArray();
        for (int i = 1;i<=n;i++ ){
            //Prints word on triangle.
            if(i == rowLabel){
                int difference = rowLabel - labelArr.length;
                for(int j=i;j<=n;j++){
            System.out.print(" ");}
               //Adds an X if even. Necessary or row is thrown off.
                if (rowLabel % 2 == 0 && labelArr.length%2!=0){
                    System.out.print("X ");
                }
                if (rowLabel % 2 != 0 && labelArr.length%2==0){
                    System.out.print("X ");
                }
                for (int j=0;j<difference/2;j++){
                        System.out.print("X ");
                }
                
                    for(int b = 0;b<labelArr.length;b++){
                        System.out.print(labelArr[b]+" ");
                    }    
                     for (int j=0;j<difference/2;j++){
                        System.out.print("X ");
                }
        //The following two lines must be used or else there is a repeat-sized line under the word.
         
           i++;
           System.out.println();
                
            }
            //Ends print word on triangle
            
            for(int j=i;j<=n;j++){
            System.out.print(" ");}
            
            for(int j=1;j<=i;j++){
                System.out.print("X ");
            }
            
        System.out.println();
        }
    }
//End Draws Triangle
//Draws Downward Triangle
              static void bottomTriangleShape(int n, String label, int rowLabel){
        char[] labelArr = label.toCharArray();
        for (int i = 1;i<=n;i++ ){
            //Prints word on downward triangle.
            if(i == rowLabel && labelArr.length>0){ //adding the condition for the array length to be greater than zero allows us to default to the "LU" Label
                for(int j=1;j<=i;j++){
            System.out.print(" ");
                    
                }
                int reverseRowLabel = rowLabel;
                int difference =   ((n-rowLabel) - labelArr.length)+1 ;
           
               //Adds an X in certain conditions. Necessary or row is thrown off by 1.
                if (n % 2 == 0 && rowLabel % 2 == 0 && labelArr.length%2==0 || 
                    n % 2 == 0 && rowLabel % 2 != 0 && labelArr.length%2!=0 || 
                    n % 2 != 0 && rowLabel % 2 != 0 && labelArr.length%2==0 || 
                    n % 2 != 0 && rowLabel % 2 == 0 && labelArr.length%2!=0){
                    System.out.print("X ");
                }
                // if (rowLabel % 2 == 0 && labelArr.length%2!=0 ){
                //     System.out.print("X ");
                // }
                for (int j=1;j<=difference/2;j++){
                        System.out.print("X ");
                }
                
                    for(int b = 0;b<labelArr.length;b++){
                        System.out.print(labelArr[b] + " ");
                    }    
                     for (int j=1;j<=difference/2;j++){
                        System.out.print("X ");
                }
        //The following two lines must be used or else there is a repeat-sized line under the word.
         
           i++;
           System.out.println();
                
            }
            //Ends print word on triangle
            
            for(int j=1;j<=i;j++){
            System.out.print(" ");}
            
            for(int j=i;j<=n;j++){
                System.out.print("X ");
            }
            
        System.out.println();
        }
    }
//End Draws Downward Triangle
//Draws Diamond from two triangles
            static void diamondShape(int n, String label,int rowLabel){
              //if-else statement decides which half of the diamond to put the label on.
               if (rowLabel <= n/2){
                triangleShape(n/2, label, rowLabel);
               
                bottomTriangleShape(n/2,"",rowLabel);
            }
                else{
                    triangleShape(n/2,"",rowLabel);
                    bottomTriangleShape(n/2,label,rowLabel-(n/2));
                }
            }
//End Draws Diamond
//Start questionnaire
            
            static void questions() {
            	Scanner userInput = new Scanner(System.in);
                System.out.println("Please enter the shape you would like to draw (1 for square, 2 for triangle, 3 for diamond):");
               
                if(!userInput.hasNextInt()) {
                	System.out.println("Please enter a 1, 2, or 3.");
                	System.out.println();
                	questions();
                }
                int userShape = userInput.nextInt();
                if (userShape > 3 || userShape <1){
                    System.out.println("Please enter a 1, 2, or 3.");
                    questions();
                }
                
                System.out.println("How big would you like this shape to be? (use a whole number, please)");
                if (!userInput.hasNextInt()) {
                	System.out.println("***Please enter a positive whole number next time.***");
                	System.out.println();
                	questions();
                }
                int userSize = userInput.nextInt();
                
                System.out.println("Would you like to print a custom word on the shape? (y or n)");
                String userDecision = userInput.next();
                String userLabel = luLabel;
                if (userDecision.equals("y") || userDecision.equals("yes")) {
                	System.out.println("Enter a word you would like printed on the shape: ");                 	
                	userLabel = userInput.next();
                }
                System.out.println("What row would you like the word placed on? (use a whole number, please)");
                System.out.println("--Row will default to 4 unless specified by number.--");
                int userRow = 4;
               //my less messy way of defaulting to row 4
                if (!userInput.hasNextInt()) {   	
                	System.out.println();
                	userRow = 4;
                }
               
                //end less messy method
                else {userRow = userInput.nextInt(); 
                System.out.println();}
               
                if (userShape == 1){
                    squareShape(userSize,userLabel,userRow);
                }
                else if (userShape == 2){
                    triangleShape(userSize,userLabel,userRow);
                }
                else if (userShape == 3){
                    diamondShape(userSize,userLabel,userRow);
                }
                System.out.println();
                System.out.println("Would you like to print another shape? (y or n)");
                
                if(userInput.next().equals("y") || userInput.next().equals("yes")) {
                	questions();
                }
                else {
                	System.exit(0);
                }
               
                }
          
   //end.         
            
    public static void main(String args[]) {
    questions();

    
  
    }
  }
    /*TO DO:DONE -Figure out how to print word on triangle properly surrounded by spaces and Xs
            DONE -Apply similar logic to diamond.
            DONE-Figure out how to take user input*/