package com.fort0.moviecatalogue.utils

import com.fort0.moviecatalogue.data.source.local.TvShow
import com.fort0.moviecatalogue.data.source.remote.response.TvShowResponse

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
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9hDXqzN5l4lBmEtb8IstXr91k8z.jpg",
                "1"
            )
        )

        tvShow.add(
            TvShow(
                "Who Killed Sara?",
                "6.5",
                "Crime, Drama, Mystery",
                "2021",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                "2"
            )
        )

        tvShow.add(
            TvShow(
                "Money Heist",
                "8.3",
                "Action, Crime, Mystery",
                "2017",
                "An unusual group of robbers attempt to carry out the most perfect robbery in Spanish history - stealing 2.4 billion euros from the Royal Mint of Spain.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg",
                "3"
            )
        )

        tvShow.add(
            TvShow(
                "Elite",
                "7.5",
                "Crime, Drama, Thriller",
                "2018",
                "When three working-class teenagers begin attending an exclusive private school in Spain, the clash between them and the wealthy students leads to murder.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3NTAbAiao4JLzFQw6YxP1YZppM8.jpg",
                "4"
            )
        )

        tvShow.add(
            TvShow(
                "Lucifer",
                "8.1",
                "Crime, Drama, Fantasy",
                "2016",
                "Lucifer Morningstar has decided he's had enough of being the dutiful servant in Hell and decides to spend some time on Earth to better understand humanity. He settles in Los Angeles - the City of Angels.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "5"
            )
        )

        tvShow.add(
            TvShow(
                "Lupin",
                "7.6",
                "Action, Crime, Drama",
                "2021",
                "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sgxawbFB5Vi5OkPWQLNfl3dvkNJ.jpg",
                "6"
            )
        )

        tvShow.add(
            TvShow(
                "Designated Survivor",
                "7.5",
                "Drama, Romance",
                "2016",
                "A low-level Cabinet member becomes President of the United States after a catastrophic attack kills everyone above him in the line of succession.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5R125JAIh1N38pzHp2dRsBpOVNY.jpg",
                "7"
            )
        )

        tvShow.add(
            TvShow(
                "Love Alarm",
                "7.1",
                "Comedy, Drama, Romance",
                "2019",
                "Snipers ordered to protect a gas pipeline from terrorists suspect a security breach when they're targeted by a ghost shooter who knows their location.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hQ8Hobo1RpYuZVQJQOCycNMHAG.jpg",
                "8"
            )
        )

        tvShow.add(
            TvShow(
                "Stranger Things",
                "8.7",
                "Drama, Fantasy, Horror",
                "2016",
                "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg",
                "9"
            )
        )

        tvShow.add(
            TvShow(
                "You",
                "7.7",
                "Drama, Fantasy, Horror",
                "2018",
                "A dangerously charming, intensely obsessive young man goes to extreme measures to insert himself into the lives of those he is transfixed by.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9qZUrhcFVI9MNznVJxdfcrmifof.jpg",
                "10"
            )
        )
        return tvShow
    }

    fun generateRemoteTvShowList(): ArrayList<TvShowResponse> {
        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(
            TvShowResponse(
                "Girl From Nowhere",
                "7.7",
                "Crime, Drama, Fantasy",
                "2018",
                "A mysterious, clever girl named Nanno transfers to different schools, exposing the lies and misdeeds of the students and faculty at every turn.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9hDXqzN5l4lBmEtb8IstXr91k8z.jpg",
                "1"
            )
        )

        tvShow.add(
            TvShowResponse(
                "Who Killed Sara?",
                "6.5",
                "Crime, Drama, Mystery",
                "2021",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                "2"
            )
        )

        tvShow.add(
            TvShowResponse(
                "Money Heist",
                "8.3",
                "Action, Crime, Mystery",
                "2017",
                "An unusual group of robbers attempt to carry out the most perfect robbery in Spanish history - stealing 2.4 billion euros from the Royal Mint of Spain.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg",
                "3"
            )
        )

        tvShow.add(
            TvShowResponse(
                "Elite",
                "7.5",
                "Crime, Drama, Thriller",
                "2018",
                "When three working-class teenagers begin attending an exclusive private school in Spain, the clash between them and the wealthy students leads to murder.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3NTAbAiao4JLzFQw6YxP1YZppM8.jpg",
                "4"
            )
        )

        tvShow.add(
            TvShowResponse(
                "Lucifer",
                "8.1",
                "Crime, Drama, Fantasy",
                "2016",
                "Lucifer Morningstar has decided he's had enough of being the dutiful servant in Hell and decides to spend some time on Earth to better understand humanity. He settles in Los Angeles - the City of Angels.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "5"
            )
        )

        tvShow.add(
            TvShowResponse(
                "Lupin",
                "7.6",
                "Action, Crime, Drama",
                "2021",
                "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sgxawbFB5Vi5OkPWQLNfl3dvkNJ.jpg",
                "6"
            )
        )

        tvShow.add(
            TvShowResponse(
                "Designated Survivor",
                "7.5",
                "Drama, Romance",
                "2016",
                "A low-level Cabinet member becomes President of the United States after a catastrophic attack kills everyone above him in the line of succession.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5R125JAIh1N38pzHp2dRsBpOVNY.jpg",
                "7"
            )
        )

        tvShow.add(
            TvShowResponse(
                "Love Alarm",
                "7.1",
                "Comedy, Drama, Romance",
                "2019",
                "Snipers ordered to protect a gas pipeline from terrorists suspect a security breach when they're targeted by a ghost shooter who knows their location.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hQ8Hobo1RpYuZVQJQOCycNMHAG.jpg",
                "8"
            )
        )

        tvShow.add(
            TvShowResponse(
                "Stranger Things",
                "8.7",
                "Drama, Fantasy, Horror",
                "2016",
                "When a young boy disappears, his mother, a police chief and his friends must confront terrifying supernatural forces in order to get him back.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg",
                "9"
            )
        )

        tvShow.add(
            TvShowResponse(
                "You",
                "7.7",
                "Drama, Fantasy, Horror",
                "2018",
                "A dangerously charming, intensely obsessive young man goes to extreme measures to insert himself into the lives of those he is transfixed by.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9qZUrhcFVI9MNznVJxdfcrmifof.jpg",
                "10"
            )
        )
        return tvShow
    }
}