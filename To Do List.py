import os

def Write_Task(list):
    with open("To-Do_app_DB.txt",'w') as file:
        file.write("")

    with open("To-Do_app_DB.txt","a") as file:
        for i in range(len(list)-1):
            text=list[i]+"\n\n"
            file.write(text)



def help():
    str="""
    DS.
    help  -h        : show the all command.
    add             : Add an element in the list.
    update          : Updata your task useing index.
    view            : Show the all element of list.
    remove / rm     : Remove an element in the list.
    mark            : Mark task as complete.
    del             : Delete all data of the file.
    exit            : Exit for exit the App.
    """
    print(str)

    

def  Add_Task(titel,discription,priority,due_data="none"):
    with open("To-Do_app_DB.txt","a") as file:
        conten=f"""Titel       : {titel}
priority    : {priority}
Due Date    : {due_data}
discription : {discription} 

"""
        file.write(conten)
    print("Add task successfuly")



def  update_Task(titel,discription,priority,index,due_data="none"):
    list=[]
    if os.path.exists("To-Do_app_DB.txt"):
        with open("To-Do_app_DB.txt","r") as file:
            conten=f"""Titel       : {titel}
priority    : {priority}
Due Date    : {due_data}
discription : {discription}"""

            text=file.read()
            list=text.split("\n\n")
            if ['']==list:
                print("Data is not found.")

            elif len(list)-1>index:
                list[index]=conten
                Write_Task(list)
                print("update successfuly")
            
            else:
                print("This index is empty")
    else:
        print("File is empty")


def view_task():
    index=0
    if os.path.exists("To-Do_app_DB.txt"):
        with open("To-Do_app_DB.txt","r") as file:
            text=file.read()
            list=text.split("\n\n")

            if ['']==list:
                print("Data is not found.")
            else:
                for l in range(len(list)-1):
                    print("\nIndex: ",index,"\n",list[l])
                    index+=1
    else:
        print("File is empty")



def remove_task(index):
    if os.path.exists("To-Do_app_DB.txt"):
        with open("To-Do_app_DB.txt","r") as file:
            text=file.read()
            list=text.split("\n\n")

            if ['']==list:
                print("Data is not found.")

            elif len(list)-1>index:
                list.pop(index)
                Write_Task(list)

            else:
                print("This index is empty")
    else:
        print("File is empty")



def mark_task(index):
    if os.path.exists("To-Do_app_DB.txt"):
        with open("To-Do_app_DB.txt","r") as file:
            text=file.read()
            list=text.split("\n\n")
            if ['']==list:
                print("Data is not found.")
            elif len(list)-1>index:
                list[index]="[ok] This task is completed.\n"+list[index]
                Write_Task(list)
            
            else:
                print("This index is empty")
    else:
        print("File is empty")


def del_all_task():
    with open("To-Do_app_DB.txt",'w') as file:
        file.write("")



if __name__=="__main__":
    help()
    while(True):
        user_input=input("\nTo-Do List Application : ")
        user_input=user_input.lower()

        if user_input == "help" or user_input == "-h":
            help()  

        elif user_input == "add":
            titel = input("Task Title: ")
            discription = input("Task Description: ")
            due_data = input("Due Date (YYYY-MM-DD): ")
            priority = int (input("Priority (1-5): "))
            Add_Task(titel,discription,priority,due_data)


        elif user_input == "update":
            index = int(input("Enter task index to update: "))
            titel = input("New Task Title: ")
            discription  =  input("New Task Description: ")
            due_data  =  input("New Due Date (YYYY-MM-DD): ")
            priority = int(input("New Priority (1-5): "))
            update_Task(titel,discription,priority,index, due_data)

        elif user_input=="view":
            view_task()

        elif user_input=="remove" or user_input=="rm":
            index=int(input("Enter index no. : "))
            remove_task(index)

        elif user_input=="mark":
            index = int (input("Enter the index of the element: "))
            mark_task(index)

        elif user_input=="del":
            del_all_task()

        elif user_input=="exit":
            break

        else:
            print("This command is not found")
