# include<stdio.h>

   float knapsack(int n, float weight[], float profit[], float capacity) {
   float x[20], total_profit = 0;
   int i, j, u;
   u = capacity;

   for (i = 0; i < n; i++)
      x[i] = 0.0;

   for (i = 0; i < n; i++) {
      if (weight[i] > u)
         break;
      else {
         x[i] = 1.0;
         total_profit = total_profit + profit[i];
         u = u - weight[i];
      }
   }

   if (i < n)
      x[i] = u / weight[i];

   total_profit = total_profit + (x[i] * profit[i]);

   return total_profit;
}

int main() {
   float weight[20], profit[20], capacity;
   int num, i, j;
   float ratio[20], temp;

   printf("\n Enter the no. of objects:- ");
   scanf("%d", &num);

   printf("\n Enter the weight of each object: \n");
   for (i = 0; i < num; i++) {
      scanf("%f", &weight[i]);
   }

   printf("\n Enter the profit of each object: \n");
   for (i = 0; i < num; i++) {
      scanf("%f", &profit[i]);
   }

   printf("\n Enter the capacity of knapsack:- ");
   scanf("%f", &capacity);

   for (i = 0; i < num; i++) {
      ratio[i] = profit[i] / weight[i];
   }

   for (i = 0; i < num; i++) {
      for (j = i + 1; j < num; j++) {
         if (ratio[i] < ratio[j]) {
            temp = ratio[j];
            ratio[j] = ratio[i];
            ratio[i] = temp;

            temp = weight[j];
            weight[j] = weight[i];
            weight[i] = temp;

            temp = profit[j];
            profit[j] = profit[i];
            profit[i] = temp;
         }
      }
   }

   float answer = knapsack(num, weight, profit, capacity);

   printf("\n Maximum profit: %f", answer);
   return 0;
}