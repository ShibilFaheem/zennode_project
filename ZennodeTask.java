import java.util.Scanner;

public class ZennodeTask {
    public static void main(String[]as){
        System.out.println("!!WELCOME!!");
        Scanner sc=new Scanner(System.in);
        System.out.println("Price List:\nThe Product A: $20.00\nThe Product B: $40.00\nThe Product C: $50.00"+
                           "\nEnter the no. of units of PRODUCT A you wish to buy:");
        int qtyA=sc.nextInt();
        System.out.println("Enter the no. of units of PRODUCT B you wish to buy:");
        int qtyB=sc.nextInt();
        System.out.println("Enter the no. of units of PRODUCT C you wish to buy:");
        int qtyC=sc.nextInt();

        System.out.println("Would you like to gift wrap your order to make it special?"+ //wrapping request
                           "Please enter the no. of units to be gift wrapped:");
        int WrapCharge=sc.nextInt();   //Wrapping charge

        int qty = qtyA + qtyB + qtyC; //total units ordered
        int priceA = 20 * qtyA;  //product A - 20$ each 
        int priceB = 40 * qtyB;
        int priceC = 50 * qtyC;
        int realTotal= priceA + priceB + priceC; //actual total price

        float discountFlat10 = 0; 
        double discountBulk5 = 0;
        double discountBulk10 = 0;
        float discountTiered50 = 0;

        if(realTotal > 200){         // First discount rule
            discountFlat10 = realTotal-10;
        }
        
        float discountBulk5PriceA = 0; 
        float discountBulk5PriceB = 0;
        double discountBulk5PriceC = 0;
        if(qtyA>10){
            discountBulk5PriceA = 19*qtyA; //price for Product A each after 5% discount, $20 becomes $19
        }
        if(qtyB>10){
            discountBulk5PriceB = 38*qtyB; //price for ProductB each after 5% discount, $40 becomes $38
        }
        if(qtyC>10){
            discountBulk5PriceC = 47.5*qtyC; //price for ProductB each after 5% discount, $50 becomes $47.5
        }
        discountBulk5 = discountBulk5PriceA+discountBulk5PriceB+discountBulk5PriceC;  //second discount rule

        if(qty>20){
            discountBulk10 = realTotal-(realTotal*.1);  //Third discount rule
        }

        float discountTiered50PriceA=0;
        float discountTiered50PriceB=0;
        float discountTiered50PriceC=0;
        if(qty>30){
            if(qtyA>15){
                int discountTiered50Diff=qtyA-15;
                discountTiered50PriceA=(20*15)+(10*discountTiered50Diff);
            }else{
                discountTiered50PriceA = 20 * qtyA;
            }
            if(qtyB>15){
                int discountTiered50Diff=qtyB-15;
                discountTiered50PriceB=(40*15)+(20*discountTiered50Diff);
            }else{
                discountTiered50PriceB = 40 * qtyB;
            }
            if(qtyC>15){
                int discountTiered50Diff=qtyC-15;
                discountTiered50PriceC=(50*15)+(25*discountTiered50Diff);
            }else{
                discountTiered50PriceC = 20 * qtyC;
            }
            discountTiered50 = discountTiered50PriceA+discountTiered50PriceB+discountTiered50PriceC;  //fourth discount rule
        }

        double[] finalDiscountedPrices ={discountFlat10, discountBulk5, discountBulk10, discountTiered50}; //FInds the best discounted price
        double bestDiscount = realTotal;
        int indexDiscountApplied=4;
        String[] discountApplied = {"flat_10_discount", "bulk_5_discount", "bulk_10_discount", "tiered_50_discount","No Discount"};
        for(int i=0;i<4;i++){
            if(finalDiscountedPrices[i]<bestDiscount && finalDiscountedPrices[i] != 0){
                bestDiscount= finalDiscountedPrices[i];
                indexDiscountApplied=i;
            }
        }

        int noOfDeliveryPackages=0;
        if(qty%10==0){
            noOfDeliveryPackages = qty/10;
        }else{
            noOfDeliveryPackages= (qty/10)+1;
        }
        int DeliveryCharge=noOfDeliveryPackages*5;  //delivery charges
        sc.close();

        System.out.println("\nThe total units ordered is "+qty+" no.s"+
                            "\nProduct A: "+qtyA+" units - Amount: $"+priceA+
                            "\nProduct B: "+qtyB+" units - Amount: $"+priceB+
                            "\nProduct C: "+qtyC+" units - Amount: $"+priceC+
                            "\nSubtotal of the cart is "+realTotal+
                            "\nThe BEST dicount applicable is "+discountApplied[indexDiscountApplied]+
                            "\nSubtotal after discount: $"+bestDiscount+
                            "\nWraping fees: $"+WrapCharge+
                            "\nShipping fees: $"+DeliveryCharge+
                            "\nThe TOTAL AMOUNT payable is $"+(bestDiscount + WrapCharge + DeliveryCharge)+
                            "\nThank You for shopping with us.");
    }
}
