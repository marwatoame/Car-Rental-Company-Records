import datetime
datestart = input("Enter the date of start rental(8 8 2020):")
dateend = input("Enter the date of end rental(16 8 2020):")
datestart = datestart.split()
dateend = dateend.split()
dstart = datetime.datetime(int(datestart[2]), int(datestart[1]), int(datestart[0]))
dend = datetime.datetime(int(dateend[2]), int(dateend[1]), int(dateend[0]))
list = []
file = open("CarRentalCompleted.txt","r")
for line in file:
    line = line.split(";")
    li = line[9].split("\n")
    line[9] = li[0]
    list.append(line)

file.close()
free = []
busy = []
for info in list:
    start = info[7]
    end = info[8]
    datstart = start.split()
    datend = end.split()
    month1 = 0
    for i in range(1,13):
        x = datetime.datetime(2000, i, 2)
        t = x.strftime("%B")
        if t == datstart[1]:
            month1 = i
            break
    dastart = datetime.datetime(int(datstart[2]), month1, int(datstart[0]))
    month2 = 0
    for j in range(1,13):
        x = datetime.datetime(2000, j, 2)
        t = x.strftime("%B")
        if t == datend[1]:
            month2 = j
            break
    daend = datetime.datetime(int(datend[2]), month2, int(datend[0]))
    if dstart > daend:
        ff = daend - dastart
        ff = str(ff)
        ff = ff.split()
        diffrental = int(ff[0])
        payday = int(int(info[9]) / diffrental)
        string = str(info[4]) + ' '+ str(info[5]) + ' '+ str(info[6]) + ' ' +str(payday)
        string = string.split()
        free.append(string)
    elif dstart > daend:
        ff = daend - dastart
        ff = str(ff)
        ff = ff.split()
        diffrental = int(ff[0])
        payday = int(int(info[9]) / diffrental)
        string = str(info[4]) + ' ' + str(info[5]) + ' ' + str(info[6]) + ' ' + str(payday)
        string = string.split()
        free.append(string)
    else:
        string = str(info[4]) + ' ' + str(info[5]) + ' ' + str(info[6])
        string = string.split()
        busy.append(string)

for fre in free:
    for ff in busy:
        if fre[0] == ff[0]:
            free.remove(fre)
            break

for freee in free:
    print()
    print("The car license number:", freee[0])
    print("Car make:", freee[1])
    print("The year of manufacturing the car:", freee[2])
    print("Car rental price per day:", freee[3])

print()
print("You want to rent any car?\n"
           "1-Yes\n"
           "2-No")
ch = input("Enter:")
print()
if ch == "Yes":
    print("Please Enter a Personal information:")
    name = input("Enter your name:")
    id = input("Enter your Id:")
    dob = input("Enter your Date of birth(8 August 2000):")
    mob = input("Enter your mobile number:")
    cl = input("Enter the car license number:")
    cm = input("Enter the car make:")
    year = input("Enter the year of manufacturing the car:")
    i = 1
    for ffff in free:
        if cl == ffff[0] and cm == ffff[1] and year == ffff[2]:
            i = 0
            break
    if i == 1:
        print("not find the car....")
    else:
        f = dend - dstart
        f = str(f)
        f = f.split()
        rental = int(f[0])
        per = 0
        for cc in free:
            if cl == cc[0]:
                per = cc[3]
                break
        pd = int(per) * rental
        x = datetime.datetime(2000, int(datestart[1]), 2)
        t = x.strftime("%B")
        datestart[1] = t
        datestart = " ".join(datestart)
        x2 = datetime.datetime(2000, int(dateend[1]), 2)
        t2 = x2.strftime("%B")
        dateend[1] = t2
        dateend = " ".join(dateend)
        new = str(name) + ';' + str(id) + ';' + str(dob) + ';' + str(mob) + ';' + str(cl) + ';' + str(cm) + ';' + str(year) + ';' + str(datestart) + ';' + str(dateend) + ';' + str(pd)
        new = new.split(";")
        list.append(new)
        filecomplete = open("CarRentalCompleted.txt", "w")
        for car in list:
            car = ";".join(car)
            car = car+'\n'
            filecomplete.write(car)
        filecomplete.close()

        print("The car rental price is:", pd)
        print("The car rental is successful")
elif ch == "No":
    print("GoodBye....!")

else:
    print("Valid Value....!")
