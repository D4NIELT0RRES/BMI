package br.senai.sp.jandira.bmi.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.input.TextFieldCharSequence
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(modifier: Modifier = Modifier){

    var nomeState = remember {
        mutableStateOf(value = "")
    }

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
                    .padding(10.dp)
            ){
                Text(
                    text = stringResource(R.string.hi),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp

                )
            }
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(700.dp),
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                ),
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Row (
                        modifier = Modifier

                    ){
                        Card (
                            modifier = Modifier
                                .height(100.dp)
                                .width(100.dp),
                            shape = CircleShape,
                            border = BorderStroke(width = 2.dp, Color(color = 0xFFF44336))
                        ){  }
                        Card (
                            modifier = Modifier
                                .height(100.dp)
                                .width(100.dp),
                            shape = CircleShape,
                            border = BorderStroke(width = 2.dp, Color(color = 0xFFF44336))

                        ){}


                    }
                }
                Column (
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp)
                ){
                    Column {
                        Text(
                            text = stringResource(R.string.age),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold

                        )
                        OutlinedTextField(
                            value = nomeState.value,
                            onValueChange = {
                                nomeState.value
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            shape = RoundedCornerShape(12.dp),
                            label = { Text(text = "Age")},
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.AccountBox,
                                    contentDescription = "",
                                    tint = Color(0xFF2196F3)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Sentences
                            )
                        )
                        Column (
                            modifier = Modifier
                                .padding(top = 15.dp)
                        ){
                            Text(
                                text = stringResource(R.string.weight),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                            OutlinedTextField(
                                value = nomeState.value,
                                onValueChange = {
                                    nomeState.value
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                shape = RoundedCornerShape(12.dp),
                                label = { Text(text = "Weigth")},
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.AccountBox,
                                        contentDescription = "",
                                        tint = Color(0xFF2196F3)
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    capitalization = KeyboardCapitalization.Sentences
                                )
                            )
                        }
                        Column (
                            modifier = Modifier
                                .padding(top = 15.dp)
                        ){
                            Text(
                                text = stringResource(R.string.height),
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold
                            )
                            OutlinedTextField(
                                value = nomeState.value,
                                onValueChange = {
                                    nomeState.value
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                shape = RoundedCornerShape(12.dp),
                                label = { Text(text = "Heigth")},
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.AccountBox,
                                        contentDescription = "",
                                        tint = Color(0xFF2196F3)
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    capitalization = KeyboardCapitalization.Sentences
                                )
                            )
                        }
                    }

                }
            }

        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun UserdataScreenPreview() {
    UserDataScreen()
}