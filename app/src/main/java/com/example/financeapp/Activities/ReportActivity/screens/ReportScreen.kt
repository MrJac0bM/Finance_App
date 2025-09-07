package com.example.financeapp.Activities.ReportActivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import com.example.financeapp.Activities.ReportActivity.components.CenterStatsCard
import com.example.financeapp.Activities.ReportActivity.components.GradientHeader
import com.example.financeapp.Activities.ReportActivity.components.SummaryColumns
import com.example.financeapp.Domain.BudgetDomain
import com.example.financeapp.R

@Composable
fun ReportContent(
    budgets: List<BudgetDomain>,
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                GradientHeader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    onBack = onBack
                )

                CenterStatsCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 16.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = 40.dp)
                )
            }
        }


        item {
            Spacer(modifier = Modifier.height(64.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SummaryColumns(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(horizontal = 24.dp)
                        .background(
                            colorResource(R.color.lightBlue),
                            shape = RoundedCornerShape(16.dp)
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportContentPreview() {
    // Sample data for preview
    val sampleBudgets = listOf(
        BudgetDomain("Groceries", 100.0, 50.0),
        BudgetDomain("Entertainment", 200.0, 150.0),
        BudgetDomain("Utilities", 150.0, 100.0)
    )
    ReportContent(budgets = sampleBudgets)
}

