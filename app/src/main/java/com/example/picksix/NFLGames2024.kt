package com.example.picksix

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.serialization.Serializable

data class Week(
    val week: Int,
    val period: String
)

val weekList = listOf(
    Week(week = 1, period = "Sep 5 - 9"),
    Week(week = 2, period = "Sep 12 - 16"),
    Week(week = 3, period = "Sep 19 - 23"),
    Week(week = 4, period = "Sep 26 - 30"),
    Week(week = 5, period = "Oct 3 - 7"),
    Week(week = 6, period = "Oct 10 - 14"),
    Week(week = 7, period = "Oct 17 - 21"),
    Week(week = 8, period = "Oct 24 - 28"),
    Week(week = 9, period = "Oct 31 - Nov 4"),
    Week(week = 10, period = "Nov 7 - 11"),
    Week(week = 11, period = "Nov 14 - 18"),
    Week(week = 12, period = "Nov 21 - 25"),
    Week(week = 13, period = "Nov 28 - Dec 2"),
    Week(week = 14, period = "Dec 5 - 9"),
    Week(week = 15, period = "Dec 12 - 16"),
    Week(week = 16, period = "Dec 19 - 23"),
    Week(week = 17, period = "Dec 25 - 30"),
    Week(week = 18, period = "Jan 4 - 5"),
)


data class Game(
    val gameDate: String,
    val homeTeam: NFLTeams,
    val awayTeam: NFLTeams,
    var isHomeTeamClicked: MutableState<Boolean?> = mutableStateOf(null)
)

val gamesWeek1 = listOf(
    Game(
        "FRI 9/6 • LOCKS @ 9:20 AM",
        ravens,
        chiefs
    ),
    Game(
        "SAT 9/7 • LOCKS @ 9:15 AM",
        packers,
        eagles
    ),
    Game(
        "MON 9/9 • LOCKS @ 2:00 AM",
        steelers,
        falcons
    ),
    Game(
        "MON 9/9 • LOCKS @ 2:00 AM",
        cardinals,
        bills
    ),
    Game(
        "MON 9/9 • LOCKS @ 2:00 AM",
        titans,
        bears
    ),
    Game(
        "MON 9/9 • LOCKS @ 2:00 AM",
        patriots,
        bengals
    ),
    Game(
        "MON 9/9 • LOCKS @ 2:00 AM",
        texans,
        colts
    ),
    Game(
        "MON 9/9 • LOCKS @ 2:00 AM",
        jaguars,
        dolphins
    ),
    Game(
        "MON 9/9 • LOCKS @ 2:00 AM",
        panthers,
        saints
    ),
    Game(
        "MON 9/9 • LOCKS @ 2:00 AM",
        vikings,
        giants
    ),
    Game(
        "MON 9/9 • LOCKS @ 5:05 AM",
        raiders,
        chargers
    ),
    Game(
        "MON 9/9 • LOCKS @ 5:05 AM",
        broncos,
        seahawks
    ),
    Game(
        "MON 9/9 • LOCKS @ 5:25 AM",
        cowboys,
        browns
    ),
    Game(
        "MON 9/9 • LOCKS @ 5:25 AM",
        commanders,
        buccaneers
    ),
    Game(
        "MON 9/9 • LOCKS @ 9:20 AM",
        rams,
        lions
    ),
    Game(
        "TUE 9/10 • LOCKS @ 9:20 AM",
        jets,
        niners
    ),
)

val gamesWeek2 = listOf(
    Game(
        "FRI 9/13 • LOCKS @ 9:15 AM",
        bills,
        dolphins
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        saints,
        cowboys
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        raiders,
        ravens
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        chargers,
        panthers
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        buccaneers,
        lions
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        colts,
        packers
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        browns,
        jaguars
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        niners,
        vikings
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        seahawks,
        patriots
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        jets,
        titans
    ),
    Game(
        "MON 9/16 • LOCKS @ 2:00 AM",
        giants,
        commanders
    ),
    Game(
        "MON 9/16 • LOCKS @ 5:05 AM",
        rams,
        cardinals
    ),
    Game(
        "MON 9/16 • LOCKS @ 5:25 AM",
        steelers,
        broncos
    ),
    Game(
        "MON 9/16 • LOCKS @ 5:25 AM",
        bengals,
        chiefs
    ),
    Game(
        "MON 9/16 • LOCKS @ 9:20 AM",
        bears,
        texans
    ),
    Game(
        "TUE 9/17 • LOCKS @ 9:15 AM",
        falcons,
        eagles
    ),
)

val gamesWeek3 = listOf(
    Game(
        "FRI 9/20 • LOCKS @ 9:15 AM",
        patriots,
        jets
    ),
    Game(
        "MON 9/23 • LOCKS @ 2:00 AM",
        giants,
        browns
    ),
    Game(
        "MON 9/23 • LOCKS @ 2:00 AM",
        packers,
        titans
    ),
    Game(
        "MON 9/23 • LOCKS @ 2:00 AM",
        bears,
        colts
    ),
    Game(
        "MON 9/23 • LOCKS @ 2:00 AM",
        texans,
        vikings
    ),
    Game(
        "MON 9/23 • LOCKS @ 2:00 AM",
        eagles,
        saints
    ),
    Game(
        "MON 9/23 • LOCKS @ 2:00 AM",
        chargers,
        steelers
    ),
    Game(
        "MON 9/23 • LOCKS @ 2:00 AM",
        broncos,
        buccaneers
    ),
    Game(
        "MON 9/23 • LOCKS @ 5:05 AM",
        panthers,
        raiders
    ),
    Game(
        "MON 9/23 • LOCKS @ 5:05 AM",
        dolphins,
        seahawks
    ),
    Game(
        "MON 9/23 • LOCKS @ 5:25 AM",
        ravens,
        cowboys
    ),
    Game(
        "MON 9/23 • LOCKS @ 5:25 AM",
        niners,
        rams
    ),
    Game(
        "MON 9/23 • LOCKS @ 5:25 AM",
        lions,
        cardinals
    ),
    Game(
        "MON 9/23 • LOCKS @ 9:20 AM",
        chiefs,
        falcons
    ),
    Game(
        "TUE 9/24 • LOCKS @ 8:30 AM",
        jaguars,
        bills
    ),
    Game(
        "TUE 9/24 • LOCKS @ 9:15 AM",
        commanders,
        bengals
    ),
)

val gamesWeek4 = listOf(
    Game(
        "FRI 9/27 • LOCKS @ 9:15 AM",
        cowboys,
        giants
    ),
    Game(
        "MON 9/30 • LOCKS @ 2:00 AM",
        saints,
        falcons
    ),
    Game(
        "MON 9/30 • LOCKS @ 2:00 AM",
        rams,
        bears
    ),
    Game(
        "MON 9/30 • LOCKS @ 2:00 AM",
        vikings,
        packers
    ),
    Game(
        "MON 9/30 • LOCKS @ 2:00 AM",
        steelers,
        colts
    ),
    Game(
        "MON 9/30 • LOCKS @ 2:00 AM",
        broncos,
        jets
    ),
    Game(
        "MON 9/30 • LOCKS @ 2:00 AM",
        eagles,
        buccaneers
    ),
    Game(
        "MON 9/30 • LOCKS @ 2:00 AM",
        bengals,
        panthers
    ),
    Game(
        "MON 9/30 • LOCKS @ 2:00 AM",
        jaguars,
        texans
    ),
    Game(
        "MON 9/30 • LOCKS @ 5:05 AM",
        commanders,
        cardinals
    ),
    Game(
        "MON 9/30 • LOCKS @ 5:05 AM",
        patriots,
        niners
    ),
    Game(
        "MON 9/30 • LOCKS @ 5:25 AM",
        browns,
        raiders
    ),
    Game(
        "MON 9/30 • LOCKS @ 5:25 AM",
        chiefs,
        chargers
    ),
    Game(
        "MON 9/30 • LOCKS @ 9:20 AM",
        bills,
        ravens
    ),
    Game(
        "TUE 10/1 • LOCKS @ 8:30 AM",
        titans,
        dolphins
    ),
    Game(
        "TUE 10/1 • LOCKS @ 9:15 AM",
        seahawks,
        lions
    ),
)

val gamesWeek5 = listOf(
    Game(
        "FRI 10/4 • LOCKS @ 9:15 AM",
        buccaneers,
        falcons
    ),
    Game(
        "SUN 10/6 • LOCKS @ 10:30 PM",
        jets,
        vikings
    ),
    Game(
        "MON 10/7 • LOCKS @ 2:00 AM",
        panthers,
        bears
    ),
    Game(
        "MON 10/7 • LOCKS @ 2:00 AM",
        ravens,
        bengals
    ),
    Game(
        "MON 10/7 • LOCKS @ 2:00 AM",
        dolphins,
        patriots
    ),
    Game(
        "MON 10/7 • LOCKS @ 2:00 AM",
        browns,
        commanders
    ),
    Game(
        "MON 10/7 • LOCKS @ 2:00 AM",
        colts,
        jaguars
    ),
    Game(
        "MON 10/7 • LOCKS @ 2:00 AM",
        bills,
        texans
    ),
    Game(
        "MON 10/7 • LOCKS @ 5:05 AM",
        raiders,
        broncos
    ),
    Game(
        "MON 10/7 • LOCKS @ 5:05 AM",
        cardinals,
        niners
    ),
    Game(
        "MON 10/7 • LOCKS @ 5:25 AM",
        packers,
        rams
    ),
    Game(
        "MON 10/7 • LOCKS @ 5:25 AM",
        giants,
        seahawks
    ),
    Game(
        "MON 10/7 • LOCKS @ 9:20 AM",
        cowboys,
        steelers
    ),
    Game(
        "TUE 10/8 • LOCKS @ 9:15 AM",
        saints,
        chiefs
    ),
)

val gamesWeek6 = listOf(
    Game(
        "FRI 10/11 • LOCKS @ 9:15 AM",
        niners,
        seahawks
    ),
    Game(
        "SUN 10/13 • LOCKS @ 10:30 PM",
        jaguars,
        bears
    ),
    Game(
        "MON 10/14 • LOCKS @ 2:00 AM",
        cardinals,
        packers
    ),
    Game(
        "MON 10/14 • LOCKS @ 2:00 AM",
        colts,
        titans
    ),
    Game(
        "MON 10/14 • LOCKS @ 2:00 AM",
        texans,
        patriots
    ),
    Game(
        "MON 10/14 • LOCKS @ 2:00 AM",
        buccaneers,
        saints
    ),
    Game(
        "MON 10/14 • LOCKS @ 2:00 AM",
        browns,
        eagles
    ),
    Game(
        "MON 10/14 • LOCKS @ 2:00 AM",
        commanders,
        ravens
    ),
    Game(
        "MON 10/14 • LOCKS @ 5:05 AM",
        chargers,
        broncos
    ),
    Game(
        "MON 10/14 • LOCKS @ 5:05 AM",
        steelers,
        raiders
    ),
    Game(
        "MON 10/14 • LOCKS @ 5:25 AM",
        lions,
        cowboys
    ),
    Game(
        "MON 10/14 • LOCKS @ 5:25 AM",
        falcons,
        panthers
    ),
    Game(
        "MON 10/14 • LOCKS @ 9:20 AM",
        bengals,
        giants
    ),
    Game(
        "TUE 10/15 • LOCKS @ 9:15 AM",
        bills,
        jets
    ),
)

val gamesWeek7 = listOf(
    Game(
        "FRI 10/18 • LOCKS @ 9:15 AM",
        broncos,
        saints
    ),
    Game(
        "SUN 10/20 • LOCKS @ 10:30 PM",
        patriots,
        jaguars
    ),
    Game(
        "MON 10/21 • LOCKS @ 2:00 AM",
        seahawks,
        falcons
    ),
    Game(
        "MON 10/21 • LOCKS @ 2:00 AM",
        titans,
        bills
    ),
    Game(
        "MON 10/21 • LOCKS @ 2:00 AM",
        bengals,
        browns
    ),
    Game(
        "MON 10/21 • LOCKS @ 2:00 AM",
        texans,
        packers
    ),
    Game(
        "MON 10/21 • LOCKS @ 2:00 AM",
        dolphins,
        colts
    ),
    Game(
        "MON 10/21 • LOCKS @ 2:00 AM",
        lions,
        vikings
    ),
    Game(
        "MON 10/21 • LOCKS @ 2:00 AM",
        eagles,
        giants
    ),
    Game(
        "MON 10/21 • LOCKS @ 5:05 AM",
        raiders,
        rams
    ),
    Game(
        "MON 10/21 • LOCKS @ 5:05 AM",
        panthers,
        commanders
    ),
    Game(
        "MON 10/21 • LOCKS @ 5:25 AM",
        chiefs,
        niners
    ),
    Game(
        "MON 10/21 • LOCKS @ 9:20 AM",
        jets,
        steelers
    ),
    Game(
        "TUE 10/22 • LOCKS @ 9:15 AM",
        ravens,
        buccaneers
    ),
    Game(
        "TUE 10/22 • LOCKS @ 10:00 AM",
        chargers,
        cardinals
    ),
)

val gamesWeek8 = listOf(
    Game(
        "FRI 10/25 • LOCKS @ 9:15 AM",
        vikings,
        rams
    ),
    Game(
        "MON 10/28 • LOCKS @ 2:00 AM",
        ravens,
        browns
    ),
    Game(
        "MON 10/28 • LOCKS @ 2:00 AM",
        titans,
        lions
    ),
    Game(
        "MON 10/28 • LOCKS @ 2:00 AM",
        cardinals,
        dolphins
    ),
    Game(
        "MON 10/28 • LOCKS @ 2:00 AM",
        jets,
        patriots
    ),
    Game(
        "MON 10/28 • LOCKS @ 2:00 AM",
        falcons,
        buccaneers
    ),
    Game(
        "MON 10/28 • LOCKS @ 2:00 AM",
        bears,
        commanders
    ),
    Game(
        "MON 10/28 • LOCKS @ 2:00 AM",
        packers,
        jaguars
    ),
    Game(
        "MON 10/28 • LOCKS @ 2:00 AM",
        colts,
        texans
    ),
    Game(
        "MON 10/28 • LOCKS @ 5:05 AM",
        saints,
        chargers
    ),
    Game(
        "MON 10/28 • LOCKS @ 5:05 AM",
        bills,
        seahawks
    ),
    Game(
        "MON 10/28 • LOCKS @ 5:25 AM",
        eagles,
        bengals
    ),
    Game(
        "MON 10/28 • LOCKS @ 5:25 AM",
        panthers,
        broncos
    ),
    Game(
        "MON 10/28 • LOCKS @ 5:25 AM",
        chiefs,
        raiders
    ),
    Game(
        "MON 10/28 • LOCKS @ 9:20 AM",
        cowboys,
        niners
    ),
    Game(
        "TUE 10/29 • LOCKS @ 9:15 AM",
        giants,
        steelers
    ),
)

val gamesWeek9 = listOf(
    Game(
        "FRI 11/1 • LOCKS @ 9:15 AM",
        texans,
        jets
    ),
    Game(
        "MON 11/4 • LOCKS @ 3:00 AM",
        cowboys,
        falcons
    ),
    Game(
        "MON 11/4 • LOCKS @ 3:00 AM",
        dolphins,
        bills
    ),
    Game(
        "MON 11/4 • LOCKS @ 3:00 AM",
        raiders,
        bengals
    ),
    Game(
        "MON 11/4 • LOCKS @ 3:00 AM",
        chargers,
        browns
    ),
    Game(
        "MON 11/4 • LOCKS @ 3:00 AM",
        patriots,
        titans
    ),
    Game(
        "MON 11/4 • LOCKS @ 3:00 AM",
        colts,
        vikings
    ),
    Game(
        "MON 11/4 • LOCKS @ 3:00 AM",
        commanders,
        giants
    ),
    Game(
        "MON 11/4 • LOCKS @ 3:00 AM",
        saints,
        panthers
    ),
    Game(
        "MON 11/4 • LOCKS @ 3:00 AM",
        broncos,
        ravens
    ),
    Game(
        "MON 11/4 • LOCKS @ 6:05 AM",
        bears,
        cardinals
    ),
    Game(
        "MON 11/4 • LOCKS @ 6:25 AM",
        lions,
        packers
    ),
    Game(
        "MON 11/4 • LOCKS @ 6:25 AM",
        rams,
        seahawks
    ),
    Game(
        "MON 11/4 • LOCKS @ 10:20 AM",
        jaguars,
        eagles
    ),
    Game(
        "TUE 11/5 • LOCKS @ 10:15 AM",
        buccaneers,
        chiefs
    ),
)

val gamesWeek10 = listOf(
    Game(
        "FRI 11/8 • LOCKS @ 10:15 AM",
        bengals,
        ravens
    ),
    Game(
        "SUN 11/10 • LOCKS @ 11:30 PM",
        giants,
        panthers
    ),
    Game(
        "MON 11/11 • LOCKS @ 3:00 AM",
        patriots,
        bears
    ),
    Game(
        "MON 11/11 • LOCKS @ 3:00 AM",
        bills,
        colts
    ),
    Game(
        "MON 11/11 • LOCKS @ 3:00 AM",
        broncos,
        chiefs
    ),
    Game(
        "MON 11/11 • LOCKS @ 3:00 AM",
        falcons,
        saints
    ),
    Game(
        "MON 11/11 • LOCKS @ 3:00 AM",
        niners,
        buccaneers
    ),
    Game(
        "MON 11/11 • LOCKS @ 3:00 AM",
        steelers,
        commanders
    ),
    Game(
        "MON 11/11 • LOCKS @ 3:00 AM",
        vikings,
        jaguars
    ),
    Game(
        "MON 11/11 • LOCKS @ 6:05 AM",
        titans,
        chargers
    ),
    Game(
        "MON 11/11 • LOCKS @ 6:25 AM",
        eagles,
        cowboys
    ),
    Game(
        "MON 11/11 • LOCKS @ 6:25 AM",
        jets,
        cardinals
    ),
    Game(
        "MON 11/11 • LOCKS @ 10:20 AM",
        lions,
        texans
    ),
    Game(
        "TUE 11/12 • LOCKS @ 10:15 AM",
        dolphins,
        rams
    ),
)

val gamesWeek11 = listOf(
    Game(
        "FRI 11/15 • LOCKS @ 10:15 AM",
        commanders,
        eagles
    ),
    Game(
        "MON 11/18 • LOCKS @ 3:00 AM",
        packers,
        bears
    ),
    Game(
        "MON 11/18 • LOCKS @ 3:00 AM",
        jaguars,
        lions
    ),
    Game(
        "MON 11/18 • LOCKS @ 3:00 AM",
        vikings,
        titans
    ),
    Game(
        "MON 11/18 • LOCKS @ 3:00 AM",
        raiders,
        dolphins
    ),
    Game(
        "MON 11/18 • LOCKS @ 3:00 AM",
        rams,
        patriots
    ),
    Game(
        "MON 11/18 • LOCKS @ 3:00 AM",
        broncos,
        saints
    ),
    Game(
        "MON 11/18 • LOCKS @ 3:00 AM",
        ravens,
        steelers
    ),
    Game(
        "MON 11/18 • LOCKS @ 6:05 AM",
        falcons,
        broncos
    ),
    Game(
        "MON 11/18 • LOCKS @ 6:05 AM",
        seahawks,
        niners
    ),
    Game(
        "MON 11/18 • LOCKS @ 6:25 AM",
        chiefs,
        bills
    ),
    Game(
        "MON 11/18 • LOCKS @ 6:25 AM",
        bengals,
        chargers
    ),
    Game(
        "MON 11/18 • LOCKS @ 10:20 AM",
        colts,
        jets
    ),
    Game(
        "TUE 11/19 • LOCKS @ 10:15 AM",
        texans,
        cowboys
    ),
)

val gamesWeek12 = listOf(
    Game(
        "FRI 11/22 • LOCKS @ 10:15 AM",
        steelers,
        browns
    ),
    Game(
        "MON 11/25 • LOCKS @ 3:00 AM",
        vikings,
        bears
    ),
    Game(
        "MON 11/25 • LOCKS @ 3:00 AM",
        lions,
        colts
    ),
    Game(
        "MON 11/25 • LOCKS @ 3:00 AM",
        patriots,
        dolphins
    ),
    Game(
        "MON 11/25 • LOCKS @ 3:00 AM",
        buccaneers,
        giants
    ),
    Game(
        "MON 11/25 • LOCKS @ 3:00 AM",
        cowboys,
        commanders
    ),
    Game(
        "MON 11/25 • LOCKS @ 3:00 AM",
        chiefs,
        panthers
    ),
    Game(
        "MON 11/25 • LOCKS @ 3:00 AM",
        titans,
        texans
    ),
    Game(
        "MON 11/25 • LOCKS @ 6:05 AM",
        broncos,
        raiders
    ),
    Game(
        "MON 11/25 • LOCKS @ 6:25 AM",
        niners,
        packers
    ),
    Game(
        "MON 11/25 • LOCKS @ 6:25 AM",
        cardinals,
        seahawks
    ),
    Game(
        "MON 11/25 • LOCKS @ 10:20 AM",
        eagles,
        rams
    ),
    Game(
        "TUE 11/26 • LOCKS @ 10:15 AM",
        ravens,
        chargers
    ),
)

val gamesWeek13 = listOf(
    Game(
        "FRI 11/29 • LOCKS @ 2:30 AM",
        bears,
        lions
    ),
    Game(
        "FRI 11/29 • LOCKS @ 6:30 AM",
        giants,
        cowboys
    ),
    Game(
        "FRI 11/29 • LOCKS @ 10:20 AM",
        dolphins,
        packers
    ),
    Game(
        "SAT 11/30 • LOCKS @ 5:00 AM",
        raiders,
        chiefs
    ),
    Game(
        "MON 12/2 • LOCKS @ 3:00 AM",
        chargers,
        falcons
    ),
    Game(
        "MON 12/2 • LOCKS @ 3:00 AM",
        steelers,
        bengals
    ),
    Game(
        "MON 12/2 • LOCKS @ 3:00 AM",
        cardinals,
        vikings
    ),
    Game(
        "MON 12/2 • LOCKS @ 3:00 AM",
        colts,
        patriots
    ),
    Game(
        "MON 12/2 • LOCKS @ 3:00 AM",
        seahawks,
        jets
    ),
    Game(
        "MON 12/2 • LOCKS @ 3:00 AM",
        titans,
        commanders
    ),
    Game(
        "MON 12/2 • LOCKS @ 3:00 AM",
        texans,
        jaguars
    ),
    Game(
        "MON 12/2 • LOCKS @ 6:05 AM",
        rams,
        saints
    ),
    Game(
        "MON 12/2 • LOCKS @ 6:05 AM",
        buccaneers,
        panthers
    ),
    Game(
        "MON 12/2 • LOCKS @ 6:25 AM",
        eagles,
        ravens
    ),
    Game(
        "MON 12/2 • LOCKS @ 10:20 AM",
        niners,
        bills
    ),
    Game(
        "TUE 12/3 • LOCKS @ 10:15 AM",
        browns,
        broncos
    ),
)

val gamesWeek14 = listOf(
    Game(
        "FRI 12/6 • LOCKS @ 10:15 AM",
        packers,
        lions
    ),
    Game(
        "MON 12/9 • LOCKS @ 3:00 AM",
        jaguars,
        titans
    ),
    Game(
        "MON 12/9 • LOCKS @ 3:00 AM",
        jets,
        dolphins
    ),
    Game(
        "MON 12/9 • LOCKS @ 3:00 AM",
        falcons,
        vikings
    ),
    Game(
        "MON 12/9 • LOCKS @ 3:00 AM",
        saints,
        giants
    ),
    Game(
        "MON 12/9 • LOCKS @ 3:00 AM",
        panthers,
        eagles
    ),
    Game(
        "MON 12/9 • LOCKS @ 3:00 AM",
        browns,
        steelers
    ),
    Game(
        "MON 12/9 • LOCKS @ 3:00 AM",
        raiders,
        buccaneers
    ),
    Game(
        "MON 12/9 • LOCKS @ 6:05 AM",
        seahawks,
        cardinals
    ),
    Game(
        "MON 12/9 • LOCKS @ 6:25 AM",
        bills,
        rams
    ),
    Game(
        "MON 12/9 • LOCKS @ 6:25 AM",
        bears,
        niners
    ),
    Game(
        "MON 12/9 • LOCKS @ 10:20 AM",
        chargers,
        chiefs
    ),
    Game(
        "TUE 12/10 • LOCKS @ 10:15 AM",
        bengals,
        cowboys
    ),
)

val gamesWeek15 = listOf(
    Game(
        "FRI 12/13 • LOCKS @ 10:15 AM",
        rams,
        niners
    ),
    Game(
        "MON 12/16 • LOCKS @ 3:00 AM",
        chiefs,
        browns
    ),
    Game(
        "MON 12/16 • LOCKS @ 3:00 AM",
        bengals,
        titans
    ),
    Game(
        "MON 12/16 • LOCKS @ 3:00 AM",
        commanders,
        saints
    ),
    Game(
        "MON 12/16 • LOCKS @ 3:00 AM",
        ravens,
        giants
    ),
    Game(
        "MON 12/16 • LOCKS @ 3:00 AM",
        cowboys,
        panthers
    ),
    Game(
        "MON 12/16 • LOCKS @ 3:00 AM",
        jets,
        jaguars
    ),
    Game(
        "MON 12/16 • LOCKS @ 3:00 AM",
        dolphins,
        texans
    ),
    Game(
        "MON 12/16 • LOCKS @ 6:25 AM",
        colts,
        broncos
    ),
    Game(
        "MON 12/16 • LOCKS @ 6:25 AM",
        bills,
        lions
    ),
    Game(
        "MON 12/16 • LOCKS @ 6:25 AM",
        steelers,
        eagles
    ),
    Game(
        "MON 12/16 • LOCKS @ 6:25 AM",
        patriots,
        cardinals
    ),
    Game(
        "MON 12/16 • LOCKS @ 6:25 AM",
        buccaneers,
        chargers
    ),
    Game(
        "MON 12/16 • LOCKS @ 10:20 AM",
        packers,
        seahawks
    ),
    Game(
        "TUE 12/17 • LOCKS @ 10:00 AM",
        bears,
        vikings
    ),
    Game(
        "TUE 12/17 • LOCKS @ 10:30 AM",
        falcons,
        raiders
    ),
)

val gamesWeek16 = listOf(
    Game(
        "FRI 12/20 • LOCKS @ 10:15 AM",
        browns,
        bengals
    ),
    Game(
        "SUN 12/22 • LOCKS @ 3:00 AM",
        texans,
        chiefs
    ),
    Game(
        "SUN 12/22 • LOCKS @ 6:30 AM",
        steelers,
        ravens
    ),
    Game(
        "MON 12/23 • LOCKS @ 3:00 AM",
        giants,
        falcons
    ),
    Game(
        "MON 12/23 • LOCKS @ 3:00 AM",
        patriots,
        bills
    ),
    Game(
        "MON 12/23 • LOCKS @ 3:00 AM",
        lions,
        bears
    ),
    Game(
        "MON 12/23 • LOCKS @ 3:00 AM",
        titans,
        colts
    ),
    Game(
        "MON 12/23 • LOCKS @ 3:00 AM",
        rams,
        jets
    ),
    Game(
        "MON 12/23 • LOCKS @ 3:00 AM",
        eagles,
        commanders
    ),
    Game(
        "MON 12/23 • LOCKS @ 3:00 AM",
        cardinals,
        panthers
    ),
    Game(
        "MON 12/23 • LOCKS @ 6:05 AM",
        broncos,
        chargers
    ),
    Game(
        "MON 12/23 • LOCKS @ 6:05 AM",
        vikings,
        seahawks
    ),
    Game(
        "MON 12/23 • LOCKS @ 6:25 AM",
        jaguars,
        raiders
    ),
    Game(
        "MON 12/23 • LOCKS @ 6:25 AM",
        niners,
        dolphins
    ),
    Game(
        "MON 12/23 • LOCKS @ 10:20 AM",
        buccaneers,
        cowboys
    ),
    Game(
        "TUE 12/24 • LOCKS @ 10:15 AM",
        saints,
        packers
    ),
)

val gamesWeek17 = listOf(
    Game(
        "THU 12/26 • LOCKS @ 3:00 AM",
        chiefs,
        steelers
    ),
    Game(
        "THU 12/26 • LOCKS @ 6:30 AM",
        ravens,
        texans
    ),
    Game(
        "FRI 12/27 • LOCKS @ 10:15 AM",
        seahawks,
        bears
    ),
    Game(
        "TBD",
        broncos,
        bengals
    ),
    Game(
        "TBD",
        cardinals,
        rams
    ),
    Game(
        "TBD",
        chargers,
        patriots
    ),
    Game(
        "TBD",
        colts,
        giants
    ),
    Game(
        "TBD",
        falcons,
        commanders
    ),
    Game(
        "MON 12/30 • LOCKS @ 3:00 AM",
        jets,
        bills
    ),
    Game(
        "MON 12/30 • LOCKS @ 3:00 AM",
        packers,
        vikings
    ),
    Game(
        "MON 12/30 • LOCKS @ 3:00 AM",
        raiders,
        saints
    ),
    Game(
        "MON 12/30 • LOCKS @ 3:00 AM",
        panthers,
        buccaneers
    ),
    Game(
        "MON 12/30 • LOCKS @ 3:00 AM",
        titans,
        jaguars
    ),
    Game(
        "MON 12/30 • LOCKS @ 6:25 AM",
        cowboys,
        eagles
    ),
    Game(
        "MON 12/30 • LOCKS @ 10:20 AM",
        dolphins,
        browns
    ),
    Game(
        "TUE 12/31 • LOCKS @ 10:15 AM",
        lions,
        niners
    ),
)

val gamesWeek18 = listOf(
    Game(
        "TBD",
        panthers,
        falcons
    ),
    Game(
        "TBD",
        commanders,
        cowboys
    ),
    Game(
        "TBD",
        chiefs,
        broncos
    ),
    Game(
        "TBD",
        vikings,
        lions
    ),
    Game(
        "TBD",
        bears,
        packers
    ),
    Game(
        "TBD",
        texans,
        titans
    ),
    Game(
        "TBD",
        jaguars,
        colts
    ),
    Game(
        "TBD",
        chargers,
        raiders
    ),
    Game(
        "TBD",
        seahawks,
        rams
    ),
    Game(
        "TBD",
        bills,
        patriots
    ),
    Game(
        "TBD",
        dolphins,
        jets
    ),
    Game(
        "TBD",
        giants,
        eagles
    ),
    Game(
        "TBD",
        niners,
        cardinals
    ),
    Game(
        "TBD",
        bengals,
        steelers
    ),
    Game(
        "TBD",
        saints,
        buccaneers
    ),
    Game(
        "TBD",
        browns,
        ravens
    ),
)

val gamesWeekList = listOf(
    gamesWeek1,
    gamesWeek2,
    gamesWeek3,
    gamesWeek4,
    gamesWeek5,
    gamesWeek6,
    gamesWeek7,
    gamesWeek8,
    gamesWeek9,
    gamesWeek10,
    gamesWeek11,
    gamesWeek12,
    gamesWeek13,
    gamesWeek14,
    gamesWeek15,
    gamesWeek16,
    gamesWeek17,
    gamesWeek18,
)
