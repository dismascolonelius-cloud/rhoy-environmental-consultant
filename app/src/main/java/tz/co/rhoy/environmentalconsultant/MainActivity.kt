
package tz.co.rhoy.environmentalconsultant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val ForestGreen = Color(0xFF17452F)
private val LightGreen = Color(0xFFEAF3ED)
private val White = Color(0xFFFFFFFF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = ForestGreen,
                    secondary = Color(0xFF4B8761),
                    background = Color(0xFFF7F9F7)
                )
            ) {
                RhoyDashboard()
            }
        }
    }
}

@Composable
fun RhoyDashboard() {
    var selectedModule by remember { mutableStateOf("Dashboard") }

    val modules = listOf(
        "Client Management",
        "Project Management",
        "Environmental Impact Assessment",
        "Environmental Auditing",
        "Environmental Monitoring",
        "GIS & GPS Fieldwork",
        "Waste Management",
        "Research & Reports"
    )

    Scaffold(
        containerColor = Color(0xFFF7F9F7),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = selectedModule == "Dashboard",
                    onClick = { selectedModule = "Dashboard" },
                    icon = { Text("⌂") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = selectedModule == "Projects",
                    onClick = { selectedModule = "Projects" },
                    icon = { Text("▤") },
                    label = { Text("Projects") }
                )
                NavigationBarItem(
                    selected = selectedModule == "Services",
                    onClick = { selectedModule = "Services" },
                    icon = { Text("◈") },
                    label = { Text("Services") }
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ForestGreen)
                    .padding(24.dp)
            ) {
                Text(
                    "RHOY",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )

                Text(
                    "ENVIRONMENTAL CONSULTANT",
                    fontSize = 12.sp,
                    color = LightGreen
                )

                Spacer(Modifier.height(22.dp))

                Text(
                    selectedModule,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = White
                )

                Text(
                    "Building a Sustainable Future.",
                    color = LightGreen,
                    fontSize = 13.sp
                )
            }

            Column(Modifier.padding(16.dp)) {
                Text(
                    "Company Overview",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = ForestGreen
                )

                Spacer(Modifier.height(12.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    StatCard("0", "Projects", Modifier.weight(1f))
                    StatCard("0", "Clients", Modifier.weight(1f))
                    StatCard("0", "Reports", Modifier.weight(1f))
                }

                Spacer(Modifier.height(22.dp))

                Text(
                    "Environmental Services",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = ForestGreen
                )

                Spacer(Modifier.height(10.dp))

                modules.forEach { module ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        onClick = { selectedModule = module },
                        colors = CardDefaults.cardColors(
                            containerColor = White
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                module,
                                modifier = Modifier.weight(1f),
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                "›",
                                color = ForestGreen,
                                fontSize = 24.sp
                            )
                        }
                    }
                }

                Spacer(Modifier.height(18.dp))

                Text(
                    "RHOY Environmental Consultant Company LTD",
                    color = ForestGreen,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "Native Android Application · Version 1.0.0",
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun StatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = LightGreen
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                value,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = ForestGreen
            )
            Text(label, fontSize = 11.sp)
        }
    }
}
