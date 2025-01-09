package com.saiful.easychart.line

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LineChart() {
    val textMeasurer = rememberTextMeasurer()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .background(Color.White)
        ) {
            Canvas(
                modifier = Modifier
                    .padding(horizontal = 36.dp, vertical = 8.dp)
                    .aspectRatio(3 / 2f)
                    .fillMaxSize()
            ) {
                val barWidth = 1.dp.toPx()
                drawRect(color = Color.Blue, style = Stroke(width = barWidth))

                //draw vertical line
                val verticalLine = 2
                val verticalLineX = size.width / (verticalLine + 1)

                repeat(verticalLine) {
                    val x = verticalLineX * (it + 1)
                    drawText(
                        textMeasurer.measure("label"),
                        topLeft = Offset(x, size.height)
                    )
                    drawLine(
                        color = Color.Blue,
                        start = Offset(x, 0f),
                        end = Offset(x, size.height),
                        strokeWidth = barWidth
                    )

                }

                //draw horizontal line
                val horizontalLine = 2
                val horizontalLineY = size.height / (horizontalLine + 1)

                repeat(horizontalLine) {
                    val y = horizontalLineY * (it + 1)
                    drawText(
                        textMeasurer.measure("label"),
                        topLeft = Offset(-90f, y-20f)
                    )
                    drawLine(
                        color = Color.Blue,
                        start = Offset(0f, y),
                        end = Offset(size.width, y)
                    )
                }


                //draw a path
                val path = Path()
                path.lineTo(0f,size.height)
                path.lineTo(size.width/3,size.height/1.5f)
                path.lineTo(size.width/1.5f,size.height/3f)
                path.lineTo(size.width,0f)

                drawPath(
                    path = path,
                    color = Color.Blue,
                    style = Stroke(width = barWidth)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LineChartPreview() {
    LineChart()
}