package com.example.financeapp.Activities.DashboardActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.financeapp.Activities.DashboardActivity.screens.MainScreen
import com.example.financeapp.Activities.IntroActivity.Screens.IntroActivity
import com.example.financeapp.Activities.IntroActivity.Screens.IntroScreen
import com.example.financeapp.Activities.ReportActivity.ReportActivity
import com.example.financeapp.ViewModel.MainViewModel
import com.example.financeapp.ui.theme.FinanceAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinanceAppTheme {
                val expenses by viewModel.expenses.observeAsState(initial = mutableListOf())
                val header by viewModel.header.observeAsState(initial = mutableListOf())
                MainScreen(
                    expenses = expenses,
                    header = header,
                    oncardClick = {
                        startActivity(Intent(this, ReportActivity::class.java))
                    },
                    onCardClick2 = {
                        startActivity(Intent(this, IntroActivity::class.java))
                    }
                )
            }
        }
    }
}
