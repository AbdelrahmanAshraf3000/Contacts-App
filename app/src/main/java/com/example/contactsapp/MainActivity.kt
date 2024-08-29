package com.example.contactsapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactsapp.data.DataSource
import com.example.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                val context = LocalContext.current
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Contacts App",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp
                                )
                            },
                            actions = {
                                IconButton(onClick = {
                                    val phoneNumber = Uri.parse("tel: +201012345678")
                                    val i = Intent(Intent.ACTION_DIAL, phoneNumber)
                                    context.startActivity(i)
                                }
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_home),
                                        contentDescription = "Home number"
                                    )

                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    Box ( modifier = Modifier.padding(innerPadding)){
                        ContactInfo(context)
                    }

                }
            }
        }
    }
}

@Composable
fun ContactInfo(context :Context,modifier: Modifier = Modifier) {
    val contacts = DataSource().getContactsData()
    val configuration = LocalConfiguration.current
    LazyVerticalGrid(
        columns = GridCells.Adaptive(130.dp)
    ) {
        items(contacts.size) { item ->
                Card(shape = RectangleShape,
                    modifier = modifier.fillMaxSize()
                        .clickable {

                            val phoneNumber = Uri.parse("tel:" + contacts[item].number)
                            val i = Intent(Intent.ACTION_DIAL, phoneNumber)
                            context.startActivity(i)


                    }
                ) {
                    Image(
                        painter = painterResource(id = contacts[item].image),
                        contentDescription = contacts[item].name,
                        modifier = modifier
                            .align(Alignment.CenterHorizontally)
                            .fillMaxSize()
                    )
                    Text(
                        text = contacts[item].name,
                        textAlign = TextAlign.Center,
                        fontSize = 22.sp,
                        modifier = modifier.fillMaxSize().padding(top = 4.dp),
                        fontWeight = FontWeight.Bold
                    )
                    SelectionContainer() {
                        Text(
                            text = contacts[item].number,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(top = 4.dp)


                        )
                    }

                }
            }

        }


}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContactInfoPreview() {
    val context = LocalContext.current
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Contacts App",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                },
                actions = {
                    IconButton(onClick = {
                        val phoneNumber = Uri.parse("tel: +201012345678")
                        val i = Intent(Intent.ACTION_DIAL, phoneNumber)
                        context.startActivity(i)
                    }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "Home number"
                        )

                    }
                }
            )
        }
    ) { innerPadding ->
        Box ( modifier = Modifier.padding(innerPadding)){
            ContactInfo(context)
        }

    }
}


