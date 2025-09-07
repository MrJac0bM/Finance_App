package com.example.financeapp.Activities.DashboardActivity.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financeapp.Domain.ExpenseDomain
import com.example.financeapp.Domain.HeaderDomain
import com.example.financeapp.R
import coil.compose.rememberAsyncImagePainter

@Composable
fun HeaderSection(item: HeaderDomain) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, top = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hello Jacob Espejel",
                color = colorResource(id = R.color.darkBlue),
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold

            )

            Text(
                text = "JacobEspejel@gmail.com",
                color = colorResource(id = R.color.darkBlue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,


            )

        }

        val painter = rememberAsyncImagePainter(item.url)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 16.dp)
        )




    }
}

@Preview
@Composable

fun CardSection(onClick: () -> Unit = {}){
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(230.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .clickable { onClick() }) {
        Image(
            painter = painterResource(id = R.drawable.card),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Companion.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.sim),
            contentDescription = null,
            modifier = Modifier.align(Alignment.TopEnd)
                .padding(all = 16.dp)

        )

        Image(
            painter = painterResource(id = R.drawable.visa),
            contentDescription = null,
            modifier = Modifier.align(Alignment.TopStart)
                .padding(all = 16.dp)

        )

        Text(
            text = "1234 5678 9012",
            color = Color.Companion.White,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp, bottom = 16.dp)
        )


        Text(
            text = "03/07",
            color = Color.Companion.White,
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp, bottom = 16.dp)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .align(Alignment.BottomCenter)
                .clip(shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp))
                .background(Color.Companion.White.copy(alpha = 0.2f))
                .padding(all = 16.dp)
        ) {
            Column {
                Text(
                    text = "Your Balance",
                    color = Color.Companion.White,
                    fontSize = 17.sp,

                    )
                Text(
                    text = "¥ 456,000,000.00",
                    color = Color.Companion.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold

                )
            }
        }
    }
}


@Preview
@Composable
fun HeaderSectionPreview(){
    val header = HeaderDomain(url = "")
    HeaderSection(item = header)
}