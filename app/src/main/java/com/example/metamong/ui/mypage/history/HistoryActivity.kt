package com.example.metamong.ui.mypage.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.metamong.databinding.ActivityHistoryBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

data class Score(
    val score: Int
)

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHistoryBinding
    private lateinit var lineChart: LineChart
    private var score = ArrayList<Score>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lineChart = binding.linechart

        setDataToLineChart()
    }

    private fun setDataToLineChart(){
        val entries: ArrayList<Entry> = ArrayList()

        score = getScoreList()

        for( i in score.indices){
            val score = score[i]
            entries.add(Entry(i.toFloat(),score.score.toFloat()))
        }
        val lineDataSet = LineDataSet(entries, "")

        val data = LineData(lineDataSet)
        lineChart.invalidate()
    }
    //simulate api call
    //we are initialising it directly
    private fun getScoreList(): ArrayList<Score>{
        score.add(Score(0))
        score.add(Score(51))
        score.add(Score(100))

        return score
    }


}