package com.example.picksix

import androidx.compose.ui.graphics.Color


data class NFLTeams(
    val name: String,
    val logo: Int,
    val color: Color,
)


val cardinals = NFLTeams("Arizona Cardinals", R.drawable.cardinals_logo, Color(0xFF97233F))
val falcons = NFLTeams("Atlanta Falcons", R.drawable.falcons_logo, Color(0xFFA71930))
val ravens = NFLTeams("Baltimore Ravens", R.drawable.ravens_logo, Color(0xFF24125F))
val bills = NFLTeams("Buffalo Bills", R.drawable.bills_logo, Color(0xFF00338D))
val panthers = NFLTeams("Carolina Panthers", R.drawable.panthers_logo, Color(0xFF0085CA))
val bears = NFLTeams("Chicago Bears", R.drawable.bears_logo, Color(0xFFE64100))
val bengals = NFLTeams("Cincinnati Bengals", R.drawable.bengals_logo, Color(0xFFFB4F14))
val browns = NFLTeams("Cleveland Browns", R.drawable.browns_logo, Color(0xFFFF3300))
val cowboys = NFLTeams("Dallas Cowboys", R.drawable.cowboys_logo, Color(0xFF012169))
val broncos = NFLTeams("Denver Broncos", R.drawable.broncos_logo, Color(0xFFFC4C02))
val lions = NFLTeams("Detroit Lions", R.drawable.lions_logo, Color(0xFF0076B6))
val packers = NFLTeams("Green Bay Packers", R.drawable.packers_logo, Color(0xFF203731))
val texans = NFLTeams("Houston Texans", R.drawable.titans_logo, Color(0xFF03202F))
val colts = NFLTeams("Indianapolis Colts", R.drawable.colts_logo, Color(0xFF002C5F))
val jaguars = NFLTeams("Jacksonville Jaguars", R.drawable.jaguars_logo, Color(0xFF006778))
val chiefs = NFLTeams("Kansas City Chiefs", R.drawable.chiefs_logo, Color(0xFFA71930))
val raiders = NFLTeams("Las Vegas Raiders", R.drawable.raiders_logo, Color(0xFF000000))
val chargers = NFLTeams("Los Angeles Chargers", R.drawable.chargers_logo, Color(0xFF0080C6))
val rams = NFLTeams("Los Angeles Rams", R.drawable.rams_logo, Color(0xFF003594))
val dolphins = NFLTeams("Miami Dolphins", R.drawable.dolphins_logo, Color(0xFF008E97))
val vikings = NFLTeams("Minnesota Vikings", R.drawable.vikings_logo, Color(0xFF4F2683))
val patriots = NFLTeams("New England Patriots", R.drawable.patriots_logo, Color(0xFF002244))
val saints = NFLTeams("New Orleans Saints", R.drawable.saints_logo, Color(0xFFD3BC8D))
val giants = NFLTeams("New York Giants", R.drawable.giants_logo, Color(0xFF0B2265))
val jets = NFLTeams("New York Jets", R.drawable.jets_logo, Color(0xFF115740))
val eagles = NFLTeams("Philadelphia Eagles", R.drawable.eagles_logo, Color(0xFF004C54))
val steelers = NFLTeams("Pittsburgh Steelers", R.drawable.steelers_logo, Color(0xFF000000))
val niners = NFLTeams("San Francisco 49ers", R.drawable.niners_logo, Color(0xFFAA0000))
val seahawks = NFLTeams("Seattle Seahawks", R.drawable.seahawks_logo, Color(0xFF002150))
val buccaneers = NFLTeams("Tampa Bay Buccaneers", R.drawable.buccaneers_logo, Color(0xFFA71930))
val titans = NFLTeams("Tennessee Titans", R.drawable.titans_logo, Color(0xFF4B92DB))
val commanders = NFLTeams("Washington Commanders", R.drawable.commanders_logo, Color(0xFF5A1414))

val nflTeams = listOf(
    cardinals, falcons, ravens, bills, panthers, bears, bengals, browns, cowboys, broncos, lions,
    packers, texans, colts, jaguars, chiefs, raiders, chargers, rams, dolphins, vikings, patriots,
    saints, giants, jets, eagles, steelers, niners, seahawks, buccaneers, titans, commanders
)


