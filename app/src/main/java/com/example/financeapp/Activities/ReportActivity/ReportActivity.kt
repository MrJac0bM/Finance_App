package com.example.financeapp.Activities.ReportActivity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.financeapp.Activities.ReportActivity.screens.ReportContent
import com.example.financeapp.ViewModel.MainViewModel

class ReportActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReportContent(budgets = viewModel.budgets,
                onBack = { finish() })
        }
    }
}