print("Task1:")
import T1
while 1:
    print("******************************************")
    print("Main Menu:")
    print("1. Task2: Inquire information")
    print("2. Task3: Add information for a new car rental.")
    print("3. Task4: Print statistics about each car.")
    print("4. exit.")
    print("******************************************")
    ch = int(input("Please enter your option: "))
    if ch == 1:
        import T2
    elif ch == 2:
        import T3
    elif ch == 3:
        import T4
    elif ch == 4:
        print("GoodBye...!")
        exit(0)
    else:
        print("Please Enter a Valid Value...!")
