import pandas as pd
import openpyxl
import os


def Add_contact(existing_df):
    name=[(input("Enter the Name: "))]
    Phone_number=[(input("Enter the number: "))]
    email=[(input("Enter the Email: "))]
    address=[(input("Enter the address: "))]
    data={
        'Name': name,
        'Phone Number': Phone_number,
        'Email': email,
        'Address': address
        }
    new_df = pd.DataFrame(data)
    combined_df = pd.concat([existing_df, new_df], ignore_index=True)
    combined_df.to_excel('Contact Information.xlsx', index=False)
    print("\tNew contact Add successfully\n")
    return combined_df


def isNumber(s):
    for char in s:
        if not char.isdigit():
            return False
    return True

def Search_contact(df):
    search_value=input("Enter the number or name for search: ")
    if isNumber(search_value):
        search_result=df[df['Phone Number']==search_value]
    
    else:
        search_result=df[df['Name']==search_value]

    print(search_result,"\n")


def Update_contact(df):
    name=input("Update contact information by Name: ")

    phone_number=input("new Phone number: ")
    if phone_number!="":
        df.loc[df['Name'] == name, 'Phone Number']=phone_number
    
    email=input("new Email: ")
    if email!="":
        df.loc[df['Name'] == name, 'Email']=email
    
    address=input("new Address: ")
    if address!="":
        df.loc[df['Name'] == name, 'Address']=address

    df.to_excel('Contact Information.xlsx', index=False)
    return df
        

def Delete_contact(df):
    delete_value=input("Enter the number or name for Delete: ")
    if isNumber(delete_value):
        new_df=df[df['Phone Number']!=delete_value]
    
    else:
        new_df=df[df['Name']!=delete_value]

    new_df.to_excel('Contact Information.xlsx', index=False)
    return new_df

if __name__=="__main__":
    if os.path.exists("Contact Information.xlsx"):
        existing_df = pd.read_excel('Contact Information.xlsx')
    
    else:
        data={
        'Name':[],
        'Phone Number': [],
        'Email':[],
        'Address':[]
        }
        existing_df=pd.DataFrame(data)
        existing_df.to_excel('Contact Information.xlsx', index=False)
        
    while True:
        str="""Contact Management:
        1. Add contact
        2. View contact
        3. Search contact
        4. Updata contact
        5. Delete contact
        6. Exit"""
        print(str)
        choice=input("Enter You choice number: ")
        if choice == '1':
            existing_df=Add_contact(existing_df)

        elif choice == '2':
            print("\nContact Information\n")
            print(existing_df)
            print("\n")
            
        elif choice == '3':
            Search_contact(existing_df)
            
        elif choice == '4':
            existing_df=Update_contact(existing_df)

        elif choice == '5':
            existing_df=Delete_contact(existing_df)

        elif choice == '6':
            break

        else:
            print("Enter the valid choice number: ")

