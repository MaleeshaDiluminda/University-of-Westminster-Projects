# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

count_pg = 0 #pg = progress
count_pt = 0 #pt = progress module trailer
count_pr = 0 #pr = do not progress - module retriever
count_ex = 0 #ex = exclude
import sys 
x=input("Enter 'q' to quit the program or Enter any key to continue the program:")
while x!="q":

    try:
          P = int(input("Enter pass credits:")) 
          if P not in [0, 20, 40, 60, 80, 100, 120]:  #P = Pass credits
             print("Range Error")                    
             sys.exit()                             

          D = int(input("Enter defer credits:")) 
          if D not in [0, 20, 40, 60, 80, 100, 120]:  #D = Defer credits
             print("Range Error")
             sys.exit()

          F = int(input("Enter fail credits:")) 
          if P not in [0, 20, 40, 60, 80, 100, 120]:  #F = Fail credits
             print("Range Error")
             sys.exit()

          if P + D + F == 120:

             if (P==120 and D==0 and F==0):
                print('Progress')
                count_pg = count_pg + 1

             elif (P==100 and F==0) or (P==100 and F==20):
                print('Progress - module trailer')
                count_pt = count_pt + 1

             elif (D==0 and F==80 or F==100 or F==120) or (D==20 and F==80 or F==100) or (D==40 and F==80):
                print('Exclude')
                count_ex = count_ex + 1

             else:
                print('Do not progress - module retriever')
                count_pr = count_pr + 1

          elif P + D + F != 120:        
             print("Total incorrect.")


    except ValueError:
             print('Intergers Required')
    x=input("Enter 'q' to quit the program or Enter any key to continue the program:")


star_pg = " * " *count_pg      #pg = progress
star_pt = " * " *count_pt      #pt = progress module trailer
star_pr = " * " *count_pr      #pr = Do not progress - module trailer
star_ex = " * " *count_ex      #ex = exclude
total_outcome = count_pg + count_pt + count_ex + count_pr

print('Progress ',count_pg,':',star_pg)
print('Progress - module trailer ',count_pt,':',star_pt)
print('Do not progress - module retriever ',count_pr,':',star_pr)
print('Exclude ',count_ex,':',star_ex)

print(total_outcome, 'outcomes in total')



