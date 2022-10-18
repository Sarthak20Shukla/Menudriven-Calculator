package com.example.menudrivencalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.menudrivencalculator.ui.theme.LightGray
import com.example.menudrivencalculator.ui.theme.MenuDrivenCalculatorTheme
import com.example.menudrivencalculator.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuDrivenCalculatorTheme {
                val viewModel = viewModel<calculatorviewmodel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .padding(16.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing)

                    ) {
                        Text(
                            text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            fontWeight = FontWeight.Light,
                            fontSize = 80.sp,
                            color = Color.White,
                            maxLines = 2
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            calculatorbutton(symbol = "AC", modifier = Modifier
                                .background(LightGray)
                                .aspectRatio(2f)
                                .weight(2f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Clear)
                                }
                            )
                            calculatorbutton(symbol = "Del", modifier = Modifier
                                .background(LightGray)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Delete)
                                }
                            )

                            calculatorbutton(symbol = "/", modifier = Modifier
                                .background(Orange)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Operation(calculatoroperation.divide))
                                }
                            )


                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            calculatorbutton(symbol = "7", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(7))
                                }
                            )
                            calculatorbutton(symbol = "8", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(8))
                                }
                            )
                            calculatorbutton(symbol = "9", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(9))
                                }
                            )
                            calculatorbutton(symbol = "*", modifier = Modifier
                                .background(Orange)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Operation(calculatoroperation.multiply))
                                }
                            )


                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            calculatorbutton(symbol = "4", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(4))
                                }
                            )
                            calculatorbutton(symbol = "5", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(5))
                                }
                            )
                            calculatorbutton(symbol = "6", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(6))
                                }
                            )
                            calculatorbutton(symbol = "-", modifier = Modifier
                                .background(Orange)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Operation(calculatoroperation.Subtract))
                                }
                            )


                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            calculatorbutton(symbol = "1", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(1))
                                }
                            )
                            calculatorbutton(symbol = "2", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(2))
                                }
                            )
                            calculatorbutton(symbol = "3", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(3))
                                }
                            )
                            calculatorbutton(symbol = "+", modifier = Modifier
                                .background(Orange)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Operation(calculatoroperation.Add))
                                }
                            )


                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            calculatorbutton(symbol = "0", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(2f)
                                .weight(2f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Number(0))
                                }
                            )
                            calculatorbutton(symbol = ".", modifier = Modifier
                                .background(Color.Black)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Decimal)
                                }
                            )
                            calculatorbutton(symbol = "=", modifier = Modifier
                                .background(Orange)
                                .aspectRatio(1f)
                                .weight(1f),
                                onClick = {
                                    viewModel.onAction(calculatoractions.Calculate)
                                }
                            )
                        }
                    }
                }

            }
        }
    }
}
