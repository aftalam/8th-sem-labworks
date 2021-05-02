//program to implement all major functions of string.h

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int ch;
    char s1[50], s2[50], c;
    do
    {
        printf("\n Program to implement all major functions of string.h");
        printf("\n 1. strlen\n 2. strcat\n 3. strcpy\n 4. strcmp\n 5. strrev");
        printf("\n Enter your choice : ");
        scanf("%d", &ch);
        fflush(stdin);
        switch (ch)
        {
        case 1:
            printf(" Enter a string : ");
            gets(s1);
            printf(" Length of string '%s' is %d", s1, strlen(s1));
            break;
        case 2:
            printf(" Enter first string : ");
            gets(s1);
            printf(" Enter second string : ");
            gets(s2);
            printf(" After concatenation, Result = %s", strcat(s1, s2));
            break;
        case 3:
            printf(" Enter first string : ");
            gets(s1);
            printf(" Enter second string : ");
            gets(s2);
            printf(" After copying second string into first :");
            strcpy(s1, s2);
            printf("\n First string  = %s", s1);
            printf("\n Second string  = %s", s2);
            break;
        case 4:
            printf(" Enter first string : ");
            gets(s1);
            printf(" Enter second string : ");
            gets(s2);
            if (strcmp(s1, s2) == 0)
                printf(" Strings are equal!");
            else
                printf(" Strings are not equal!");
            break;
        case 5:
            printf(" Enter a string : ");
            gets(s1);
            char s3[50];
            strcpy(s3, s1);
            printf(" Reverse of string '%s' is %s", s3, strrev(s1));
            break;
        default:
            printf(" Wrong choice!");
            break;
        }
        printf("\n\n Do you want to continue ? (y/n) : ");
        scanf("%c", &c);
    } while ((c == 'y') || (c == 'Y'));
    return 0;
}