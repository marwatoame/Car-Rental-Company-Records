def Name(arr,name):
    cars = []
    moneypaid = 0
    flag = 0
    for i in arr:
        if i[0] == name:
            cars.append(i)
            flag = 1
            moneypaid = moneypaid+int(i[9])
    if flag == 1:
        print("Personal information:")
        print("Name:", name)
        print("Id number:", cars[0][1])
        print("Date of Birth:", cars[0][2])
        print("Mobile number:", cars[0][3])
        print("Car information:")
        for i in cars:
            print("The car license number:", i[4])
            print("Car make:", i[5])
            print("The year of manufacturing the car", i[6])
            print("Car rent start date:", i[7])
            print("Car rent end date:", i[8])
            print("The amount the customer paid for this rental:", i[9])
        print("\nTotal Money Paid by the lessee:",moneypaid)
    return

def ID(arr,Id):
    cars = []
    moneypaid = 0
    flag = 0
    for i in arr:
        if i[1] == Id:
            cars.append(i)
            flag = 1
            moneypaid = moneypaid+int(i[9])
    if flag == 1:
        print("Personal  information:")
        print("Name:", cars[0][0])
        print("Id number:", cars[0][1])
        print("Date of Birth:", cars[0][2])
        print("Mobile number:", cars[0][3])
        print("Car information:")
        for i in cars:
            print("The car license number:", i[4])
            print("Car make:", i[5])
            print("The year of manufacturing the car", i[6])
            print("Car rent start date:", i[7])
            print("Car rent end date:", i[8])
            print("The amount the customer paid for this rental:", i[9])
        print("\nTotal Money Paid by the lessee:",moneypaid)
    return

def CLics(arr,CL):
    cars = []
    moneypaid = 0
    flag = 0
    for i in arr:
        if i[4] == CL:
            cars.append(i)
            flag = 1
            moneypaid = moneypaid+int(i[9])
    if flag == 1:
        print("Car information:")
        print("The car license number:", cars[0][4])
        print("Car make:", cars[0][5])
        print("The year of manufacturing the car", cars[0][6])
        print("Car rent start date:", cars[0][7])
        print("Car rent end date:", cars[0][8])
        print("The amount the customer paid for this rental:", cars[0][9])
        print()
        print("Personal  information:")
        for i in cars:
            print("Name:", i[0])
            print("Id number:", i[1])
            print("Date of Birth:", i[2])
            print("Mobile number:", i[3])

        print("\nRevenue made from renting the car :",moneypaid)
    return

file = open("CarRentalCompleted.txt","r")
data = []
for line in file:
    line = line.strip()
    data.append(line.split(';'))

file.close()
option = int(
    input("1.Inquiry about a person using name or id\n"
          "2.Inquiry about car using its licsence number\n"
          "Enter:"))
if option == 1:
    option = int(input("1.lessee`s Name:\n2.Id number:\nEnter:"))
    if option == 1:
        name = input("Please enter the lessee's name:")
        Name(data,name)
    else:
        id = input("Please enter the lessee's id:")
        ID(data,id)
else:
    CL=input("Please enter the license's number:")
    CLics(data,CL)
