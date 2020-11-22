package ibrahim;

import java.util.ArrayList;

/**
 *
 * @author caveb
 */
public class gameBoard {
    ArrayList<boardSlot> board = new ArrayList<>();

    public gameBoard() {
        String slot0 = "Roll the dice to start the game!";
        String slot1 = "Troubled Buisness:\n \nYour buisness during the pandemic\n is suffering from a lack of buisness.";
        String slot2 = "Contagious Crowd:\n \nWhile shopping, someone sneezes near you\nwithout their mask on.";
        String slot3 = "Free time = Free mind:\n \nYou have had a surplux of free time during\nthe pandemic now allowing you to do more\nself care.";
        String slot4 = "Everything seems calm...for now";
        String slot5 = "Online Friends:\n \nYou have branched out to making friends\nover social media and it's been a blast!";
        String slot6 = "Lonely...:\n \nCovid-19 has taken most of your social life\naway, leaving you only with you thoughts.";
        String slot7 = "Youve made it quite far into the pandemic...\n \ngood luck";
        String slot8 = "Online Classes:\n \nBecause of the pandemic, schools have\nmoved to online education. \n \n"
                + "even roll: school has been going well and\n                your grades have gone up\nodd roll: school has turned into a nightmare!";
        String slot9 = "YOU HAVE CAUGHT CORONA!!!!\n \nluckly you survived, but you'll have to go\nback to the begining.";
        String slot10 = "Introverts Shine:\n \nthe pandemic has kept you in your element,\nyou never really liked going out anyways.";
        String slot11 = "Lost Loved Ones:\n \nOne of your close family members passes\nof Covid-19...";
        String slot12 = "You're half way through the pandemic!...\n \nOnly 2 more years to go :)";
        String slot13 = "Working from Home:\n \nYour employeer has decided for you to work\nfrom home\n \n"
                + "1-3: Its been hard to keep up with the work\n        at home \n4-6: workign from home as been great and\n        has granted you some more free time";
        String slot14 = "Toilet Paper bandits:\n \nPeople have bought all the toilet paper in\nyour local markets. they are attempting\nto resell them for a marked up price!";
        String slot15 = "You are getting close to the end...\n \nstay strong!";
        String slot16 = "YOU HAVE CAUGHT CORONA!!!!\n \nluckly you survived, but you'll have to go\nback to the begining.";
        String slot17 = "New Hobbies:\n \nYou have took the extra time you have at\nhome to learn a new hobby";
        String slot18 = "Rent Due:\n \nRent is due and you're having a hard\nkeeping up with payments";
        String slot19 = "Delayed Entertainment\n \nBecause of the pandemic, your favorite\nshows have been delayed and some\ncancelled";
        String slot20 = "Environment:\n \nThe environment has seen some\nimprovments with less of us outside";
        String slot21 = "Anxiety:\n \nThe pandemic has caused many changes\nin your life and surrondings, you worry\nabout the future.";
        String slot22 = "family time:\n \nyou're at home more often now, spending\nmore time with your family \n"
                + "\neven health: being around your family more\n          is more of a hinderance than a benefit.\nodd health: your family has been supporting\n          you immensly";
        String slot23 = "YOU HAVE CAUGHT CORONA!!!!\n \nluckly you survived, but you'll have to go\nback to the begining.";
        
        board.add(new boardSlot(slot0, "N/A", 32, 540));
        board.add(new boardSlot(slot1, "-", 32, 455));
        board.add(new boardSlot(slot2, "-", 32, 370));
        board.add(new boardSlot(slot3, "+", 32, 285));
        board.add(new boardSlot(slot4, "N/A", 32, 200));
        board.add(new boardSlot(slot5, "+", 32, 115));
        board.add(new boardSlot(slot6, "-", 32, 30));
        board.add(new boardSlot(slot7, "N/A", 117, 30));
        board.add(new boardSlot(slot8, "+/-", 202, 30));
        board.add(new boardSlot(slot9, "DEATH", 287, 30));
        board.add(new boardSlot(slot10, "+", 372, 30));
        board.add(new boardSlot(slot11, "-", 457, 30));
        board.add(new boardSlot(slot12, "N/A", 542, 30));
        board.add(new boardSlot(slot13, "+/-", 542, 115));
        board.add(new boardSlot(slot14, "-", 542, 200));
        board.add(new boardSlot(slot15, "N/A", 542, 285));
        board.add(new boardSlot(slot16, "DEATH", 542, 370));
        board.add(new boardSlot(slot17, "+", 542, 455));
        board.add(new boardSlot(slot18, "-", 542, 540));
        board.add(new boardSlot(slot19, "-", 457, 540));
        board.add(new boardSlot(slot20, "+", 372, 540));
        board.add(new boardSlot(slot21, "-", 287, 540));
        board.add(new boardSlot(slot22, "+/-", 202, 540));
        board.add(new boardSlot(slot23, "DEATH", 117, 540));
    }
    
    public boardSlot getBoardSlot(int index) {
        return board.get(index);
    }
    
}
