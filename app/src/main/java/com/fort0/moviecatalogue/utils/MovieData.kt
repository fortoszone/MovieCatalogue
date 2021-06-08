package com.fort0.moviecatalogue.utils

import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.data.Movies

object MovieData {
    fun generateMovieList(): ArrayList<Movies> {
        val movies = ArrayList<Movies>()

        movies.add(
            Movies(
                "Army of The Dead",
                "5.9",
                "Action, Crime, Horror",
                "2021",
                "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble, venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                R.drawable.armyofthedead,
                "1"
            )
        )

        movies.add(
            Movies(
                "Olympus Has Fallen",
                "6.5",
                "Action, Thriller",
                "2013",
                "Secret Service agent Mike Banning finds himself trapped inside the White House in the wake of a terrorist attack and works with national security to rescue the President from his kidnappers.",
                R.drawable.olympushasfallen,
                "2"
            )
        )

        movies.add(
            Movies(
                "London Has Fallen",
                "6.9",
                "Action, Thriller",
                "2016",
                "In London for the Prime Minister's funeral, Mike Banning is caught up in a plot to assassinate all the attending world leaders.",
                R.drawable.londonhasfallen,
                "3"
            )
        )

        movies.add(
            Movies(
                "Ghost Lab",
                "5.3",
                "Drama, Horror, Thriller",
                "2021",
                "After witnessing a haunting in their hospital, two doctors become dangerously obsessed with obtaining scientific proof that ghosts exist.",
                R.drawable.ghostlab,
                "4"
            )
        )

        movies.add(
            Movies(
                "Mile 22",
                "6.1",
                "Action, Thriller",
                "2018",
                "A small team of elite American intelligence officers, part of a top-secret tactical command unit, try to smuggle a mysterious police officer with sensitive information out of Indonesia.",
                R.drawable.mile22,
                "5"
            )
        )

        movies.add(
            Movies(
                "The Woman in The Window",
                "5,7",
                "Crime, Drama, Mystery",
                "2021",
                "An agoraphobic woman living alone in New York begins spying on her new neighbors, only to witness a disturbing act of violence.",
                R.drawable.thewomaninthewindow,
                "6"
            )
        )

        movies.add(
            Movies(
                "From London to Bali",
                "5.1",
                "Drama, Romance",
                "2017",
                "For Lukman (Ricky Harun), Dewi's (Jessica Milla) departure to London is a small apocalypse. He works odd jobs in order to catch up to London.",
                R.drawable.fromlondontobali,
                "7"
            )
        )

        movies.add(
            Movies(
                "Sniper: Ghost Shooter",
                "5,4",
                "Action, Drama, Thriller",
                "2016",
                "Snipers ordered to protect a gas pipeline from terrorists suspect a security breach when they're targeted by a ghost shooter who knows their location.",
                R.drawable.sniperghostshooter,
                "8"
            )
        )

        movies.add(
            Movies(
                "The Next Three Days",
                "7.3",
                "Action, Crime, Drama",
                "2010",
                "A married couple's life is turned upside down when the wife is accused of a murder.",
                R.drawable.thenextthreedays,
                "9"
            )
        )

        movies.add(
            Movies(
                "Final Destination",
                "6.7",
                "Horror, Thriller",
                "2000",
                "Alex Browning is among a group of high school students readying themselves for a trip to Europe. When he suddenly has a premonition their airplane will crash, he screams to warn the others but instead he is thrown off of the plane.",
                R.drawable.finaldestination,
                "10"
            )
        )

        return movies
    }
}