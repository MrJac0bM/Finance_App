package com.example.financeapp.Activities.ReportActivity.components

import CircularProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.financeapp.R

@Preview
@Composable

fun CenterStatsCard(modifier: Modifier= Modifier){
    ConstraintLayout(
        modifier = modifier
            .background(Color.White, shape = RoundedCornerShape(28.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(28.dp)
            )
            .padding(16.dp)
    ){
        val (progreesBar, totalTxt, totalLabel,
            incomeIcon, incomeLabel, incomeValue,
            expenseIcon, expenseLabel, expenseValue) = createRefs()

        CircularProgressBar(
            progress= 60f,
            max = 100f,
            color = colorResource(R.color.blue),
            backgroundColor = colorResource(R.color.lightGrey),
            stroke = 15.dp,
            modifier = Modifier
                .size(180.dp)
                .constrainAs(progreesBar) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "3,546.21",
            color = colorResource(R.color.darkBlue),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier
                .constrainAs(totalTxt){
                    centerTo(progreesBar)
                }
        )

        Text(
            text = "Total",
            color = colorResource(R.color.darkBlue),
            modifier = Modifier.constrainAs(totalLabel){
                top.linkTo(totalTxt.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Image(
            painter = painterResource(R.drawable.income),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(incomeIcon){
                    top.linkTo(progreesBar.bottom, margin = 20.dp)
                    start.linkTo(progreesBar.start, margin = -42.dp)
                }
        )

        Text(
            text = "Income",
            color = colorResource(R.color.darkBlue),
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            modifier = Modifier.constrainAs(incomeLabel){
                top.linkTo(incomeIcon.top)
                start.linkTo(incomeIcon.start, margin = 32.dp)
                bottom.linkTo(incomeIcon.bottom, )
            }
        )

        Text(
            text = "3,546.21",
            color = Color(0xFF2d9738),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(incomeValue){
                start.linkTo(incomeLabel.start)
                top.linkTo(incomeLabel.bottom)
                end.linkTo(incomeLabel.end)
            }
        )

        Image(
            painter = painterResource(R.drawable.expense),
            contentDescription = null,
            modifier = Modifier.constrainAs(expenseIcon){
                top.linkTo(expenseLabel.top)
                end.linkTo(expenseLabel.start, margin = 8.dp)
                bottom.linkTo(expenseLabel.bottom)
            }
        )

        Text(
            text = "Expense",
            color = colorResource(R.color.darkBlue),
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            modifier = Modifier.constrainAs(expenseLabel){
                end.linkTo(parent.end, margin = 32.dp)
                top.linkTo(incomeLabel.top)
                bottom.linkTo(incomeIcon.bottom)
            }
        )

        Text(
            text = "3,546.21",
            color = Color(0xFFef2642),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.constrainAs(expenseValue){
                start.linkTo(expenseLabel.start)
                top.linkTo(expenseLabel.bottom)
                end.linkTo(expenseLabel.end)
            }
        )
    }
}
