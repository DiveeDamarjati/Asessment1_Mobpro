package org.d3if0106.miniproject.screen

import android.media.Image
import android.provider.ContactsContract.Profile
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.d3if0106.miniproject.R
import org.d3if0106.miniproject.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutUs(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.kembali),
                            tint = MaterialTheme.colorScheme.background
                        )
                    }
                },
                title = {
                    Text(text = stringResource(id = R.string.judul_tentang))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.background,
                ),
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            ProfileImage()
            Text(
                text = stringResource(id = R.string.data_diri),
                modifier = Modifier.padding(10.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}



@Composable
fun ProfileImage() {
    Image(
        painter = painterResource(id = R.drawable.divee),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .clip(shape = CircleShape),
        contentScale = ContentScale.Crop
    )
}


