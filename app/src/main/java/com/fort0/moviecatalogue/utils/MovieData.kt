package com.fort0.moviecatalogue.utils

import com.fort0.moviecatalogue.data.source.local.Movies

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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKnx04MxnKcf5uOdhHhAAkqcCg.jpg",
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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wah9TViZDE4zfVsnIgwLB4zSxzH.jpg",
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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vdMsMYfkHJ6mLht5QCg7Hl8hnEp.jpg",
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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2L8ehd95eSW9x7KINYtZmRkAlrZ.jpg",
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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wcrjc1uwQaqoqtqi67Su4VCOYo0.jpg",
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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yMb1zfM1m64zPaZU3goTZ6mpnHu.jpg",
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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pk0OypQ6Z3rsOtl7r0UhTEEqu44.jpg",
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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rXWk1S0Ka7WtkIbi5grCxaY98Dl.jpg",
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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5vxXrr1MqGsT4NNeRITpfDnl4Rq.jpg",
                "10"
            )
        )

        return movies
    }
}