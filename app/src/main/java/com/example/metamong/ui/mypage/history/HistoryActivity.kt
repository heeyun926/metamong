package com.example.metamong.ui.mypage.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import com.example.metamong.R
import com.example.metamong.databinding.ActivityHistoryBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet


data class ChartData(
    var lableData: String ="",
    var lineData: Double = 0.0
)

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHistoryBinding
    private val TAG = this.javaClass.simpleName
    lateinit var lineChart: LineChart
    private val chartData = ArrayList<ChartData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


            // 서버에서 데이터 가져오기 (서버에서 가져온 데이터로 가정하고 직접 추가)
            chartData.clear()
            addChartItem("1월", 7.9)
            addChartItem("2월", 8.2)
            addChartItem("3월", 8.3)
            addChartItem("4월", 8.5)
            addChartItem("5월", 7.3)

            // 그래프 그릴 자료 넘기기
            LineChart(chartData)
        }

        private fun addChartItem(lableitem: String, dataitem: Double) {
            val item = ChartData()
            item.lableData = lableitem
            item.lineData = dataitem
            chartData.add(item)
        }

        private fun LineChart(chartData: ArrayList<ChartData>) {
            lineChart = findViewById(R.id.linechart)

            val entries = mutableListOf<Entry>()  //차트 데이터 셋에 담겨질 데이터

            for (item in chartData) {
                entries.add(Entry(item.lableData.replace(("[^\\d.]").toRegex(), "").toFloat(), item.lineData.toFloat()))
            }

            //LineDataSet 선언
            val lineDataSet: LineDataSet
            lineDataSet = LineDataSet(entries, "라인챠트 예시")

            val dataSets = ArrayList<ILineDataSet>()
            dataSets.add(lineDataSet) // add the data sets

            // create a data object with the data sets
            val data = LineData(dataSets)

            // set data
            lineChart.setData(data)
            lineChart.setDescription(null); //차트에서 Description 설정 삭제

        }

    }


