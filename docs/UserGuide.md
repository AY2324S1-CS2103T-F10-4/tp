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

1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar addressbook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

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
* **Day (Optional field)**: String with restrictions in characters, non-case sensitive (Mon/Tues/Wed/Thurs/Fri/Sat/Sun).
* **Begin (Optional field)**: String with restrictions (HHMM).
* **End (Optional field)**: String with restrictions (HHMM).

**Expected Output when the command succeeds**: Successfully added tutee XXX(Name)

**Expected Output when the command fails**:

* **Missing name**: Please input a name
* **Invalid Phone number**: Please provide a valid phone number
* **Invalid Day**: Please input a valid day
* **Invalid Begin**: Please input a valid time for Begin in HHMM
* **Invalid End**: Please input a valid time for End in HHMM

**Examples**:
* `add n/John Doe p/98765432 a/John street, block 123, #01-01 sb/Primary 4 Math d/wed b/1500 e/1600`
* `add n/Betsy Crowe p/92939402 e/betsycrowe@example.com a/Newgate Prison p/1234567 s/Secondary 3 Physics d/mon b/1900 e/1930`

### View the list : `list`

**Description** : Shows the current list of tutees in your list.

Format: `list`

### Editing a tutee : `edit`

**Description** : Edit a tutee in the current list.

**Format**: `edit INDEX n/NAME p/PHONE_NUMBER a/ADDRESS s/SUBJECTS d/DAY b/BEGIN e/END`

**Expected Input**:
* **Index (Compulsory Field)**: Numbers between 1 to the number of people inside the list.
* **Name (Optional field)**: String composed of character between A-Z and a-z.
* **Phone number (Optional field)**: 8 digit number.
* **Address (Optional field)**: String without restriction in characters.
* **Subject (Optional field)**: String without restriction in characters.
* **Day (Optional field)**: String with restrictions in characters, non-case sensitive (Mon/Tues/Wed/Thurs/Fri/Sat/Sun).
* **Begin (Optional field)**: String with restrictions (HHMM).
* **End (Optional field)**: String with restrictions (HHMM).

**Expected Output when the command succeeds**: Successfully edited XXX(Name)

**Expected Output when the command fails**:

* **Invalid Phone number**: Please provide a valid phone number.
* **Invalid Day**: Please input a valid day.
* **Invalid Begin**: Please input a valid time for Begin in HHMM.
* **Invalid End**: Please input a valid time for End in HHMM.

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
* `list` followed by `delete 2` deletes the 2nd person in the address book.


--------------------------------------------------------------------------------------------------------------------

## FAQ

To be added soon

--------------------------------------------------------------------------------------------------------------------

## Known issues

To be added soon

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER a/ADDRESS s/SUBJECT d/DAY b/BEGIN e/END` <br> e.g., `add n/John Doe p/98765432 a/John street, block 123, #01-01 sb/Primary 4 Math d/wed b/1500 e/1600`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX n/NAME p/PHONE_NUMBER a/ADDRESS s/SUBJECTS d/DAY b/BEGIN e/END`<br> e.g.,`edit p/91234567 d/Sun`
**List** | `list`

