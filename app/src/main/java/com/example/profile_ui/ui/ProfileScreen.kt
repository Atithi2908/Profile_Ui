package com.example.profile_ui.ui

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profile_ui.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DirectionsCar
import com.example.profile_ui.ui.theme.mygray


@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = { TopBar() },
        containerColor = Color.Black// Background color for the whole screen
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(0.dp)
        ) {
            Column(modifier =Modifier.background(mygray)) {
                Spacer(modifier=Modifier.height(10.dp))
                ProfileSection()
                Spacer(modifier = Modifier.height(24.dp))
                CredGarageCard()
                Spacer(modifier = Modifier
                    .height(12.dp)
                    .background(mygray))
                CreditInfoSection()
                Spacer(modifier = Modifier.height(24.dp))
            }
            Column(modifier = Modifier.background(Color.Black)) {
                RewardsSection()
                Spacer(modifier = Modifier.height(36.dp))
                TransactionsSection()
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("Profile", color = Color.White) },
        navigationIcon = {
            IconButton(onClick = { /* Handle back */ }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
        },

        actions = {
            TextButton(onClick = { /* Support action */ },
                modifier = Modifier
                    .border(1.dp, Color.White, RoundedCornerShape(18.dp))
                    .padding(0.1.dp)) {
                Text("support", color = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = mygray
        )
    )
}

@Composable
fun ProfileSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_pic), // Replace with actual image resource
            contentDescription = "Profile",
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text("Atithi Jaiman", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("member since Aug, 2024", color = Color.Gray, fontSize = 14.sp)
        }
    }
}

@Composable
fun CreditInfoSection() {
    Column(modifier = Modifier.padding(horizontal = 12.dp)) {
        InfoRow("credit score", "1394")
        Spacer(modifier = Modifier.height(3.dp))
        Divider(color = Color.LightGray, thickness = .75.dp)
        Spacer(modifier = Modifier.height(3.dp))
        InfoRow("lifetime cashback", "₹25")
        Spacer(modifier = Modifier.height(3.dp))
        Divider(color = Color.LightGray, thickness = .75.dp)
        Spacer(modifier = Modifier.height(3.dp))
        InfoRow("bank balance", "check")
    }
}

@Composable
fun RewardsSection() {
    Column (modifier = Modifier
        .background(Color.Black)
        .padding(horizontal = 12.dp)){
        Spacer(modifier = Modifier.height(24.dp))
        Text("YOUR REWARDS & BENEFITS", color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(6.dp))
        InfoColumn("cashback balance", "₹124")
        Spacer(modifier = Modifier.height(3.dp))
        Divider(color = Color.LightGray, thickness = .75.dp)
        Spacer(modifier = Modifier.height(3.dp))
        InfoColumn("coins", "75,786")
        Spacer(modifier = Modifier.height(3.dp))
        Divider(color = Color.LightGray, thickness = .75.dp)
        Spacer(modifier = Modifier.height(3.dp))
        InfoColumn("win up to Rs 1000", "refer and earn")

    }
}

@Composable
fun TransactionsSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text("TRANSACTIONS & SUPPORT", color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("all transactions", color = Color.White, fontSize = 16.sp)

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Arrow",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun InfoRow(title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        Text(title, color = Color.White, fontSize = 16.sp)
        Row(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                value,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
Spacer(modifier = Modifier.padding(horizontal = 12.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Arrow",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun InfoColumn(title: String, value: String) {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, color = Color.White, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                value,
                color = Color.Gray,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )


        }
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = "Arrow",
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun CredGarageCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(horizontal = 12.dp)
            .background(Color(0xFF1C1C1E), shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.DarkGray, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .border(1.dp, Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.DirectionsCar,
                    contentDescription = "Car",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = "get to know your vehicles, inside out",
                    color = Color.LightGray,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "CRED garage",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Arrow",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
