import re
import datetime
def format_date(lis):
    global cforamt
    cforamt =0
    for line in lis:
        if line[2] != "":
            T1 = line[2]
            T1 = T1.split(" ")
            if not T1[0].isnumeric():
                T1 = " ".join(T1)
                T1 = re.split("[/ -]", T1)
                if not T1[1].isalpha():
                    x = datetime.datetime(2000, int(T1[1]), 2)
                    t = x.strftime("%B")
                    T1[1] = t
                cforamt += 1
            else:
                if not T1[1].isalpha():
                    x = datetime.datetime(2000, int(T1[1]), 2)
                    t = x.strftime("%B")
                    T1[1] = t
                    cforamt += 1
            line[2] = " ".join(T1)
        if line[7] != "":
            T2 = line[7]
            T2 = T2.split(" ")
            if not T2[0].isnumeric():
                T2 = " ".join(T2)
                T2 = re.split("[/ -]", T2)
                if not T2[1].isalpha():
                    x = datetime.datetime(2000, int(T2[1]), 2)
                    t = x.strftime("%B")
                    T2[1] = t
                cforamt += 1
            else:
                if not T2[1].isalpha():
                    x = datetime.datetime(2000, int(T2[1]), 2)
                    t = x.strftime("%B")
                    T2[1] = t
                    cforamt += 1
            line[7] = " ".join(T2)
        if line[8] != "":
            T3 = line[8]
            T3 = T3.split(" ")
            if not T3[0].isnumeric():
                T3 = " ".join(T3)
                T3 = re.split("[/ -]",T3)
                if not T3[1].isalpha():
                    x = datetime.datetime(2000, int(T3[1]), 2)
                    t = x.strftime("%B")
                    T3[1] = t
                cforamt += 1
            else:
                if not T3[1].isalpha():
                    x = datetime.datetime(2000, int(T3[1]), 2)
                    t = x.strftime("%B")
                    T3[1] = t
                    cforamt += 1
            line[8] = " ".join(T3)
def complete_data(list):
    global cname , cid , cdob , cmonb , cnon , ccl , ccmak , cyear , crename , creid , credob , cremonb , crecl, cremake , creyear
    cname = cid = cdob = cmonb = cnon = ccl = ccmak = cyear = crename = creid = credob = cremonb = crecl = cremake = creyear = 0
    miss = []
    complete = []
    for line in list:
        line[0]=line[0].title()
        if line[0] == "" and line[1] == "" and line[3] == "":
            cnon+=1
            miss.append(line)
        else:
            if line[0] == "":
                if line[1] != "":
                    for lin in list:
                        if line[1] == lin[1]:
                            if lin[0] == "":
                                continue
                            else:
                                line[0] = lin[0]
                                break
                else:
                    for lin in list:
                        if line[3] == lin[3]:
                            if lin[0] == "":
                                continue
                            else:
                                line[0] = lin[0]
                                break
                cname += 1
                if line[0] == "":
                    cnon += 1
                    miss.append(line)
                else:
                    crename += 1
            if line[1] == "":
                for lin in list:
                    if line[0] == lin[0]:
                        if lin[1] == "":
                            continue
                        else:
                            line[1] = lin[1]
                            break
                cid += 1
                if line[1] == "":
                    if line not in miss:
                        cnon += 1
                        miss.append(line)
                else:
                    creid += 1
            if line[2] == "":
                for lin in list:
                    if line[0] == lin[0]:
                        if lin[2] == "":
                            continue
                        else:
                            line[2] = lin[2]
                            break
                cdob += 1
                if line[2] == "":
                    print(line)
                    if line not in miss:
                        cnon += 1
                        miss.append(line)
                else:
                    credob += 1
            if line[3] == "":
                for lin in list:
                    if line[0] == lin[0]:
                        if lin[3] == "":
                            continue
                        else:
                            line[3] = lin[3]
                            break
                cmonb += 1
                if line[3] == "":
                    if line not in miss:
                        cnon += 1
                        miss.append(line)
                else:
                    cremonb += 1
        if line[4] == "":
            ccl += 1
            if line not in miss:
                miss.append(line)
        if line[5] == "":
            ccmak += 1
            if line[4] != "":
                for lin in list:
                    if line[4] == lin[4]:
                        if lin[5] == "":
                            continue
                        else:
                            line[5] = lin[5]
                            break
                if line[5] == "":
                    if line not in miss:
                        miss.append(line)
                else:
                    cremake += 1
        if line[6] == "":
            cyear += 1
            if line[4] != "":
                for lin in list:
                    if line[4] == lin[4]:
                        if lin[6] == "":
                            continue
                        else:
                            line[6] = lin[6]
                            break
                if line[6] == "":
                    if line not in miss:
                        miss.append(line)
                else:
                    creyear += 1
        if line not in miss:
            complete.append(line)
    filemiss = open("CarRentalMissing.txt","w")
    for car in miss:
        car = ";".join(car)
        filemiss.write(car)
    filemiss.close()

    filecomplete = open("CarRentalCompleted.txt","w")
    for car in complete:
        car = ";".join(car)
        filecomplete.write(car)
    filecomplete.close()

def duplicate():
    global cduplicate
    cduplicate = 0
    comp= []
    f = open("CarRentalCompleted.txt", "r")
    for line in f:
        line = line.split(";")
        if line not in comp:
            comp.append(line)
        else:
            cduplicate += 1
    f.close()

    filecomplete = open("CarRentalCompleted.txt", "w")
    for car in comp:
        car = ";".join(car)
        filecomplete.write(car)
    filecomplete.close()
lis = []
f = open("CarRentalOld.txt", "r")
for line in f:
    line = line.split(";")
    lis.append(line)
format_date(lis)
f.close()
complete_data(lis)
duplicate()
print("Summary of data missing in the database:")
print("Number of duplicate entries in the database =",cduplicate)
print("Number of entries with wrong data format in the database =",cforamt)
print("Number of entries where Names are dropped from the database =",cname)
print("Number of entries where Ids are dropped from the database =",cid)
print("Number of entries where DoB are dropped from the database =",cdob)
print("Number of entries where Mobile Numbers are dropped from the database =",cmonb)
print("Number of entries where personal entry can not be completed =",cnon)
print("Number of entries where Car Make are dropped from the database =",ccmak)
print("Number of entries where Car Ids are dropped from the database =",ccl)
print("Number of entries where Car Models (year) are dropped from the database =",cyear)
print()
print()
print("Summary of data recovered from the database:")
print("Number of duplicate entries removed from the new database =",cduplicate)
print("Number of entries with wrong data format fixed in the new database =",cforamt)
print("Number of entries with Names recovered in the new database =",crename)
print("Number of entries with Ids recovered in the new database =",creid)
print("Number of entries with DoB recovered in the new database =",credob)
print("Number of entries with Mobile Numbers recovered in the new database =",cremonb)
print("Number of entries with Car Make recovered in the new database =",cremake)
print("Number of entries with Car Models (year) recovered in the new database =",creyear)
print("Done.....!!!!!!!")
