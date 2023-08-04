import random
import re

noofprocess = 0

processname = []  # create global arraylist
processid = []
processtime = []
arrivaltime = []
waitingtime = []
totaltime = []


def data():  # user input funtion
    noofprocess = int(input("Enter number of process: "))
    i = 0
    while i < noofprocess:
        processid.append(i + 1)

        name = input("Enter process name " + str(i + 1) + ": ")
        processname.append(name)

        ptime = int(input("Enter process time " + str(i + 1) + ": "))
        processtime.append(ptime)

        atime = int(input("Enter arrival time " + str(i + 1) + ": "))
        arrivaltime.append(atime)
        i += 1


def main():
    choice = 0
    check = True

    while check:  # menu
        check = False
        print("Menu:")
        print("1.FCFS Algo")
        print("2.RR Algo")
        choice = int(input("Choice: "))

        if choice == 1:
            fcfs()  # call FCFS funtion
        elif choice == 2:
            rr()  # call RR funtion
        else:
            check = True
            print("Wrong input")


def fcfs():  # FCFS funtion
    data()
    temp = 0
    waittemp = 0
    noofprocess = len(processid)
    i = 0
    while i < noofprocess:
        j = 0
        while j < noofprocess:  # Sort array by arrival time
            if i != j and arrivaltime[i] < arrivaltime[j]:
                temp = arrivaltime[i]
                arrivaltime[i] = arrivaltime[j]
                arrivaltime[j] = temp

                temp = processtime[i]
                processtime[i] = processtime[j]
                processtime[j] = temp

                temp = processid[i]
                processid[i] = processid[j]
                processid[j] = temp
            j += 1
        i += 1

    i = 0
    while i < noofprocess:  # Go through each process
        waitingtime.append(waittemp)  # add wait time
        if i > 0:
            waittemp = waitingtime[i] + \
                processtime[i - 1]  # calculate wait time

        waitingtime[i] = waittemp - arrivaltime[i]  # set waiting
        totaltime.append(waitingtime[i] + processtime[i])  # set total time
        i += 1

    i = 0
    while i < noofprocess:
        j = 0
        while j < noofprocess:  # sort array by id
            if i != j and processid[i] < processid[j]:
                temp = arrivaltime[i]
                arrivaltime[i] = arrivaltime[j]
                arrivaltime[j] = temp

                temp = processtime[i]
                processtime[i] = processtime[j]
                processtime[j] = temp

                temp = processid[i]
                processid[i] = processid[j]
                processid[j] = temp

                temp = waitingtime[i]
                waitingtime[i] = waitingtime[j]
                waitingtime[j] = temp

                temp = totaltime[i]
                totaltime[i] = totaltime[j]
                totaltime[j] = temp
            j += 1
        i += 1

    print("{0:<13}\t{1:<13}\t{2:<13}\t{3:<13}".format(
        "Process Name", "Process Time", "Waiting Time", "Total Time"))
    i = 0
    while i < noofprocess:  # display process in table
        print("{0:<13}\t{1:<13d}\t{2:<13d}\t{3:<13d}".format(
            processname[i], processtime[i], waitingtime[i], totaltime[i]))
        i += 1


def rr():  # RR funtion
    data()
    noofprocess = len(processid)

    i = None
    j = None
    k = None
    sum = 0
    quantum = None
    temp = 0
    burst = None
    waiting = None
    total = None
    rem_burst = None
    stemp = ""
    burst = []  # lists
    waiting = [0] * noofprocess
    total = [0] * noofprocess
    rem_burst = []

    i = 0
    while i < noofprocess:  # temp list
        burst.append(processtime[i])
        rem_burst.append(burst[i])
        i += 1

    i = 0
    while i < noofprocess:
        j = 0
        while j < noofprocess:  # sort array by arrival
            if i != j and arrivaltime[i] < arrivaltime[j]:
                temp = arrivaltime[i]
                arrivaltime[i] = arrivaltime[j]
                arrivaltime[j] = temp

                temp = burst[i]
                burst[i] = burst[j]
                burst[j] = temp

                temp = rem_burst[i]
                rem_burst[i] = rem_burst[j]
                rem_burst[j] = temp

                temp = processid[i]
                processid[i] = processid[j]
                processid[j] = temp

                temp = processname[i]
                processname[i] = processname[j]
                processname[j] = temp
            j += 1
        i += 1

    quantum = int(input("Enter the quantum: "))  # input quantum
    condition = True
    while condition:  # loop till all process finished
        i = 0
        while i < noofprocess:  # loop one through all process
            if rem_burst[i] > quantum:  # if process have more then quantum
                rem_burst[i] -= quantum  # subtract quantum
                j = 0
                while j < noofprocess:
                    if (j != i) and (rem_burst[j] != 0):
                        waiting[j] += quantum  # calculate wait time
                    j += 1
            else:
                j = 0
                while j < noofprocess:
                    if (j != i) and (rem_burst[j] != 0):
                        waiting[j] += rem_burst[i]  # calculate wait time
                    j += 1
                rem_burst[i] = 0
            i += 1
        sum = 0
        k = 0
        while k < noofprocess:
            sum = sum + rem_burst[k]
            k += 1
        condition = sum != 0
    i = 0
    while i < noofprocess:
        total[i] = burst[i] + waiting[i]  # calculate total time
        # subtract arrival time from total
        total[i] = total[i] - arrivaltime[i]
        # subtract arrival time from wait
        waiting[i] = waiting[i] - arrivaltime[i]
        i += 1

    i = 0
    while i < noofprocess:
        j = 0
        while j < noofprocess:  # sort array by id
            if i != j and processid[i] < processid[j]:
                temp = processid[i]
                processid[i] = processid[j]
                processid[j] = temp

                temp = arrivaltime[i]
                arrivaltime[i] = arrivaltime[j]
                arrivaltime[j] = temp

                temp = burst[i]
                burst[i] = burst[j]
                burst[j] = temp

                temp = rem_burst[i]
                rem_burst[i] = rem_burst[j]
                rem_burst[j] = temp

                stemp = processname[i]
                processname[i] = processname[j]
                processname[j] = stemp

                temp = waiting[i]
                waiting[i] = waiting[j]
                waiting[j] = temp

                temp = total[i]
                total[i] = total[j]
                total[j] = temp
            j += 1
        i += 1

    print("{0:<13}\t{1:<13}\t{2:<13}\t{3:<13}".format(
        "Process Name", "Process Time", "Waiting Time", "Total Time"))
    i = 0
    while i < noofprocess:  # display process in table
        print("{0:<13}\t{1:<13d}\t{2:<13d}\t{3:<13d}".format(
            processname[i], burst[i], waiting[i], total[i]))
        i += 1


main()
