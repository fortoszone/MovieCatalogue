package com.fort0.moviecatalogue.utils

import com.fort0.moviecatalogue.R
import com.fort0.moviecatalogue.data.Movies
import com.fort0.moviecatalogue.data.TvShow

object TvShowData {
    fun generateTvShowList(): ArrayList<TvShow> {
        val tvShow = ArrayList<TvShow>()

        tvShow.add(
            TvShow(
                "Girl From Nowhere",
                "7.7",
                "Crime, Drama, Fantasy",
                "2018",
                "A mysterious, clever girl named Nanno transfers to different schools, exposing the lies and misdeeds of the students and faculty at every turn.",
                R.drawable.girlfromnowhere,
                1
            )
        )

        tvShow.add(
            TvShow(
                "Who Killed Sara?",
                "6.5",
                "Crime, Drama, Mystery",
                "2021",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                R.drawable.whokilledsara,
                2
            )
        )

        tvShow.add(
            TvShow(
                "Money Heist",
                "8.3",
                "Action, Crime, Mystery",
                "2017",
                "An unusual group of robbers attempt to carry out the most perfect robbery in Spanish history - stealing 2.4 billion euros from the Royal Mint of Spain.",
                R.drawable.moneyheist,
                3
            )
        )

        tvShow.add(
            TvShow(
                "Elite",
                "7.5",
                "Crime, Drama, Thriller",
                "2018",
                "When three working-class teenagers begin attending an exclusive private school in Spain, the clash between them and the wealthy students leads to murder.",
                R.drawable.moneyheist,
                4
            )
        )

        tvShow.add(
            TvShow(
                "Lucifer",
                "8.1",
                "Crime, Drama, Fantasy",
                "2016",
                "Lucifer Morningstar has decided he's had enough of being the dutiful servant in Hell and decides to spend some time on Earth to better understand humanity. He settles in Los Angeles - the City of Angels.",
                R.drawable.lucifer,
                5
            )
        )

        tvShow.add(
            TvShow(
                "Lupin",
                "7.6",
                "Action, Crime, Drama",
                "2021",
                "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.",
                R.drawable.lupin,
                6
            )
        )

        tvShow.add(
            TvShow(
                "Designated Survivor",
                "7.5",
                "Drama, Romance",
                "2016",
                "A low-level Cabinet member becomes President of the United States after a catastrophic attack kills everyone above him in the line of succession.",
                R.drawable.designatedsurvivor,
                7
            )
        )

        tvShow.add(
            TvShow(
                "Love Alarm",
                "7.1",
                "Comedy, Drama, Romance",
                "2019",
                "Snipers ordered to protect a gas pipeline from terrorists suspect a security breach when they're targeted by a ghost shooter who knows their location.",
                R.drawable.lovealarm,
                8
            )
        )

        tvShow.add(
            TvShow(
                "Stranger Things",
                "8.7",
                "Drama, Fantasy, Horror",
                "2016",
                "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.",
                R.drawable.strangerthings,
                9
            )
        )

        tvShow.add(
            TvShow(
                "You",
                "7.7",
                "Drama, Fantasy, Horror",
                "2018",
                "A dangerously charming, intensely obsessive young man goes to extreme measures to insert himself into the lives of those he is transfixed by.",
                R.drawable.you,
                10
            )
        )
        return tvShow
    }
}