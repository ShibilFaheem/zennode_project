import java.util.Scanner;

public class ZennodeTask {
    public static void main(String[]as){
        System.out.println("!!WELCOME!!\nHAPPY SHOPPING!!");
        Scanner sc=new Scanner(System.in);
        System.out.println("Price List:\nThe Product A: $20.00\nThe Product B: $40.00\nThe Product C: $50.00");
        System.out.println("\nEnter the no. of units of PRODUCT A you wish to buy:");
        int QtyA=sc.nextInt();
        System.out.println("Enter the no. of units of PRODUCT B you wish to buy:");
        int QtyB=sc.nextInt();
        System.out.println("Enter the no. of units of PRODUCT C you wish to buy:");
        int QtyC=sc.nextInt();

        int Qty = QtyA + QtyB + QtyC; //total units ordered
        int PriceA = 20 * QtyA;  //product A - 20$ each 
        int PriceB = 40 * QtyB;
        int PriceC = 50 * QtyC;
        int RealTotal= PriceA + PriceB + PriceC; //actual total price

        float D_flat10=0; 
        double D_bulk5=0;
        double D_bulk10=0;
        float D_tiered50=0;

        if(RealTotal > 200){         // First discount rule
            D_flat10 = RealTotal-10;
        }
        
        float D_PriceA=0;
        float D_PriceB=0;
        double D_PriceC=0;
        if(QtyA>10){
            D_PriceA= 19*QtyA; //price for Product A each after 5% discount, $20 becomes $19
        }
        if(QtyB>10){
            D_PriceB= 38*QtyB; //price for ProductB each after 5% discount, $40 becomes $38
        }
        if(QtyC>10){
            D_PriceC= 47.5*QtyC; //price for ProductB each after 5% discount, $50 becomes $47.5
        }
        D_bulk5 = D_PriceA+D_PriceB+D_PriceC;  //second discount rule

        if(Qty>20){
            D_bulk10 = RealTotal-(RealTotal*.1);  //Third discount rule
        }

        float D_PriceA2=0;
        float D_PriceB2=0;
        float D_PriceC2=0;
        if(Qty>30){
            if(QtyA>15){
                int diff=QtyA-15;
                D_PriceA2=(20*15)+(10*diff);
            }
            if(QtyB>15){
                int diff=QtyB-15;
                D_PriceB2=(40*15)+(20*diff);
            }
            if(QtyC>15){
                int diff=QtyC-15;
                D_PriceC2=(50*15)+(25*diff);
            }
            D_tiered50 = D_PriceA2+D_PriceB2+D_PriceC2;  //fourth discount rule
        }

        double[] finalprices ={D_flat10, D_bulk5, D_bulk10, D_tiered50}; //FInds the best discounted price
        double BestDiscount = RealTotal;
        for(int i=0;i<4;i++){
            if(finalprices[i]<BestDiscount && finalprices[i]!=0){
                BestDiscount= finalprices[i];
            }
        }

        System.out.println("Would you like to gift wrap your order to make it special?");
        System.out.println("Please enter the no. of units to be gift wrapped:");
        int WrapCharge=sc.nextInt();   //Wrapping charge

        int DeliveryPackage=0;
        if(Qty%10==0){
            DeliveryPackage = Qty/10;
        }else{
            DeliveryPackage= (Qty/10)+1;
        }
        int DeliveryCharge=DeliveryPackage*5;  //delivery charges
        sc.close();
        System.out.println("\n");

        System.out.println("The total units ordered is             "+Qty+" no.s");
        System.out.println("The total MRP of the cart is           $"+RealTotal);
        System.out.println("The BEST Total Price after dicount is  $"+BestDiscount);
        System.out.println("The charges applicable for wrapping is $"+WrapCharge);
        System.out.println("The shipping charge is                 $"+DeliveryCharge);
        System.out.println("The TOTAL AMOUNT payable is            $"+(BestDiscount + WrapCharge + DeliveryCharge));
        System.out.println("\nThank You for shopping with us.");
    }
}
