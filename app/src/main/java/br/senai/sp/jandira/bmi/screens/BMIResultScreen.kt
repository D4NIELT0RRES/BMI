package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.BmiCalculator
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.isFilled
import br.senai.sp.jandira.bmi.utils.numberFormat
import java.util.Locale

@Composable
fun BMIResultScreen(navController: NavController?) {

    var context = LocalContext.current

    val sharedUserFile = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

    val age    = sharedUserFile.getInt("user_age"   , 0)
    var height: Double = sharedUserFile.getInt("user_height", 0).toDouble()
    val weight = sharedUserFile.getInt("user_weight", 0)

    val bmiResult = BmiCalculator(weight, height)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF002AFF),
                        Color(0xFF00C8FA)
                    )
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.your_BMI_result),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f),
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp),
                        colors = CardDefaults
                            .cardColors(containerColor = Color.White),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 4.dp,
                            color = bmiResult.color,
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = String.format(
                                    Locale.getDefault(),
                                    "%.1f",
                                bmiResult.bmi.second),
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = bmiResult.bmi.first,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Column (
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(R.string.age),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = age.toString(),
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            }
                            VerticalDivider()
                            Column (
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.weight),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$weight Kg",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            }
                            VerticalDivider()
                            Column (
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.height),
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = String.format(Locale.getDefault(),"%.2f", height.div(100)),
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            }
                        }
                    }
                    //Mostrar o resultado do IMC
                    BmiLevel(
                        markColor = colorResource(R.color.light_blue),
                        text1 = stringResource(R.string.value_underweight),
                        text2 = "${numberFormat(18.0)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.UNDERWEIGHT)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.light_green),
                        text1 = stringResource(R.string.value_normal),
                        text2 = "${numberFormat(18.6)}  -  ${numberFormat(24.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.NORMAL)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.yellow),
                        text1 = stringResource(R.string.value_overweight),
                        text2 = "${numberFormat(25.0)}  -  ${numberFormat(29.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OVERWEIGHT)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.light_orange),
                        text1 = stringResource(R.string.value_obesity1),
                        text2 = "${numberFormat(30.0)}  -  ${numberFormat(34.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY1)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.dark_orange),
                        text1 = stringResource(R.string.value_obesity2),
                        text2 = "${numberFormat(35.0)}  -  ${numberFormat(39.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY2)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.red),
                        text1 = stringResource(R.string.value_obesity3),
                        text2 = "> ${numberFormat(39.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY3)
                    )
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 16.dp)
                    )
                    Button(
                        onClick = {

                            navController?.navigate("user_data")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(vertical = 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF3F51B5)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = stringResource(R.string.New_Calc),
                            fontSize = 20.sp)
                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(navController = null)
}