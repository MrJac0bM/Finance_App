package com.example.financeapp.Activities.DashboardActivity.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financeapp.R

@Preview
@Composable

fun ActionButtonRow(
    onClick: () -> Unit = {}
){
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ){
        ActionButton(R.drawable.btn_1,"Add",onClick)
        ActionButton(R.drawable.btn_2,"Add",onClick)
        ActionButton(R.drawable.btn_3,"Add",onClick)
        ActionButton(R.drawable.btn_4,"Add", onClick)
    }
}

@Composable
fun RowScope.ActionButton(icon: Int, text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .weight(1f)
            .height(78.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(colorResource(R.color.lightBlue))
            .clickable{onClick()}
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(32.dp)

        )
        Text(
            text = text,
            color = colorResource(R.color.darkBlue),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
    }
}
