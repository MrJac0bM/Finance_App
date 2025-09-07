package com.example.financeapp.Activities.DashboardActivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.financeapp.Activities.DashboardActivity.components.ActionButtonRow
import com.example.financeapp.Activities.DashboardActivity.components.BottomNavigationBar
import com.example.financeapp.Activities.DashboardActivity.components.CardSection
import com.example.financeapp.Activities.DashboardActivity.components.ExpenseItem
import com.example.financeapp.Activities.DashboardActivity.components.HeaderSection
import com.example.financeapp.Domain.ExpenseDomain
import com.example.financeapp.Domain.HeaderDomain
@Composable
fun MainScreen(
    expenses: List<ExpenseDomain>,
    header: List<HeaderDomain>,
    oncardClick: () -> Unit = {},
    onCardClick2: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier.fillMaxSize(),
                onItemSelected = {}
            )
        }
    ) { paddingValues -> //
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) //
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items (header) { item -> HeaderSection(item) }
            item { CardSection(onClick = oncardClick) }
            item { ActionButtonRow(onClick =  onCardClick2) }
            items(expenses) { item -> ExpenseItem(item) }
        }
    }
}