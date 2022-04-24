#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

int *account,*ch,*cash,count;	 
char *opt;
	
struct user
{
	char *name[50];
	char *pass[50];
}user;

void deposite()
{	
	char *opt;
	
	opt = malloc(sizeof(char));
			
	while(1)
	{
		printf("\n Enter Amount to Deposite :");
		scanf("%d",cash);
		
		if(*cash<100)
		{
			printf("\n Please Enter Amount greater than 99Rs.");
		}
		else if((*cash=='A' && *cash=='Z')||(*cash=='a' && *cash=='z'))
		{
			printf("\n Invalid!,Please Enter Numrical Data!");
		}
		else
		{
			*account+=*cash;
			printf("\n Cash has Deposite Sucessfully!");
			again:
			printf("\n Do you want Deposite More Money(Y/N):");
			scanf("%s",opt);
			if(*opt == 'y' || *opt == 'Y')
			{
				continue;
			}
			else if(*opt == 'N' || *opt == 'n')
			{
				system("cls");
				break;
			}
			else
			{
				printf("Wrong Input!");
				goto again;
			}		
		}
	}
}

void withdraw()
{
	while(1)
	{
		printf("\n Enter Amount in x100 :");
		scanf("%d",cash);
		
		if(*cash<100)
		{
			printf("\n Please Enter Amount greater than 99Rs.");
		}
		else if((*cash=='A' && *cash=='Z')||(*cash=='a' && *cash=='z'))
		{
			printf("\n Invalid!,Please Enter Numrical Data!");
		}
		else if(*cash>*account)
		{
			printf("\n Insufficient Balance!");
			break;
		}
		else
		{
			*account -= *cash;
			printf("\n Cash has Withdrawed Sucessfully!");
			repeat:
			printf("\n Do you want Withdraw More Money(Y/N):");
			scanf("%s",opt);
			if(*opt == 'y' || *opt == 'Y')
			{
				continue;
			}
			else if(*opt == 'N' || *opt == 'n')
			{
				system("cls");
				break;
			}
			else
			{
				printf("\nWrong Input!");
				goto repeat;
			}
		}	
	}	
}

void mainmenu()
{
	do
	{
		printf("\n**** Please Select your Service ****");
		printf("\n 1.Deposite Cash");
		printf("\n 2.Withdraw Cash");
		printf("\n 3.Balance inqurie");
		printf("\n 4.Exit");
		printf("\n");
		scanf("%d",ch);
		switch(*ch)
		{
			case 1: 
					deposite();
					break;
			case 2:
					withdraw();
					break;
			case 3:
					printf("\nCurrent Balance : %d\n",*account);
					break;
			case 4:
					printf("\nThank You For Visiting Us........");
		}		
	}while(*ch!=4);
}

void registration()
{
	printf("Enter Your Name : ");
	scanf("%s",user.name[count]);
	printf("Enter Your Password : ");
	scanf("%s",user.name[count]);
	count++;
}

int check(char * passw)
{
	int i;
	
	for(i=0;i<count;i++)
	{
		if(strlen(passw) == strlen(user.pass[i]))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
}

void end()
{
	free(account);
	free(ch);
	free(cash);
	free(opt);
	exit(1);
}

void password()
{
	char *password;	
	password = malloc(50*sizeof(char));

	while(1)
	{
		printf("Do you Registred(Y/N):");
		scanf("%s",opt);
		if(*opt == 'y' || *opt == 'Y')
		{
			system("cls");
			break;
		}
		else if(*opt == 'N' || *opt == 'n')
		{
			system("cls");
			registration();
			break;
		}
		else
		{
			printf("\nWrong Input!");
			continue;
		}
	}
	
	while(1)
	{	
		printf("\n Enter Your Password(Hint:- Your Name):");
		scanf("%s",password);
		
		if(strlen(password) == strlen("admin"))
		{
			printf("\n\n Login Successful!");
			printf("\n\n\n\n\n Loading..............");
			sleep(1);
			system("cls");
			mainmenu();
			end();
		}
		else if(check(password))
		{
			printf("\n\n Login Successful!");
			printf("\n\n\n\n\n Loading..............");
			sleep(1);
			system("cls");
			mainmenu();
			end();
		}
		else
		{
			printf("\n\n\n\n\n Incorrect Password!");
			sleep(1);
			system("cls");
		}
	}
}

void main()
{	
	int i;
	account = malloc(sizeof(int));
	ch = malloc(sizeof(int));
	cash = malloc(sizeof(int));
	opt = malloc(sizeof(char));

	for(i=0;i<50;i++)
	{
		user.name[i] = malloc(50*sizeof(char));
		user.pass[i] = malloc(50*sizeof(char));
	}
	
	*account=*cash=0;
	password();
}
