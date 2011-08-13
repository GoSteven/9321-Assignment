-- phpMyAdmin SQL Dump
-- version 3.3.10
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 31, 2011 at 01:48 AM
-- Server version: 5.5.11
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `MM_Movie`
--

-- --------------------------------------------------------

--
-- Table structure for table `Booking`
--

DROP TABLE IF EXISTS `Booking`;
CREATE TABLE IF NOT EXISTS `Booking` (
  `BookingId` varchar(250) NOT NULL,
  `UserId` varchar(250) NOT NULL,
  `ShowTimeId` varchar(250) NOT NULL,
  `NumOfTicket` int(32) NOT NULL DEFAULT '1',
  PRIMARY KEY (`BookingId`),
  KEY `UserId` (`UserId`),
  KEY `ShowTimeId` (`ShowTimeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Booking`
--


-- --------------------------------------------------------

--
-- Table structure for table `Cinema`
--

DROP TABLE IF EXISTS `Cinema`;
CREATE TABLE IF NOT EXISTS `Cinema` (
  `CinemaId` varchar(250) NOT NULL,
  `CinemaName` varchar(500) NOT NULL,
  `Location` varchar(500) NOT NULL,
  `SeatingCapacity` int(11) NOT NULL,
  `Amenities` int(11) NOT NULL,
  PRIMARY KEY (`CinemaId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Cinema`
--

INSERT INTO `Cinema` (`CinemaId`, `CinemaName`, `Location`, `SeatingCapacity`, `Amenities`) VALUES
('38F25AC6-CFC8-BF3B-70F9-E9372F2693D4', 'Event-Burbood', 'Burbood', 40, 7),
('68D73B31-1EF5-E65B-0CA0-D53498F462E6', 'Event', 'Town Hall', 100, 3),
('EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', 'Event-BondiJunction', 'Bondi Junction', 200, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Comment`
--

DROP TABLE IF EXISTS `Comment`;
CREATE TABLE IF NOT EXISTS `Comment` (
  `CommentId` varchar(250) NOT NULL,
  `MovieId` varchar(250) NOT NULL,
  `UserId` varchar(250) NOT NULL,
  `Rating` int(32) NOT NULL,
  `CommentContent` varchar(1000) NOT NULL,
  `CommentTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`CommentId`),
  KEY `MovieId` (`MovieId`),
  KEY `UserId` (`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Comment`
--

INSERT INTO `Comment` (`CommentId`, `MovieId`, `UserId`, `Rating`, `CommentContent`, `CommentTime`) VALUES
('31AD8555-E4D2-19FF-4805-78E6DC38D68F', '987873AD-0EE2-D42F-906E-4227646BB23C', 'B85AD097-6437-4D70-E825-F3774896DAB2', 0, 'HaHa', '2011-05-08 02:07:33'),
('4DF84DD7-160C-2CA6-2033-881668734D31', '987873AD-0EE2-D42F-906E-4227646BB23C', 'B85AD097-6437-4D70-E825-F3774896DAB2', 2, 'HHhhH', '2011-05-08 01:43:35'),
('706872D7-772D-52E5-0299-02E0B5B968E6', '6DD8C5EF-8E78-917C-A39F-67564C9F8005', '2C168FB2-537F-FE63-751E-72E1D9DFB349', 2, 'like it', '2011-05-09 20:53:15'),
('908E27C4-4748-2121-DF38-6ABF7B281F59', '987873AD-0EE2-D42F-906E-4227646BB23C', 'B85AD097-6437-4D70-E825-F3774896DAB2', 2, 'HHhhH', '2011-05-08 01:42:19'),
('9CDE2625-1903-5747-8EBA-20FBA6AD33CC', '6DD8C5EF-8E78-917C-A39F-67564C9F8005', '2C168FB2-537F-FE63-751E-72E1D9DFB349', 2, 'This is a good movie!!!', '2011-05-08 21:09:03'),
('AAEE1F31-78F3-CDF2-6FE0-5F0BB70DF34E', '987873AD-0EE2-D42F-906E-4227646BB23C', 'B85AD097-6437-4D70-E825-F3774896DAB2', 2, 'HHhhH', '2011-05-08 01:29:59');

-- --------------------------------------------------------

--
-- Table structure for table `FriendInvitation`
--

DROP TABLE IF EXISTS `FriendInvitation`;
CREATE TABLE IF NOT EXISTS `FriendInvitation` (
  `InvitationId` varchar(250) NOT NULL,
  `ToUser` varchar(250) NOT NULL,
  `FromUser` varchar(250) NOT NULL,
  `Message` varchar(500) DEFAULT NULL,
  `IsConfirmed` tinyint(1) NOT NULL,
  PRIMARY KEY (`InvitationId`),
  KEY `ToUser` (`ToUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `FriendInvitation`
--

INSERT INTO `FriendInvitation` (`InvitationId`, `ToUser`, `FromUser`, `Message`, `IsConfirmed`) VALUES
('0BA3BD84-C45B-62E1-C619-BC847EE9C03C', '6D83531E-3563-CA8C-EFC3-BF51C20709B1', '2C168FB2-537F-FE63-751E-72E1D9DFB349', 'pls', 1),
('18D977D9-F12F-E46F-2232-947CF58D1F3D', '2C168FB2-537F-FE63-751E-72E1D9DFB349', '8E976A10-6AA2-7765-9B82-B671018C8C57', 'hi', 1),
('3F7A847A-D2DD-1E83-30C9-DB03934DEEC4', '8E976A10-6AA2-7765-9B82-B671018C8C57', '2C168FB2-537F-FE63-751E-72E1D9DFB349', 'kokokoo', 1),
('5DF63AEC-DB6D-661A-48A5-52AB7B782F56', '6D83531E-3563-CA8C-EFC3-BF51C20709B1', '8E976A10-6AA2-7765-9B82-B671018C8C57', 'pls be my friend', 1),
('86A37C4A-CF0C-A66D-5859-48D8D2A68803', '8E976A10-6AA2-7765-9B82-B671018C8C57', '2C168FB2-537F-FE63-751E-72E1D9DFB349', 'be my ', 1),
('919F3E5F-E971-082F-7955-9F8304B8E9D0', '2C168FB2-537F-FE63-751E-72E1D9DFB349', '8E976A10-6AA2-7765-9B82-B671018C8C57', 'hi', 1),
('D437F5B3-5F76-28A0-64A8-21AD4C981CF9', '8E976A10-6AA2-7765-9B82-B671018C8C57', '2C168FB2-537F-FE63-751E-72E1D9DFB349', 'dodododdodo', 1),
('F8B37F70-6242-4A8C-95ED-80D90ACD4CE2', '2C168FB2-537F-FE63-751E-72E1D9DFB349', '6D83531E-3563-CA8C-EFC3-BF51C20709B1', 'Hi, pls be my friend', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Friends`
--

DROP TABLE IF EXISTS `Friends`;
CREATE TABLE IF NOT EXISTS `Friends` (
  `FriendsID` varchar(250) NOT NULL,
  `UserA` varchar(250) NOT NULL,
  `UserB` varchar(250) NOT NULL,
  PRIMARY KEY (`FriendsID`),
  KEY `UserA` (`UserA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Friends`
--

INSERT INTO `Friends` (`FriendsID`, `UserA`, `UserB`) VALUES
('D2E6DDF1-77FF-F279-C92B-C2FC7381F76E', '2C168FB2-537F-FE63-751E-72E1D9DFB349', '8E976A10-6AA2-7765-9B82-B671018C8C57');

-- --------------------------------------------------------

--
-- Table structure for table `Movies`
--

DROP TABLE IF EXISTS `Movies`;
CREATE TABLE IF NOT EXISTS `Movies` (
  `MovieID` varchar(250) NOT NULL,
  `MovieTitle` varchar(500) NOT NULL,
  `Poster` varchar(500) DEFAULT NULL,
  `YoutubeLink` varchar(1000) DEFAULT NULL,
  `Actors` varchar(500) DEFAULT NULL,
  `Genre` int(32) DEFAULT NULL,
  `Director` varchar(500) DEFAULT NULL,
  `ShortSynopsis` varchar(500) DEFAULT NULL,
  `AgeRating` int(32) DEFAULT NULL,
  `ReleaseDate` date DEFAULT NULL,
  `ExpireDate` date DEFAULT NULL,
  PRIMARY KEY (`MovieID`),
  KEY `ReleaseDate` (`ReleaseDate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Movies`
--

INSERT INTO `Movies` (`MovieID`, `MovieTitle`, `Poster`, `YoutubeLink`, `Actors`, `Genre`, `Director`, `ShortSynopsis`, `AgeRating`, `ReleaseDate`, `ExpireDate`) VALUES
('093C0B41-19B8-88D5-5C33-3284A612F469', 'Dharti', '1304936478859Dharti.jpg', 'Dharti is family drama set in Punjab on the backdrop of Punjab Politics. Prem Chopra plays the character of Baljit Singh Wadala, the head of ruling party in Punjab and he has two sons. The elder son Vikramjit Singh Wadala played by Randeep Arya is following his father''s footsteps and is a prominent Political leader, while the younger son Jasdeep Singh Wadala played by Jimmy Sheirgill is a Squadron Leader in the Indian Air Force.', 'Jimmy Dhergil', 2, 'Eros', '&lt;iframe width="560" height="349" src="http://www.youtube.com/embed/uMnEduDrWAM" frameborder="0" allowfullscreen&gt;&lt;/iframe&gt;', 4, '2011-05-12', '2011-05-31'),
('2451C98B-8F87-F8D3-7D39-BB220BB42D7B', 'thor', '1304939401748thor.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/JOddp-nlNvQ" frameborder="0" allowfullscreen></iframe>', 'Chris Hemsworth, Anthony Hopkins', 520, 'Kenneth Branagh', 'Thor is a powerful but arrogant warrior from another world whose reckless actions reignite an ancient war. He is cast down to Earth and forced to live among humans as punishment. Once here, Thor learns what it takes to be a true hero when the most dangerous villain of his world sends the darkest forces of Asgard to invade Earth.', 4, '2011-06-12', '2011-06-30'),
('2686E2E9-2D76-A24A-F651-09CF9E0A3010', 'inside job', '1304937794615insidejob.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/pZm7M1vn15w" frameborder="0" allowfullscreen></iframe>', 'Matt Damon, William Ackman', 182, 'Charles Ferguson', 'From Academy AwardÆ nominated filmmaker, Charles Ferguson (ìNo End In Sightî), comes INSIDE JOB, the first film to expose the shocking truth behind the economic crisis of 2008. The global financial meltdown, at a cost of over $20 trillion, resulted in millions of people losing their homes and jobs.', 4, '2011-06-01', '2011-06-30'),
('3CA85282-488C-288B-2C35-A668C33C3E64', 'Source Code', '1304939730932sourcecode.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/_3QkJ_a1nlw" frameborder="0" allowfullscreen></iframe>', 'Jake Gyllenhaal, Michelle Monaghan', 2, 'Duncan Jones', 'When decorated soldier Captain Colter Stevens (Jake Gyllenhaal) wakes up in the body of an unknown man, he discovers he''s part of a mission to find the bomber of a Chicago commuter train. In an assignment unlike any he''s ever known, he learns he''s part of a government experiment called the "Source Code," a program that enables him to cross over into another man''s identity in the last 8 minutes of his life.', 2, '2011-06-18', '2011-07-17'),
('3D41CC2C-6EB2-C95F-410C-899DA86A2371', 'just go with it', '1304938810729justgowithit.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/Jz5Ubqhru7g" frameborder="0" allowfullscreen></iframe>', 'Adam Sandler, Jennifer Aniston', 102, 'Dennis Dugan', 'In Just Go With It, a plastic surgeon, romancing a much younger schoolteacher, enlists his loyal assistant to pretend to be his soon to be ex-wife, in order to cover up a careless lie. When more lies backfire, the assistant''s kids become involved, and everyone heads off for a weekend in Hawaii that will change all their lives.', 4, '2011-06-08', '2011-06-30'),
('41D40658-3EA0-C37E-30A4-6E8A351D26E5', 'The whole', '1304937794615insidejob.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/JOddp-nlNvQ" frameborder="0" allowfullscreen></iframe> ', 'ads', 108, 'Harry', 'sAssdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd', 1, '2011-05-28', '2011-05-31'),
('4C0AFE64-650C-8131-D9E3-F7298AF358F7', 'Limitless', '1304938696235limitless.jpg', '<iframe width="425" height="349" src="http://www.youtube.com/embed/THE_hhk1Gzc" frameborder="0" allowfullscreen></iframe>', 'Bradley Cooper, Robert De Niro, Abbie Cornish, Anna Friel', 102, 'Neil Burger', 'Based on the novel by Alan Glynn, ìLimitlessî is an exciting ìWhat if?î story that unveils a designer drug that could make you rich and powerful. Eddie (Bradley Cooper) is a down and out New York writer until he comes to possess a pill that gives him the ability to access the full capacity of his brain. Soon Eddie realizes the use of his newfound superior intelligence and success comes at a heavy price as mysterious antagonists pursue him and dangers of the amazing new drug are revealed.', 4, '2011-06-03', '2011-06-30'),
('4D45650C-B521-D3B2-856B-D6F22BC5337D', 'Justin bieber - Never Say Never', '1304940024526JS-neversaynever.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/COJCN3Mhr14" frameborder="0" allowfullscreen></iframe>', 'Justin Bieber', 102, 'Jon Chu', 'Biopic featuring special concert footage\r\nThe exhilarating story of an everyday kid''s struggle to realize his dreams, Never Say Never gives an intimate and exclusive behind-the-scenes look at Justin Bieber''s fascinating rise to fame thanks to the love, support and collaboration of a new generation of fans.', 1, '2011-05-21', '2011-06-30'),
('6DD8C5EF-8E78-917C-A39F-67564C9F8005', '3d - Hoodwinked Too: Hood Vs Evil', '13048509685673d - Hoodwinked Too: Hood Vs Evil.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/hvLpPJs15rU" frameborder="0" allowfullscreen></iframe>', 'Glenn Close, Cheech &amp; Chong, Bill Hader', 22, 'Mike Disa', 'From the team that brought you HOODWINKED, the comedic portrayal of the fairy tale Red Riding Hood, comes the all-new animated family comedy HOODWINKED TOO! HOOD VS. EVIL in 3D. The sequel finds our heroine, Red (Hayden Panettiere), training with a mysterious covert group called the Sisters of the Hood.', 1, '2011-05-09', '2012-05-17'),
('73826263-45AD-68C4-CB8D-78EF64E9F4BE', 'Another Year', '1304851248681Another Year.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/yypx-Tz8NzU" frameborder="0" allowfullscreen></iframe>', 'Jim Broadbent , Lesley Manville', 134, 'Mike Leigh', 'Married couple Gerri (Ruth Sheen) and Tom (Jim Broadbent) have managed to remain blissfully happy into their autumn years. ANOTHER YEAR takes an in-depth look at their lives over the course of one average set of seasons ñ from the highs and lows of their friends (Lesley Manville and Peter Wight), to their own familyís ups and downs.', 1, '2011-05-09', '2012-05-18'),
('7485CE5F-3E06-5FD7-4573-CAD26977A23B', 'hop', '1304937430275hop.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/HExP4izD358" frameborder="0" allowfullscreen></iframe>', 'Russell Brand, James Marsden', 0, 'Tim Hill', 'Blending state of the art animation with live action, Hop is a comedy about E.B. (voiced by Russell Brand), the teenage son of the Easter Bunny. On the eve of taking over the family business, E.B. leaves for Hollywood in pursuit of his dream of becoming a drummer. He encounters Fred (James Marsden).', 1, '2011-05-26', '2011-06-30'),
('821F85C4-9AD3-5E25-04CB-88EA45FEAD95', 'High Society', '1304937336972highsociety.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/tBnUtmplc7w" frameborder="0" allowfullscreen></iframe>', 'Bing Crosby, Grace Kelly', 289, 'Charles Walters', 'C.K. Dexter-Haven, a successful popular jazz musician, lives in a mansion near his ex-wife''s Tracy Lord''s family estate. She is on the verge of marrying a man blander and safer than Dex, who tries to win Tracy''s heart again. Mike Connor, an undercover tabloid reporter, also falls for Tracy while covering the nuptials for Spy magazine. Tracy must choose between the three men as she discovers that "safe" can mean "deadly dull" when it comes to husbands and life.', 2, '2011-05-27', '2011-06-30'),
('829347A6-2188-A9DD-02AC-40C825FB53F2', 'never let me go', '1304936609579neverletmego.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/EUPsKjdtQSM" frameborder="0" allowfullscreen></iframe>', 'Keira Knightley, Carey Mulligan, Andrew Garfield', 0, 'Mark Romanek', 'In his highly acclaimed novel Never Let Me Go, Kazuo Ishiguro (The Remains of the Day) created a remarkable story of love, loss and hidden truths. In it he posed the fundamental question: What makes us human? Now, director Mark Romanek (ONE HOUR PHOTO), writer Alex Garland and DNA Films, bring Ishiguro''s hauntingly poignant and emotional story to the screen.', 4, '2011-05-12', '2011-05-31'),
('91825483-301C-ABF5-8B60-8803CA37B30E', 'Water For Elephants', '1304939582687waterforelephants.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/OOPHFQZ5aiM" frameborder="0" allowfullscreen></iframe>', 'Reese Witherspoon, Robert Pattinson', 146, 'Francis Lawrence', 'During the Great Depression, Jacob, a penniless 23-year-old veterinary school student, parlays his expertise with animals into a job with a second-rate traveling circus. He falls in love with Marlena, one of the show''s star performers, but their romance is complicated by Marlena''s husband, the charismatic but unbalanced circus boss.', 4, '2011-06-03', '2011-06-30'),
('B5B72909-23A5-E299-62A5-EC770DDB6444', 'paul', '1304938891637paul.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/KdHUQtnJsyQ" frameborder="0" allowfullscreen></iframe>', 'Nick Frost, Simon Pegg, Seth Rogen, Jane Lynch', 11, 'Greg Mottola', 'Simon Pegg and Nick Frost (Hot Fuzz, Shaun of the Dead) reunite for the comedy adventure Paul as two sci-fi geeks whose pilgrimage takes them to Americaís UFO heartland. While there, they accidentally meet an alien who brings them on an insane road trip that alters their universe forever.', 8, '2011-06-09', '2011-06-30'),
('BDF28154-D726-96D4-80DC-DB9C7B91F07F', 'diary Of A Wimpy Kid 2: Rodrick Rules', '1304937209168Diraryofawimpykid2.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/ZbqqYuG1TCM" frameborder="0" allowfullscreen></iframe>', 'Zachary Gordon, Devon Bostick', 0, 'David Bowers', 'Greg Heffley, the kid who made ìwimpyî cool, is back in an all-new family comedy based on the best-selling illustrated novel by Jeff Kinney, one of a series that has thus far sold 28 million books. As he begins seventh grade, Greg tries to score points with a pretty new girl in school while honoring his momís request to spend quality time with his older brother ñ and chief tormentor -- Rodrick.', 1, '2011-05-18', '2011-05-31'),
('C5E236DC-E239-74FE-FCE6-A65F644AF958', 'rio', '1304939305907rio.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/d1PokzTa9Yo" frameborder="0" allowfullscreen></iframe>', 'Jesse Eisenberg, Anne Hathaway', 100, 'Carlos Saldanha', 'RIO is a 3-D animation feature from the makers of the ìIce Ageî films. Set in the magnificent city of Rio de Janeiro and the lush rainforest of Brazil, the comedy-adventure centers on Blu, a rare macaw who thinks he is the last of his kind. When Blu discovers thereís another ñ and that sheís a she ñ he leaves the comforts of his cage in small town Minnesota and heads to Rio.', 1, '2011-05-23', '2011-06-30'),
('CEDE9613-B308-27BD-870D-5B9726CD25CE', 'babies', '1304936329725Babies.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/QkytlvAEE2k" frameborder="0" allowfullscreen></iframe>', 'Bayar, Hattie, Mari', 36, 'Thomas BalmËs', 'The adventure of a lifetime beginsÖ with BABIES.\r\nDirected by award-winning filmmaker Thomas BalmËs, from an original idea by producer Alain Chabat, this visually stunning film follows four babies during their first year on earth ó from first breath to first steps.', 1, '2011-05-12', '2011-05-31'),
('D06EADEE-F8C7-1D86-A417-5C4B9C7A654C', 'rango', '1304938988238rango.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/k-OOfW6wWyQ" frameborder="0" allowfullscreen></iframe>', 'Johnny Depp, Timothy Olyphant', 22, 'Gore Verbinski', 'Rango is the story of a lonely chameleon who can play any role, yet doesnít know who he is. His journey takes him from the solitude of a terrarium to the vastness of the Mojave desert where he adopts the persona of vigilante lawman Rango, convincing the occupants of the town of Dirt that he is the solution to their looming hydration problem.', 1, '2011-06-17', '2011-06-30'),
('EBB9938D-96ED-C90B-737C-D09FD1D692A4', 'scream 4', '1304936948538scream4.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/D5TsZ6iyaH4" frameborder="0" allowfullscreen></iframe>', 'Courteney Cox , Neve Campbell', 2, 'Wes Craven', 'The fourth instalment in the popular Scream film series. Ten years have passed, and Sidney Prescott (Neve Campbell), who has put herself back together thanks in part to her writing, is visited by the Ghostface Killer.', 8, '2011-05-14', '2011-05-31'),
('FD773565-99F6-F8BA-B385-145095A28C1B', 'Certified Copy - Travelling Film Festival', '1304851386413Certified Copy - Travelling Film Festival.jpg', '<iframe width="560" height="349" src="http://www.youtube.com/embed/w4nWgtXB51o" frameborder="0" allowfullscreen></iframe>', 'Juliette Binoche, William Shimell and Jean-Claude CarriËre', 2, 'Abbas Kiarostami', 'A sensation at the 2010 Cannes Film Festival, where Juliette Binoche won the Best Actress award, CERTIFIED COPY is the latest masterpiece from acclaimed filmmaker Abbas Kiarostami (TEN, TASTE OF CHERRY). Academy Award-winner Juliette Binoche stars as an antique dealer,', 1, '2011-05-09', '2012-05-26');

-- --------------------------------------------------------

--
-- Table structure for table `RecommendMovie`
--

DROP TABLE IF EXISTS `RecommendMovie`;
CREATE TABLE IF NOT EXISTS `RecommendMovie` (
  `RecommendID` varchar(250) NOT NULL,
  `ToUser` varchar(250) NOT NULL,
  `FromUser` varchar(250) NOT NULL,
  `MovieID` varchar(250) NOT NULL,
  `IsReaded` tinyint(1) NOT NULL,
  PRIMARY KEY (`RecommendID`),
  KEY `ToUser` (`ToUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `RecommendMovie`
--

INSERT INTO `RecommendMovie` (`RecommendID`, `ToUser`, `FromUser`, `MovieID`, `IsReaded`) VALUES
('21336964-56F1-7C62-55D9-BEBD7AB68825', '6D83531E-3563-CA8C-EFC3-BF51C20709B1', '2C168FB2-537F-FE63-751E-72E1D9DFB349', '093C0B41-19B8-88D5-5C33-3284A612F469', 1),
('373C644E-47BD-4E7B-5748-C1432E8746DC', '2C168FB2-537F-FE63-751E-72E1D9DFB349', '8E976A10-6AA2-7765-9B82-B671018C8C57', '093C0B41-19B8-88D5-5C33-3284A612F469', 1),
('4D4D6E4A-20CC-6402-FBBB-264F3DDB0F60', '2C168FB2-537F-FE63-751E-72E1D9DFB349', '8E976A10-6AA2-7765-9B82-B671018C8C57', '2686E2E9-2D76-A24A-F651-09CF9E0A3010', 1),
('4E42720B-CC66-8FD2-1452-F22FC3652181', '2C168FB2-537F-FE63-751E-72E1D9DFB349', '8E976A10-6AA2-7765-9B82-B671018C8C57', '4D45650C-B521-D3B2-856B-D6F22BC5337D', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
CREATE TABLE IF NOT EXISTS `Role` (
  `RoleId` varchar(250) NOT NULL,
  `RoleName` varchar(500) NOT NULL,
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` (`RoleId`, `RoleName`) VALUES
('0', 'Viewer'),
('1', 'Owner');

-- --------------------------------------------------------

--
-- Table structure for table `Showtime`
--

DROP TABLE IF EXISTS `Showtime`;
CREATE TABLE IF NOT EXISTS `Showtime` (
  `ShowtimeId` varchar(250) NOT NULL,
  `CinemaId` varchar(250) NOT NULL,
  `MovieId` varchar(250) NOT NULL,
  `Showtime` datetime NOT NULL,
  `Price` double NOT NULL,
  PRIMARY KEY (`ShowtimeId`),
  KEY `CinemaId` (`CinemaId`),
  KEY `MovieId` (`MovieId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Showtime`
--

INSERT INTO `Showtime` (`ShowtimeId`, `CinemaId`, `MovieId`, `Showtime`, `Price`) VALUES
('101EBFFC-CA44-30A9-CF9F-C917A95EAEA1', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '4C0AFE64-650C-8131-D9E3-F7298AF358F7', '2011-07-08 13:00:00', 20),
('1DE0E83E-28D2-74FD-851F-862C43BB908A', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '91825483-301C-ABF5-8B60-8803CA37B30E', '2011-07-08 13:00:00', 20),
('2DCA4F96-FB49-FDB3-E298-1A1A38F72C8C', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '4D45650C-B521-D3B2-856B-D6F22BC5337D', '2011-07-08 13:00:00', 20),
('2E2A9943-D0CF-FCF8-6471-28EAADB0B4A2', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '2451C98B-8F87-F8D3-7D39-BB220BB42D7B', '2011-07-08 13:00:00', 20),
('2EC87278-E749-E87E-2317-24B323D7545D', '38F25AC6-CFC8-BF3B-70F9-E9372F2693D4', '6DD8C5EF-8E78-917C-A39F-67564C9F8005', '2011-05-12 10:00:00', 20),
('3041E275-757A-F107-49B7-368C41527A32', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '093C0B41-19B8-88D5-5C33-3284A612F469', '2011-06-02 17:00:00', 20),
('35B5F003-545F-56DB-B8B1-52AF3F05E1DB', '68D73B31-1EF5-E65B-0CA0-D53498F462E6', 'A369A889-E233-9D35-62C2-F7E365A6E268', '2011-10-10 13:21:00', 20),
('3BC45477-9A85-AEC6-82FA-5AD95307072B', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '3D41CC2C-6EB2-C95F-410C-899DA86A2371', '2011-07-08 13:00:00', 20),
('3DE2997F-E080-CF6C-D60B-B170018F6DC9', '68D73B31-1EF5-E65B-0CA0-D53498F462E6', 'A369A889-E233-9D35-62C2-F7E365A6E268', '2012-09-10 13:10:00', 20),
('4189D11A-0D07-93B8-CF09-8C6DAF18D185', '68D73B31-1EF5-E65B-0CA0-D53498F462E6', '41D40658-3EA0-C37E-30A4-6E8A351D26E5', '2011-05-31 09:10:00', 56),
('5420A3A1-F330-F9EA-744F-04CC8C2C2185', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '3CA85282-488C-288B-2C35-A668C33C3E64', '2011-07-08 13:00:00', 20),
('6227E7D6-937F-7ED7-781A-06811F0D47A2', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '2686E2E9-2D76-A24A-F651-09CF9E0A3010', '2011-07-08 13:00:00', 20),
('66C54168-3D15-96DA-F03C-78B3137AFD70', '38F25AC6-CFC8-BF3B-70F9-E9372F2693D4', '2686E2E9-2D76-A24A-F651-09CF9E0A3010', '2011-06-05 13:00:00', 30),
('6B5F8848-56C5-EBE9-9C7B-267FF6A8A03E', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '829347A6-2188-A9DD-02AC-40C825FB53F2', '2011-07-08 13:00:00', 20),
('7C06C342-6F10-6E9A-1F61-ECD29B33CF8C', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '7485CE5F-3E06-5FD7-4573-CAD26977A23B', '2011-07-08 13:00:00', 20),
('7EBC2C48-C4B4-A342-27F8-AE5A53561417', '38F25AC6-CFC8-BF3B-70F9-E9372F2693D4', '4D45650C-B521-D3B2-856B-D6F22BC5337D', '2011-06-05 13:00:00', 30),
('933480AB-0147-EDBF-10D4-C95045DBFF87', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '821F85C4-9AD3-5E25-04CB-88EA45FEAD95', '2011-07-08 13:00:00', 20),
('946788FA-FEC3-D748-4889-1B11A77D6C1A', '68D73B31-1EF5-E65B-0CA0-D53498F462E6', '987873AD-0EE2-D42F-906E-4227646BB23C', '2011-10-10 13:21:00', 20),
('9E427918-763D-EE6D-24C7-0C3F46BCFE64', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '093C0B41-19B8-88D5-5C33-3284A612F469', '2011-07-08 13:00:00', 20),
('B0AC002C-9B9B-681D-E73F-62740C2B2A86', '68D73B31-1EF5-E65B-0CA0-D53498F462E6', '6DD8C5EF-8E78-917C-A39F-67564C9F8005', '2011-05-12 10:00:00', 20),
('B7BE6449-A545-2F5A-A43F-D7EED08F8C96', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '6DD8C5EF-8E78-917C-A39F-67564C9F8005', '2011-05-12 10:00:00', 20),
('C6D67EC9-9BC6-7F03-C9C2-08582C73C663', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', 'EBB9938D-96ED-C90B-737C-D09FD1D692A4', '2011-07-08 13:00:00', 20),
('CFE5E6E3-EA5B-169E-67EA-922BDCCFDC40', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', 'BDF28154-D726-96D4-80DC-DB9C7B91F07F', '2011-07-08 13:00:00', 20),
('D4F9ED29-8D45-3D98-D7AF-D5301FD90044', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', 'D06EADEE-F8C7-1D86-A417-5C4B9C7A654C', '2011-07-08 13:00:00', 20),
('DE20A511-8913-6903-4544-C6AC8444B89E', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', 'C5E236DC-E239-74FE-FCE6-A65F644AF958', '2011-07-08 13:00:00', 20),
('ED754389-A8DC-C035-6CCB-D53650E69E0E', '68D73B31-1EF5-E65B-0CA0-D53498F462E6', '987873AD-0EE2-D42F-906E-4227646BB23C', '2012-09-10 13:10:00', 20),
('F32B3D71-94B2-3EDF-3242-ABB6CC8BE5CC', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', '41D40658-3EA0-C37E-30A4-6E8A351D26E5', '2011-07-08 13:00:00', 20),
('FA0FE1BC-A9A7-D684-CED6-1A0D69674C83', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', 'B5B72909-23A5-E299-62A5-EC770DDB6444', '2011-07-08 13:00:00', 20),
('FF8A36A4-99DE-4D3C-F82B-E9FCF15B4155', 'EA226BEB-B3D9-A591-CD60-7E1A4A387ABF', 'CEDE9613-B308-27BD-870D-5B9726CD25CE', '2011-07-08 13:00:00', 20);

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
  `UserId` varchar(250) NOT NULL,
  `UserName` varchar(500) NOT NULL,
  `Password` varchar(500) NOT NULL,
  `EmailAddress` varchar(500) NOT NULL,
  `NickName` varchar(500) DEFAULT NULL,
  `FirstName` varchar(500) DEFAULT NULL,
  `IsFirstNamePublic` tinyint(1) NOT NULL DEFAULT '0',
  `LastName` varchar(500) DEFAULT NULL,
  `IsLastNamePublic` tinyint(1) NOT NULL DEFAULT '0',
  `YearOfBirth` varchar(500) DEFAULT NULL,
  `IsYearOfBirthPublic` tinyint(1) NOT NULL DEFAULT '0',
  `FavGenre` int(32) DEFAULT NULL,
  `IsFavGenrePublic` tinyint(1) NOT NULL DEFAULT '0',
  `FavActors` varchar(500) DEFAULT NULL,
  `IsFavActorsPublic` tinyint(1) NOT NULL DEFAULT '0',
  `RoleId` varchar(250) DEFAULT '0',
  `isVaildate` tinyint(1) NOT NULL DEFAULT '0',
  `IsCompletePrivate` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `UserName` (`UserName`),
  UNIQUE KEY `EmailAddress` (`EmailAddress`),
  KEY `RoleId` (`RoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`UserId`, `UserName`, `Password`, `EmailAddress`, `NickName`, `FirstName`, `IsFirstNamePublic`, `LastName`, `IsLastNamePublic`, `YearOfBirth`, `IsYearOfBirthPublic`, `FavGenre`, `IsFavGenrePublic`, `FavActors`, `IsFavActorsPublic`, `RoleId`, `isVaildate`, `IsCompletePrivate`) VALUES
('2C168FB2-537F-FE63-751E-72E1D9DFB349', 'steven', 'b3cd915d758008bd19d0f2428fbb354a', 'yousilin+12312@gmail.com', 'steve', 'steven', 1, 'you', 1, '1988', 1, 8, 1, 'tom', 1, '0', 1, 0),
('5626546A-4F20-448E-6015-F6490B6A547A', 'zz', '25ed1bcb423b0b7200f485fc5ff71c8e', 'mendymeng.1206@gmail.com', '', '', 0, '', 0, '', 0, NULL, 0, '', 0, NULL, 0, 0),
('615468FB-45B5-9350-8BD3-C75B7AF2BDA3', 'mmen387', '1d788473204d1a53d260a1af81ab12de', 'mendymeng.1206+3@gmail.com', 'mm', 'meng', 0, 'meng', 0, '1989', 0, 4, 0, 'Justin Bieber', 0, '0', 1, 0),
('6382857C-0933-67E7-A13E-9278EBFC911C', 'aa', '4124bc0a9335c27f086f24ba207a4912', 'mendymeng.1206+2@gmail.com', '', '', 0, '', 0, '', 0, NULL, 0, '', 0, NULL, 0, 0),
('6D83531E-3563-CA8C-EFC3-BF51C20709B1', 'bar', 'e10adc3949ba59abbe56e057f20f883e', 'yousilin+bar@gmail.com', 'ar', 'bar', 0, 'foo', 0, '1988', 0, 8, 0, '123', 0, '0', 1, 0),
('8E976A10-6AA2-7765-9B82-B671018C8C57', 'foo', 'b3cd915d758008bd19d0f2428fbb354a', 'yousilin+foo@gmail.com', 'foo', 'foo', 1, 'you', 1, '1988', 0, 0, 1, 'looo', 1, '0', 1, 0),
('B85AD097-6437-4D70-E825-F3774896DAB2', 'admin', 'b3cd915d758008bd19d0f2428fbb354a', 'yousilin@gmail.com', '', '', 0, '', 0, '', 0, NULL, 0, '', 0, '1', 1, 0);
