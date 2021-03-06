package com.techelevator;

import java.sql.SQLOutput;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;
		System.out.println("Exercise 1= " + birdsRemaining);

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;
		System.out.println("Exercise 2= "+ numberOfExtraBirds);

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numberRaccoonsPlaying = 3;
		int numberRaccoonsHungry= 2;
		int numberRaccoonsLeft = numberRaccoonsPlaying - numberRaccoonsHungry;
		System.out.println("Exercise 3= "+ numberRaccoonsLeft);


        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int numberOfFlowers = 5;
		int numberOfBees = 3;
		int lonelyBees= numberOfFlowers - numberOfBees ;
		System.out.println("Exercise 4= "+ lonelyBees);

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int eatingPigeon = 1;
		int hungryPigeon = 1;
		int breadCrumbsEater = eatingPigeon + hungryPigeon ;
		System.out.println("Exercise 5= "+ breadCrumbsEater);

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int sittingOwls= 3;
		int flyingOwls= 2;
		int restingOwls = sittingOwls + flyingOwls;
		System.out.println("Exercise 6= "+ restingOwls);


        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int workingBeavers = 2;
		int lazyBeavers = 1;
		int hardWorkingBeavers= workingBeavers - lazyBeavers ;
		System.out.println("Exercise 7= "+ hardWorkingBeavers);


        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int sittingToucans = 2;
		int tiredToucans = 1;
		int restingToucans = sittingToucans + tiredToucans;
		System.out.println("Exercise 8= "+ restingToucans);

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int numberOfSquirrels = 4 ;
		int numberOfNuts= 2;
		int poorSquirrels= numberOfSquirrels - numberOfNuts;
		System.out.println("Exercise 9= "+ poorSquirrels);

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarter = 0.25;
		double dime = 0.10;
		double nickels = 0.05;
		double luckyHilt= quarter + dime + (2 * nickels);
		System.out.printf("Exercise 10 = $"+ "%.2f\n ", luckyHilt);


        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brierClass = 18;
		int macadamsClass = 20;
		int flanneryClass = 17;
		int totalMuffins = brierClass + macadamsClass + flanneryClass ;
		System.out.println("Exercise 11= "+ totalMuffins);


        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double firstToy= 0.24;
		double secondToy = 0.14;
		double totalSpending= firstToy + secondToy;
		System.out.println("Exercise 12= $"+ totalSpending);


        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallows= 8;
		int miniMarshmallows= 10;
		int allMarshmallows= largeMarshmallows + miniMarshmallows;
		System.out.println("Exercise 13= "+ allMarshmallows);


        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int hiltSnow = 29;
		int schoolSnow= 17;
		int moreSnowAtHilts= hiltSnow - schoolSnow ;
		System.out.println("Exercise 14= "+ moreSnowAtHilts+ " inches");


        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		double hiltMoney= 10.00;
		double toyTruck = 3.00;
		double pencil= 2.00;
		double moneyLeft= hiltMoney - toyTruck - pencil;
		System.out.println("Exercise 15= $"+ moneyLeft);


        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int joshMarbles= 16;
		int lostmarbles= 7;
		int marblesLeft= joshMarbles - lostmarbles;
		System.out.println("Exercise 16= "+ marblesLeft);


        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int meganSeashells= 19;
		int seashellsCollections= 25;
		int missingSeashells= seashellsCollections- meganSeashells;
		System.out.println("Exercise 17= "+ missingSeashells);


        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int bradBalloons= 17;
		int redBalloons= 8;
		int greenBalloons= bradBalloons - redBalloons;
		System.out.println("Exercise 18= "+ greenBalloons);


        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int bookOnShelf= 38;
		int extraBooks= 10;
		int allBooks= bookOnShelf + extraBooks;
		System.out.println("Exercise 19= "+ allBooks);


        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int beeLegs= 6;
		int beeHaslotsOfLegs= 6*8;
		System.out.println("Exercise 20= "+beeHaslotsOfLegs);


        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double iceCreamCone= 0.99;
		double twoIceCreamCone= 2* iceCreamCone;
		System.out.println( "Exercise 21= $"+ twoIceCreamCone);


        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int gardenBorder= 125;
		int avaRocks= 64;
		int neededRocks= gardenBorder- avaRocks;
		System.out.println("Exercise 22= "+ neededRocks );



        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int totalMarbles= 38;
		int lostMarbles= 15;
		int hiltMarbles= totalMarbles - lostMarbles;
		System.out.println("Exercise 23= "+ hiltMarbles );


        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int drivingMiles = 78;
		int gasStop= 32;
		int milesLeft= drivingMiles - gasStop;
		System.out.println("Exercise 24= "+ milesLeft);


        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int morningSnowShoveling= 90;
		int afternoonSnowShoveling= 45;
		int wastedTime= morningSnowShoveling + afternoonSnowShoveling;
		System.out.println("Exercise 24= "+ wastedTime + " min");


        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		double hotDogPrice= 0.50;
		double totalHotDogs= 6 * hotDogPrice;
		System.out.println("Exercise 26= $"+ totalHotDogs  );



        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int allMoney= 50;
		int pencilPrice= 7;
		int numberOfPencil= allMoney / pencilPrice;
		System.out.println("Exercise 27= "+ numberOfPencil);


        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int colorFullButterFlies= 33;
		int orangeButterFlies= 20;
		int redButterFlies= colorFullButterFlies - orangeButterFlies;
		System.out.println("Exercise 28= "+ redButterFlies);


        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double kateMoney= 1.00;
		double candyCost= 0.54;
		double kateChange= kateMoney- candyCost;
		System.out.printf("%.2f\n ",kateChange);


        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int markTrees= 13;
		int moreTrees= 12;
		int totalTrees= markTrees+moreTrees;
		System.out.println("Exercise 30= "+ totalTrees);


        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int waitingTime = 2;
		int timeInHours= 2*24;
		System.out.println("Exercise 31= "+ timeInHours);


        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int kimCousins= 4;
		int gums= 5;
		int gumsNeeded= kimCousins * gums;
		System.out.println("Exercise 32= "+ gumsNeeded);


        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double danMoney= 3;
		double candyMoney= 1;
		double leftoverMoney= danMoney - candyMoney;
		System.out.println("Exercise 33= $"+ leftoverMoney);


        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatNumbers= 5;
		int numberOfPeople= 3;
		int totalOfPeople= boatNumbers * numberOfPeople;
		System.out.println("Exercise 34= "+ totalOfPeople);


        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int numberOfLegos= 380;
		int legosLost= 57;
		int legosLeft= numberOfLegos - legosLost;
		System.out.println("Exercise 35= "+ legosLeft);


        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int arthurMuffins=35;
		int muffinsTotal= 83;
		int missingMuffins= muffinsTotal- arthurMuffins;
		System.out.println("Exercise 36= "+ missingMuffins);


        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayons= 1400;
		int lucyCrayons= 290;
		int willyWinners= willyCrayons - lucyCrayons;
		System.out.println("Exercise 37= "+ willyWinners);


        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int pageStickers=10;
		int numberOfPages = 22;
		int stickersTotal = pageStickers * numberOfPages ;
		System.out.println("Exercise 38= "+ stickersTotal);


        /* Exercise 39
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		double cupCakes= 96;
		double numbOfChildren= 8;
		double tooMuchCakePerChild= cupCakes/ numbOfChildren;
		System.out.println(tooMuchCakePerChild);


        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int gingerBread= 47;
		int jars= 6;
		int remainder= gingerBread % jars;
		System.out.println("Exercise 40= "+ remainder);


        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int croissants= 59;
		int neighbors= 8;
		int croissantsLeft= croissants % neighbors;
		System.out.println("Exercise 41= "+croissantsLeft);


        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int oatMeal= 12;
		int totalOat= 276;
		int trays= totalOat / oatMeal;
		System.out.println("Exercise 42= "+ trays);


        /* Exercise 43
        43. Marian???s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int pretzels= 480;
        int serving= 12;
        int numberOfServings= pretzels / serving;
		System.out.println("Exercise 43= "+ numberOfServings);


        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int lemonCakes= 53;
		int leftLemonCakes= 2;
		int totalCupCakes= lemonCakes - leftLemonCakes;
		int boxesGiven= totalCupCakes / 3;
		System.out.println("Exercise 44= "+boxesGiven);


        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotSticks= 74;
		int peopleServed= 12;
		int carrotsLeft= carrotSticks % peopleServed;
		System.out.println("Exercise 45= "+ carrotsLeft);


        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int teddyBears= 98;
		int shelvesMax= 7;
		int shelvesTotal= teddyBears / shelvesMax;
		System.out.println("Exercise 46= "+ shelvesTotal);


        /* Exercise 47
        47. Susie???s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int numOfPictures= 480;
		int pictureAlbum = 20;
        int numberOfAlbums= numOfPictures / pictureAlbum;
		System.out.println("Exercise 47= "+ numberOfAlbums);


        /* Exercise 48
        48. Joe, Susie???s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int cards= 94;
		int boxMaxiMum= 8;
				int filledBoxes= cards / boxMaxiMum ;
				int remainderCards= cards % boxMaxiMum;
		System.out.println("Exercise 48= "+ filledBoxes);
		System.out.println("number of cards in the unfilled box " + remainderCards );


        /* Exercise 49
        49. Susie???s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int fatherBooks= 210;
		int readingRoomShelvesCapacity= 10;
		int bookDisrb= fatherBooks / readingRoomShelvesCapacity;
		System.out.println("Exercise 49= "+ bookDisrb);


        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double bakedCroissants= 17.0;
		double guestNumber= 7.0;
		double guestsServed= bakedCroissants / guestNumber;
		System.out.printf("%.1f\n ", guestsServed);


	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 12 x 14 rooms?
	    Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
	    */
		double billPaintRate= 2.15;
		double jillPaintRate= 1.90;
		double roomWallFootage= 168;
		double billHourlyRate= roomWallFootage / billPaintRate;
		double jillHourlyRate= roomWallFootage / jillPaintRate;
		double requireRooms= 5;
		double totalRooms = requireRooms * roomWallFootage;

				double bothPaintersRate= billHourlyRate + jillHourlyRate;
				double ratesResults= totalRooms /bothPaintersRate;

		System.out.printf("%.2f\n ", ratesResults);




	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" ???> "Smith, John D."
	    */
		String firstName = "Grace";
		String lastName = "Hopper";
		String middleInitial = "B.";
		String fullName =  lastName + ", "+ firstName +" "+ middleInitial;
		System.out.println(fullName);



	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		int distanceBetween= 800;
		int distanceTraveled=537;
		int percentage= 100;
		int disCompleted= distanceTraveled * percentage;
		int distancePercentage= disCompleted / distanceBetween;
		System.out.println(distancePercentage);





	}

}
