---
layout: page
title: User Guide
---

Tuition connect is a desktop app that helps tutors keep track of their tutees and schedules. Command Line Interface (CLI). Users are able to add tutees and their relevant information to a personal list.

* Table of Contents
  {:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `TuitionConnect.jar` from [here](https://github.com/AY2324S1-CS2103T-F10-4/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your TuitionConnect.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar TuitionConnect.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all tutees.

   * `add n/John Doe p/98765432 a/John street, block 123, #01-01 sb/Primary 4 Math d/wed b/1500 e/1600` : Adds a tutee named `John Doe` to the list.

   * `delete 3` : Deletes the 3rd tutee shown in the current list.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

### Adding a person : `add`

**Description**: Adds a tutee into the list

**Format**: `add n/NAME p/PHONE_NUMBER a/ADDRESS s/SUBJECT d/DAY b/BEGIN e/END`

**Expected Input**:
* **Name (Compulsory field)**: String composed of character between A-Z and a-z.
* **Phone number (Optional field)**: 8 digit number.
* **Address (Optional field)**: String without restriction in characters.
* **Subject (Optional field)**: String without restriction in characters.
* **Day (Optional field)**: String with restrictions in characters, non-case sensitive (Mon/Tue/Wed/Thu/Fri/Sat/Sun).
* **Begin (Optional field)**: String with restrictions (HHMM).
* **End (Optional field)**: String with restrictions (HHMM).
* **PayRate (Compulsory field)**: String with restrictions in characters, only numbers allowed (no negative numbers).

**Expected Output when the command succeeds**: Successfully added tutee XXX(Name)

**Expected Output when the command fails**:

* **Missing name**: Please input a name
* **Invalid Phone number**: Please provide a valid phone number
* **Invalid Day**: Please input a valid day
* **Invalid Begin**: Please input a valid time for Begin in HHMM
* **Invalid End**: Please input a valid time for End in HHMM
* **Invalid PayRate**: PayRate can take any values, as long as they are integers.

**Examples**:
* `add n/John Doe p/98765432 a/John street, block 123, #01-01 sb/Primary 4 Math d/wed b/1500 e/1600 pr/20`
* `add n/Betsy Crowe p/92939402 e/betsycrowe@example.com a/Newgate Prison p/1234567 s/Secondary 3 Physics d/mon b/1900 e/1930 pr/35`

### View the list : `list`

**Description** : Shows the current list of tutees in your list.

Format: `list`

### View the list of tutees specified by day : `list [DAY]`

**Description** : Shows the current list of tutees filtered by the specified dat.

Format: `list [DAY]`

**Expected Input**:
* **Day (Optional field)**: String with restrictions in characters, non-case sensitive (Mon/Tue/Wed/Thu/Fri/Sat/Sun).

### Editing a tutee : `edit`

**Description** : Edit a tutee in the current list.

**Format**: `edit INDEX n/NAME p/PHONE_NUMBER a/ADDRESS s/SUBJECTS d/DAY b/BEGIN e/END pr/PAYRATE`

**Expected Input**:
* **Index (Compulsory Field)**: Numbers between 1 to the number of people inside the list.
* **Name (Optional field)**: String composed of character between A-Z and a-z.
* **Phone number (Optional field)**: 8 digit number.
* **Address (Optional field)**: String without restriction in characters.
* **Subject (Optional field)**: String without restriction in characters.
* **Day (Optional field)**: String with restrictions in characters, non-case sensitive (Mon/Tue/Wed/Thu/Fri/Sat/Sun).
* **Begin (Optional field)**: String with restrictions (HHMM).
* **End (Optional field)**: String with restrictions (HHMM).
* **PayRate (Optional field)** String with restrictions in characters, only numbers allowed (no negative numbers).

**Expected Output when the command succeeds**: Successfully edited XXX(Name)

**Expected Output when the command fails**:

* **Invalid Phone number**: Please provide a valid phone number.
* **Invalid Day**: Please input a valid day.
* **Invalid Begin**: Please input a valid time for Begin in HHMM.
* **Invalid End**: Please input a valid time for End in HHMM.
* **Invalid PayRate**: PayRate can take any values, as long as they are integers.

**Examples**:

To edit the phone number of your tutee and day of tutoring:
*  `edit p/91234567 d/Sun`

To edit name and address of your tutee:
*  `edit n/Betsy Crower a/Betsy street, block 110, #03-02`

### Deleting a person : `delete`

**Description** Deletes the specific tutee from the list.

**Format**: `delete INDEX`

**Expected Input**:

* **Index (Compulsory Field)**: Numbers between 1 to the number of people inside the list.

**Expected Output when the command succeeds**: Successfully deleted NAME from the list

**Expected Output when the command fails**: Please input a valid index

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the list.

### Marking a person as paid : `paid`

**Description** Mark the specific tutee as paid in the list.

**Format**: `paid INDEX`

**Expected Input**:

* **Index (Compulsory Field)**: Numbers between 1 to the number of people inside the list.

**Expected Output when the command succeeds**: MARK PERSON PAID SUCCESS, Paid: true

**Expected Output when the command fails**: Invalid command format! paidExample: paid 1

Examples:
* `list` followed by `paid 2` marks the 2nd person in the list.

### Show all the unpaid persons : `list unpaid`

**Description** : Shows all the unpaid tutees in your list.

Format: `list unpaid`


### Finding Free Time : `freeTime`

**Description**: Finds a list of free time in your schedule

**Format**: `freeTime d/DAY dur/DURATION b/BEGIN end/END`

**Expected Input**:
* **Day (Compulsory field)**: String with restrictions in characters, non-case sensitive (Mon/Monday/Tue/Tuesday/Wed/Wednesday/Thu/Thursday/Fri/Friday/Sat/Saturday/Sun/Sunday).
* **Duration (Compulsory field)**: Positive Integer to represent duration in minutes.
* **Begin (Compulsory field)**: String with restrictions (HHMM).
* **End (Compulsory field)**: String with restrictions (HHMM).

**Expected Output when the command succeeds**: Free From: ...

**Expected Output when the command fails**:

* **Invalid Day**: Days should be written using their full names or their first three letters, and it should not be blank.
* **Duration**: The duration must be a positive integer
* **Invalid Begin**: Begin has a format of HHMM
* **Invalid End**: End has a format of HHMM

--------------------------------------------------------------------------------------------------------------------

## FAQ

To be added soon

--------------------------------------------------------------------------------------------------------------------

## Known issues

To be added soon

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action          | Format, Examples                                                                                                                                                                                   |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **add**         | `add n/NAME p/PHONE_NUMBER a/ADDRESS s/SUBJECT d/DAY b/BEGIN e/END pr/PAYRATE` <br> e.g., `add n/John Doe p/98765432 a/John street, block 123, #01-01 sb/Primary 4 Math d/wed b/1500 e/1600 pr/20` |
| **delete**      | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                |
| **edit**        | `edit INDEX n/NAME p/PHONE_NUMBER a/ADDRESS s/SUBJECTS d/DAY b/BEGIN e/END pr/PAYRATE`<br> e.g.,`edit p/91234567 d/Sun`                                                                            |
| **list**        | `list`                                                                                                                                                                                             |
| **paid**        | `paid INDEX`<br> e.g., `paid 1`                                                                                                                                                                    |
| **list unpaid** | `list unpaid`                                                                                                                                                                                      |
| **freeTime**    | `d/DAY dur/DURATION b/BEGIN end/END`                                                                                                                                                               |
