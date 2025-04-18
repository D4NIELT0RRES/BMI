package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AssignmentInd
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Expand
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(navController: NavController?){

    var ageState = remember {
        mutableStateOf(value = "")
    }

    var weightState = remember {
        mutableStateOf("")
    }

    var heightState = remember {
        mutableStateOf("")
    }

    //Abrir o arquivo usuario.xml para recuperar o nome que o usuario digitou
    var context = LocalContext.current
    var sharedUserFile = context
        .getSharedPreferences("usuario", Context.MODE_PRIVATE)

    //Abrindo o arquivo chamado usuario e se nao for encontrado nenhum nome entao NAME NOT FOUND
    val userName = sharedUserFile.getString("user_name", "Name not found!")

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
    ){
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = stringResource(R.string.hi) + " $userName !",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
            }
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f),
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Card (
                                modifier = Modifier
                                    .size(100.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.dp, Color(0xFF3F51B5))
                            ){
                                Image(
                                    painter = painterResource(R.drawable.man),
                                    contentDescription = ""
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp,
                                             vertical = 4.dp
                                    ),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF3F51B5)
                                )

                            ) {
                                Text(text = stringResource(R.string.male))
                            }
                        }
                        Column (
                            modifier = Modifier
                                .weight(1f),
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Card (
                                modifier = Modifier
                                    .size(100.dp),
                                shape = CircleShape,
                                border = BorderStroke(1.dp, Color(0xFF3F51B5))

                            ){
                                Image(
                                    painter = painterResource(R.drawable.woman),
                                    contentDescription = ""
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp,
                                             vertical = 4.dp
                                    ),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF9C27B0)
                                )

                            ) {
                                Text(text = stringResource(R.string.female))
                            }
                        }
                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = 16.dp,
                                vertical = 16.dp
                            )
                    ) {
                        OutlinedTextField(
                            value = ageState.value,
                            onValueChange = {nome ->
                                ageState.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            shape = RoundedCornerShape(16.dp),
                            label = {Text(text = "Age")},
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "",
                                    tint = Color(0xFF3F51B5)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF3F51B5),
                                cursorColor = Color(0xFF03A9F4),
                                unfocusedBorderColor = Color(0xFF0028FF)
                            )

                        )
                        OutlinedTextField(
                            value = weightState.value,
                            onValueChange = {nome ->
                                weightState.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .padding(vertical = 12.dp),
                            shape = RoundedCornerShape(16.dp),
                            label = {Text(text = "Weight")},
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color(0xFF3F51B5)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(0xFF3F51B5),
                                cursorColor = Color(0xFF03A9F4),
                                unfocusedBorderColor = Color(0xFF0028FF)
                            )

                        )
                        OutlinedTextField(
                            value = heightState.value,
                            onValueChange = {nome ->
                                heightState.value = nome
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            shape = RoundedCornerShape(16.dp),
                            label = {Text(text = stringResource(R.string.height))},
                            leadingIcon = {
                                Icon(
                                    imageVector        = Icons.Default.Height,
                                    contentDescription = "",
                                    tint               = Color(0xFF3F51B5)
                                )
                            },
                            keyboardOptions  = KeyboardOptions(
                                keyboardType = KeyboardType.Decimal,
                                imeAction    = ImeAction.Done
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor   = Color(0xFF3F51B5),
                                cursorColor          = Color(0xFF03A9F4),
                                unfocusedBorderColor = Color(0xFF0028FF)
                            )
                        )
                    }
                    Button(
                        onClick = {
                            heightState.value.replace(",", ".")
                            val editor = sharedUserFile.edit()
                            editor.putInt("user_age"   ,ageState   .value.trim().toInt())
                            editor.putInt("user_weight",weightState.value.trim().toInt())
                            editor.putInt("user_height",heightState.value.trim().toInt())
                            editor.apply()
                            navController?.navigate("BMIResultScreen")

                        },
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF0028FF)
                        ),
                        shape = RoundedCornerShape(8.dp)

                    ) {
                        Text(
                            text = stringResource(R.string.calculate),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview(){
    UserDataScreen(navController = null)
}

