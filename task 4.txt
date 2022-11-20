import datetime
def Car(arr):
    infoofcar = []
    for line in arr:
        T1 = line[7]
        T1 = T1.split(" ")
        month1 = 0
        for i in range(1, 13):
            x = datetime.datetime(2000, i, 2)
            t = x.strftime("%B")
            if t == T1[1]:
                month1 = i
                break
        dastart = datetime.datetime(int(T1[2]), month1, int(T1[0]))
        T2 = line[8]
        T2 = T2.split(" ")
        month2 = 0
        for i in range(1, 13):
            x = datetime.datetime(2000, i, 2)
            t = x.strftime("%B")
            if t == T2[1]:
                month2 = i
                break
        daend = datetime.datetime(int(T2[2]), month2, int(T2[0]))
        ff = daend - dastart
        ff = str(ff)
        ff = ff.split()
        diffrental = int(ff[0])
        list = [line[5], line[4], diffrental, line[9]]
        i = 0
        for dd in infoofcar:
            if list[1] != dd[1]:
                continue
            else:
                dd[2] += diffrental
                dd[3] = str(int(dd[3]) + int(list[3]))
                i = 1
                break
        if i == 0:
            infoofcar.append(list)

    for ss in infoofcar:
        print("Car make:", ss[0])
        print("The car license number:",ss[1])
        print("Number of days the car was rented:", ss[2])
        print("Revenue made by renting the car:", ss[3])
        pppp = int(ss[3]) / ss[2]
        print("Average price per day for renting:",pppp,"\n")

file = open("CarRentalCompleted.txt","r")
data = []
for line in file:
    line = line.strip()
    data.append(line.split(';'))

file.close()

Car(data)

